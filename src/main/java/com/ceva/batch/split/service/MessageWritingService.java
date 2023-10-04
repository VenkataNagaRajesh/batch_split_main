package com.ceva.batch.split.service;

import java.io.IOException;
import java.net.ProtocolException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import com.ceva.batch.split.exception.BatchSplitException;
import com.ceva.batch.split.jaxb.cwo.UniversalResponseData;

/**
 * MessageWritingService.
 * 
 * @author Narayana
 *
 */
public interface MessageWritingService {

  StringBuilder postUniversalResponseData(String generalLedegerIds,
      String responseData, Date createdOn, StringBuilder message)
      throws KeyManagementException, NoSuchAlgorithmException, ProtocolException,
      BatchSplitException, IOException;

}
