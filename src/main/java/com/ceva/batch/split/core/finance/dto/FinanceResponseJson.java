package com.ceva.batch.split.core.finance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinanceResponseJson {

  @JsonProperty(value = "amount")
  private String amount;
  @JsonProperty(value = "business_unit")
  private String businessUnit;
  @JsonProperty(value = "created_on")
  private String createdOn;
  @JsonProperty(value = "creation_date")
  private String creationDate;
  @JsonProperty(value = "creation_time")
  private String creationTime;
  @JsonProperty(value = "currency_code")
  private String currencyCode;
  @JsonProperty(value = "description")
  private String description;
  @JsonProperty(value = "gl_code")
  private String glCode;
  @JsonProperty(value = "gl_date")
  private String glDate;
  @JsonProperty(value = "id")
  private String id;
  @JsonProperty(value = "jde_company")
  private String jdeCompany;
  @JsonProperty(value = "job_number")
  private String jobNumber;
  @JsonProperty(value = "sequential_number")
  private String sequentialNumber;
  @JsonProperty(value = "source")
  private String source;
  @JsonProperty(value = "source_payload")
  private String sourcePayload;
  @JsonProperty(value = "unique_batch_no")
  private String uniqueBatchNo;
  @JsonProperty(value = "user_id")
  private String userId;
  @JsonProperty(value = "voucher_number")
  private String voucherNumber;

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getBusinessUnit() {
    return businessUnit;
  }

  public void setBusinessUnit(String businessUnit) {
    this.businessUnit = businessUnit;
  }

  public String getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(String createdOn) {
    this.createdOn = createdOn;
  }

  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public String getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(String creationTime) {
    this.creationTime = creationTime;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getGlCode() {
    return glCode;
  }

  public void setGlCode(String glCode) {
    this.glCode = glCode;
  }

  public String getGlDate() {
    return glDate;
  }

  public void setGlDate(String glDate) {
    this.glDate = glDate;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getJdeCompany() {
    return jdeCompany;
  }

  public void setJdeCompany(String jdeCompany) {
    this.jdeCompany = jdeCompany;
  }

  public String getJobNumber() {
    return jobNumber;
  }

  public void setJobNumber(String jobNumber) {
    this.jobNumber = jobNumber;
  }

  public String getSequentialNumber() {
    return sequentialNumber;
  }

  public void setSequentialNumber(String sequentialNumber) {
    this.sequentialNumber = sequentialNumber;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getSourcePayload() {
    return sourcePayload;
  }

  public void setSourcePayload(String sourcePayload) {
    this.sourcePayload = sourcePayload;
  }

  public String getUniqueBatchNo() {
    return uniqueBatchNo;
  }

  public void setUniqueBatchNo(String uniqueBatchNo) {
    this.uniqueBatchNo = uniqueBatchNo;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getVoucherNumber() {
    return voucherNumber;
  }

  public void setVoucherNumber(String voucherNumber) {
    this.voucherNumber = voucherNumber;
  }
}
