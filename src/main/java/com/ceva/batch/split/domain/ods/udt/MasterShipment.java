package com.ceva.batch.split.domain.ods.udt;

public class MasterShipment {

  private String forwardingConsolKey;

  private String masterBillNumber;

  private String portOfLoading;

  private String portOfDischarge;

  public String getForwardingConsolKey() {
    return forwardingConsolKey;
  }

  public void setForwardingConsolKey(String forwardingConsolKey) {
    this.forwardingConsolKey = forwardingConsolKey;
  }

  public String getMasterBillNumber() {
    return masterBillNumber;
  }

  public void setMasterBillNumber(String masterBillNumber) {
    this.masterBillNumber = masterBillNumber;
  }

  public String getPortOfLoading() {
    return portOfLoading;
  }

  public void setPortOfLoading(String portOfLoading) {
    this.portOfLoading = portOfLoading;
  }

  public String getPortOfDischarge() {
    return portOfDischarge;
  }

  public void setPortOfDischarge(String portOfDischarge) {
    this.portOfDischarge = portOfDischarge;
  }
}
