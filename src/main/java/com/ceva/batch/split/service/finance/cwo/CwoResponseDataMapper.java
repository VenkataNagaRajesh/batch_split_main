package com.ceva.batch.split.service.finance.cwo;

import java.io.IOException;
import java.net.ProtocolException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.JAXBElement;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceva.batch.split.domain.ods.udt.SourceSpecificObejct;
import com.ceva.batch.split.exception.BatchSplitException;
import com.ceva.batch.split.jaxb.cwo.TransactionInfo;
import com.ceva.batch.split.jaxb.cwo.UniversalResponseData;
import com.ceva.batch.split.jaxb.cwo.UniversalTransactionBatchData;
import com.ceva.batch.split.service.MessageWritingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CwoResponseDataMapper {

  private static final Logger LOGGER = LoggerFactory.getLogger(CwoResponseDataMapper.class);

  private ObjectMapper mapper =
      new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  @Autowired
  MessageWritingService messageWritingService;

  /**
   * processUnifiedResponseData.
   * 
   * @param sourceSpecificObejct UniversalResponseData
   * @param sequentialNumber sequentialNumber
   * @return UniversalResponseData
   * @throws BatchSplitException BatchSplitException
   * @throws IOException IOException
   * @throws ProtocolException ProtocolException
   * @throws NoSuchAlgorithmException NoSuchAlgorithmException
   * @throws KeyManagementException KeyManagementException
   * @throws JsonProcessingException JsonProcessingException
   */
  public List<UniversalResponseData> processUnifiedResponseData(
      SourceSpecificObejct sourceSpecificObejct, Integer sequentialNumber)
      throws JsonProcessingException, KeyManagementException, NoSuchAlgorithmException,
      ProtocolException, IOException, BatchSplitException {

    UniversalResponseData singleUniversalResponseData =
        sourceSpecificObejct.getUniversalResponseData();
    List<UniversalResponseData> outboundUniversalResponseData =
        new ArrayList<UniversalResponseData>();
    LOGGER.debug("get the message");
    /// UniversalResponse/Data/UniversalTransactionBatch/TransactionBatch/TransactionCollection/Transaction/LoopIterNumber

    if (Objects.nonNull(sourceSpecificObejct.getUniversalResponseData())
        && Objects.nonNull(sourceSpecificObejct.getUniversalResponseData().getData())) {
      UniversalTransactionBatchData transactionData =
          ((JAXBElement<UniversalTransactionBatchData>) sourceSpecificObejct
              .getUniversalResponseData().getData().getAny()).getValue();
      if (Objects.nonNull(transactionData) && Objects.nonNull(transactionData.getTransactionBatch())
          && Objects.nonNull(transactionData.getTransactionBatch().getTransactionCollection())
          && CollectionUtils.isNotEmpty(
              transactionData.getTransactionBatch().getTransactionCollection().getTransaction())) {
        Date createdOn = new Date();

        for (TransactionInfo transaction : transactionData.getTransactionBatch()
            .getTransactionCollection().getTransaction()) {
          transaction.setLoopIterNumber(sequentialNumber);
          UniversalTransactionBatchData copytransactionData =
              ((JAXBElement<UniversalTransactionBatchData>) sourceSpecificObejct
                  .getUniversalResponseData().getData().getAny()).getValue();
          copytransactionData.getTransactionBatch().getTransactionCollection().getTransaction()
              .clear();
          copytransactionData.getTransactionBatch().getTransactionCollection().getTransaction()
              .add(transaction);
          ((JAXBElement<UniversalTransactionBatchData>) singleUniversalResponseData.getData()
              .getAny()).setValue(copytransactionData);
          LOGGER.debug("Transaction");
          outboundUniversalResponseData.add(singleUniversalResponseData);

        }
      }
      return outboundUniversalResponseData;
    }
    return null;
  }
}
