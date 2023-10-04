package com.ceva.batch.split.domain.ods.udt;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorInfoJson implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "error_code")
  private int errorCode;

  @JsonProperty(value = "error_type")
  private String errorType;

  @JsonProperty(value = "error_name")
  private String errorName;

  @JsonProperty(value = "error_message")
  private String errorMessage;

  @JsonProperty(value = "error_stack")
  private String errorStack;

  @JsonProperty(value = "more_info")
  private String moreInfo;

  @JsonProperty(value = "email")
  private String email;

  @JsonProperty(value = "table_name")
  private String tableName;

  @JsonProperty(value = "src_name")
  private String srcName;


  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorType() {
    return errorType;
  }

  public void setErrorType(String errorType) {
    this.errorType = errorType;
  }

  public String getErrorName() {
    return errorName;
  }

  public void setErrorName(String errorName) {
    this.errorName = errorName;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorStack() {
    return errorStack;
  }

  public void setErrorStack(String errorStack) {
    this.errorStack = errorStack;
  }

  public String getMoreInfo() {
    return moreInfo;
  }

  public void setMoreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public String getSrcName() {
    return srcName;
  }

  public void setSrcName(String srcName) {
    this.srcName = srcName;
  }


  public String toString() {
    return errorCode + " " + errorType + " " + errorName + " " + errorMessage;
  }
}
