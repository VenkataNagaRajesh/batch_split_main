package com.ceva.batch.split.inbound.cbd;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"general_ledeger_ids", "source_system", "created_on"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class FinanceLwm implements Serializable {
  @JsonProperty(value = "general_ledeger_ids")
  private String generalLedegerIds;
  @JsonProperty(value = "source_system")
  private String sourceSystem;
  @JsonProperty(value = "created_on")
  private String createdOn;

  public String getGeneralLedegerIds() {
    return generalLedegerIds;
  }

  public void setGeneralLedegerIds(String generalLedegerIds) {
    this.generalLedegerIds = generalLedegerIds;
  }

  public String getSourceSystem() {
    return sourceSystem;
  }

  public void setSourceSystem(String sourceSystem) {
    this.sourceSystem = sourceSystem;
  }

  public String getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(String createdOn) {
    this.createdOn = createdOn;
  }



}
