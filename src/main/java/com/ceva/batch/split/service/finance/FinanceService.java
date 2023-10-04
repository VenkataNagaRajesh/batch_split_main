package com.ceva.batch.split.service.finance;

import javax.xml.bind.JAXBException;

public interface FinanceService {

  StringBuilder processfinanceService(String request) throws JAXBException, Exception;
}
