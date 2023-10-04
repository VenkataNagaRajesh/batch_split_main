package com.ceva.batch.split.service;

import java.io.IOException;
import java.net.ProtocolException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Objects;
import javax.ws.rs.core.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ceva.batch.split.common.Constant;
import com.ceva.batch.split.exception.BatchSplitException;
import com.ceva.batch.split.jaxb.cwo.UniversalResponseData;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Connecting to CAL kafka for writing the LWM.
 * 
 * @author Laxminarayana
 *
 */
@Service
public class MessageWritingServiceImpl implements MessageWritingService {

  @Autowired
  private RestTemplate restTemplate;

  private static final Logger LOGGER = LoggerFactory.getLogger(MessageWritingServiceImpl.class);

  private ObjectMapper mapper =
      new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  @Value("${batch.split.publish.to.topic:YES}")
  private String writeCfastbiMessageToTopic;

  @Value("${batch.split.KafkaTopicPublisher}")
  private String batchSplitKafkaTopicUrl;

  @Override
  public StringBuilder postUniversalResponseData(String generalLedegerIds,
      String universalResponseData, Date createdOn, StringBuilder message)
      throws KeyManagementException, NoSuchAlgorithmException, ProtocolException,
      BatchSplitException, IOException {
    if (Objects.nonNull(universalResponseData)
        && Constant.YES.equalsIgnoreCase(writeCfastbiMessageToTopic)) {
      return postUniversalResponseData(generalLedegerIds, universalResponseData, message,
          batchSplitKafkaTopicUrl);
    }
    return message;
  }

  private StringBuilder postUniversalResponseData(String generalLedegerIds,
      String universalResponseData, StringBuilder message, String batchSplitKafkaTopicUrl)
      throws BatchSplitException, KeyManagementException, NoSuchAlgorithmException,
      ProtocolException, IOException {
    LOGGER.debug("Batch split Full message Response : {}", universalResponseData);
    String messagingresponse = null;
    // String shipmentServiceFullJson = mapper.writeValueAsString(universalResponseData);
    messagingresponse =
        postToTopic(universalResponseData, batchSplitKafkaTopicUrl, null, generalLedegerIds);
    LOGGER.info("Stored LWM in CFast-Bi topic: Response:  " + messagingresponse);
    message.append("Batch split is processed : ").append(" LWM from source system ")
        .append(" processed successfully for the general_ledeger_id: " + generalLedegerIds);
    if (Constant.WRITE_TO_TOPIC_FAILED.equalsIgnoreCase(messagingresponse)) {
      throw new BatchSplitException(Constant.WRITE_TO_TOPIC_FAILED, null, Constant.CfastBi_TABLE,
          LogLevel.FATAL.name());
    } else if (Constant.NO_TOPIC_FOUND.equalsIgnoreCase(messagingresponse)) {
      throw new BatchSplitException(Constant.NO_TOPIC_FOUND, null, Constant.CfastBi_TABLE,
          LogLevel.FATAL.name());
    }
    return message;
  }

  private String postToTopic(String request, String postUrl, String mediaType,
      String kafkaMessageKey)
      throws KeyManagementException, NoSuchAlgorithmException, ProtocolException, IOException {
    try {
      if (postUrl != null) {
        if (LOGGER.isDebugEnabled()) {
          LOGGER.debug("Before Message Post to .... " + postUrl);
        }
        ResponseEntity<String> result = postRequest(request, postUrl, null, null, kafkaMessageKey);
        if (Objects.nonNull(result)) {
          LOGGER.info(" result :  " + result);
          String resultBody = result.getBody();
          if (result.getStatusCodeValue() == Response.Status.OK.getStatusCode()) {
            if (Objects.nonNull(resultBody)) {
              return resultBody.toString();
            }
          } else if (result.getStatusCodeValue() != Response.Status.NOT_FOUND.getStatusCode()) {
            if (Objects.nonNull(resultBody)) {
              return Constant.WRITE_TO_TOPIC_FAILED + " Due to : " + resultBody.toString();
            }
          }
        }
      } else {
        return Constant.NO_TOPIC_FOUND;
      }
    } catch (Exception ex) {
      LOGGER.error("Exception while writing LWM to the topic: " + ex.fillInStackTrace());
      throw ex;
    }
    return "No response message from ActiveMQ/Kafka";
  }

  private ResponseEntity<String> postRequest(String request, String url, String userName,
      String password, String kafkaMessageKey) {
    HttpHeaders httpHeaders = new HttpHeaders();
    if (StringUtils.isNoneEmpty(userName) && StringUtils.isNoneEmpty(password)) {
      byte[] userPasswordBytes = (userName + ":" + password).getBytes();
      String basicAuth = "Basic " + new String(Base64.encodeBase64(userPasswordBytes));
      httpHeaders.set("Authorization", basicAuth);
    }
    httpHeaders.set("kafka_message_key", kafkaMessageKey);
    httpHeaders.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
    httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    HttpEntity<String> registrationEntity = new HttpEntity<String>(request, httpHeaders);

    ResponseEntity<String> result =
        restTemplate.exchange(url, HttpMethod.POST, registrationEntity, String.class);
    LOGGER.debug(" response");
    return result;
  }
}
