package com.ceva.batch.split.service.finance;

import java.util.Date;
import java.util.List;

import java.util.Objects;

import javax.xml.bind.JAXBContext;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceva.batch.split.common.Constant;
import com.ceva.batch.split.core.finance.dto.FinanceResponseJson;
import com.ceva.batch.split.domain.ods.udt.SourceSpecificObejct;
import com.ceva.batch.split.enums.DestinationEnum;
import com.ceva.batch.split.inbound.cbd.FinanceLwm;
import com.ceva.batch.split.jaxb.cwo.UniversalResponseData;
import com.ceva.batch.split.service.MessageWritingService;
import com.ceva.batch.split.service.finance.cwo.CwoResponseDataMapper;
import com.ceva.cfastbi.common.CommonUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FinanceServiceImpl implements FinanceService {
  private static final Logger LOGGER = LoggerFactory.getLogger(FinanceServiceImpl.class);
  private ObjectMapper mapper =
      new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  private static JAXBContext universalRespondJaxbContext = null;

  @Value("${cbd.transaction.api}")

  private String cbdTransactionApi;
  @Autowired
  CwoResponseDataMapper cwoResponseDataMapper;

  @Autowired
  MessageWritingService messageWritingService;

  @Override
  public StringBuilder processfinanceService(String request) throws Exception {

    FinanceLwm financeLwm = mapper.readValue(request, FinanceLwm.class);
    if (StringUtils.isNotBlank(financeLwm.getGeneralLedegerIds())) {
      FinanceResponseJson financeResponseJson =
          getFinanceResponseByLedgerId(financeLwm.getGeneralLedegerIds());
      Integer sequentialNumber = 0;
      if (StringUtils.isNotBlank(financeResponseJson.getSequentialNumber())) {
        sequentialNumber = Integer.parseInt(financeResponseJson.getSequentialNumber());
      } else {
        sequentialNumber = 0;
      }
      if (StringUtils.isNotBlank(financeLwm.getGeneralLedegerIds())) {
        SourceSpecificObejct sourceSpecificObejct =
            retrieveSourceSpecificObject(financeResponseJson);
        if (Objects.nonNull(sourceSpecificObejct)) {
          List<UniversalResponseData> universalResponseData = cwoResponseDataMapper
              .processUnifiedResponseData(sourceSpecificObejct, sequentialNumber);
          if (CollectionUtils.isNotEmpty(universalResponseData)) {
            StringBuilder message = new StringBuilder();
            for (UniversalResponseData responseData : universalResponseData) {
              String responce = CommonUtils.getPayloadForCwoGeneralLegger(responseData);
              Date createdOn = new Date();
              messageWritingService.postUniversalResponseData(financeLwm.getGeneralLedegerIds(),
                  responce, createdOn, message);
            }
            return message;
          }
        }
      }
    }
    return null;

  }

  private FinanceResponseJson getFinanceResponseByLedgerId(String generalLedegerIds)
      throws Exception {
    String responseString = getFinanceByLedgerId(generalLedegerIds);
    FinanceResponseJson financeResponseJson = null;
    if (responseString != null && !responseString.isEmpty()
        && !Constant.NO_RESULTS_FOUND.equalsIgnoreCase(responseString)) {
      financeResponseJson = mapper.readValue(responseString, FinanceResponseJson.class);
    } else {
      // throw new BatchSplitException(
      // "GeneralLedegerIds data is not available to " + generalLedegerIds,
      // DestinationEnum.FINANCE.toString(), Constant.BATCH, LogLevel.INFO.toString());
    }
    return financeResponseJson;
  }

  private SourceSpecificObejct retrieveSourceSpecificObject(FinanceResponseJson financeResponseJson)
      throws Exception {
    if (Objects.nonNull(financeResponseJson)) {
      SourceSpecificObejct sourceSpecificObejct = new SourceSpecificObejct();

      if (StringUtils.isNoneBlank(financeResponseJson.getSourcePayload())) {
        sourceSpecificObejct.setUniversalResponseData(CommonUtils
            .convertCwoBatchStringToXmlObject(financeResponseJson.getSourcePayload(), null));
      } else {
        LOGGER.warn("UnKnown SourceSytem : {} is received");

      }
      return sourceSpecificObejct;
    }
    return null;
  }

  private String getFinanceByLedgerId(String generalLedegerIds) throws Exception {
    StringBuilder baseUrl = buildFinanceServiceUrl(generalLedegerIds);
    LOGGER.debug("Get transportLeg by TL ID : {} and SystemID :{} from  {} service",
        generalLedegerIds, baseUrl);
    String responseString = CommonUtils.callReadEndpoint(baseUrl.toString(), false,
        DestinationEnum.TRANSPORTLEG.name());
    LOGGER.debug("Transportleg Service with Transportleg id : {}\", transportLegId");
    return responseString;
  }

  private StringBuilder buildFinanceServiceUrl(String generalLedegerIds) throws Exception {
    if (StringUtils.isBlank(cbdTransactionApi)) {
      LOGGER.debug(
          "*****Finance Service URL is empty. Please Config URL in environment variables*****");
    } else {
      if (StringUtils.isNotBlank(generalLedegerIds)) {
        return new StringBuilder(cbdTransactionApi.trim())
            .append("/" + CommonUtils.encodeValue(generalLedegerIds.trim()));

      }
    }
    return new StringBuilder();
  }

}
