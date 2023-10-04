package com.ceva.batch.split.enums;

public enum LoggerEnum {

  LOGERROR_2000(2000, "Logical", "EJBException",
      "Object/Value Should not be null,bean encountered a non-application exception and nested exception is NullPointerException"), LOGERROR_2001(
          2001, "Logical", "NullPointerException",
          "Object/Value Should not be null - NullPointerException"), LOGERROR_2002(2002, "Logical",
              "JsonParseException",
              "Cannot parse the Json file,Json file field values are incorrect-MapperException"), LOGERROR_2003(
                  2003, "Logical", "IOException",
                  "Cannot parse the XML file,XML file field values are incorrect or MapperException"), LOGERROR_2004(
                      2004, "Logical", "JAXBException",
                      "Cannot parse the XML file,XML file field values are incorrect or MapperException"), LOGERROR_2005(
                          2005, "Logical", "Exception", "Cannot save the record - Exception");

  private int errorCode;
  private String errorType;
  private String errorName;
  private String errorMessage;

  private String errorStack;
  private String moreInfo;
  private String email;
  private String tableName;
  private String srcName;
  private Throwable errorCause;

  /**
   * getErrorInfo.
   * 
   * @param errorCode text
   * @return
   */
  public static LoggerEnum find(int errorCode) {
    for (LoggerEnum loggerEnum : LoggerEnum.values()) {
      if (loggerEnum.getErrorCode() == errorCode) {
        return loggerEnum;
      }
    }
    return null;
  }

  /**
   * getErrorInfo.
   * 
   * @param errorCode text
   * @param errorStack text
   * @param errorCause text
   * @return
   */
  public static LoggerEnum getErrorInfo(int errorCode, String errorStack, String errorCause,
      String tableName, String srcName) {
    LoggerEnum loggerEnum = LoggerEnum.find(errorCode);
    if (loggerEnum != null) {
      loggerEnum.setTableName(tableName);
      if (null != errorCause) {
        loggerEnum.setMoreInfo(errorCause);
      } else {
        loggerEnum.setMoreInfo(null);
      }
      loggerEnum.setErrorStack(errorStack);
      loggerEnum.setSrcName(srcName);
      loggerEnum.setTableName(tableName);
    }
    return loggerEnum;
  }

  private LoggerEnum(int errorCode, String errorType, String errorName, String errorMessage) {
    this.errorCode = errorCode;
    this.errorType = errorType;
    this.errorMessage = errorMessage;
    this.errorName = errorName;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public String getErrorType() {
    return errorType;
  }

  public String getErrorName() {
    return errorName;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public String getErrorStack() {
    return errorStack;
  }

  private void setErrorStack(String errorStack) {
    this.errorStack = errorStack;
  }

  public String getMoreInfo() {
    return moreInfo;
  }

  private void setMoreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
  }

  public String getEmail() {
    return email;
  }

  public String getTableName() {
    return tableName;
  }

  private void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public String getSrcName() {
    return srcName;
  }

  private void setSrcName(String srcName) {
    this.srcName = srcName;
  }

  public Throwable getErrorCause() {
    return errorCause;
  }

}
