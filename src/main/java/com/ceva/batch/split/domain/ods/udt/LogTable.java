package com.ceva.batch.split.domain.ods.udt;

import java.util.Date;
import java.util.UUID;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

/**
 * Response info implementation.
 * 
 * @author Laxminarayana
 *
 */

@Table(name = "cfast_bi_log", caseSensitiveTable = false)
public class LogTable {

  @PartitionKey(0)
  @Column(name = "log_id")
  private UUID logId;

  @Column(name = "create_date")
  private Date createdate;

  @Column(name = "src_name")
  private String srcname;

  @Column(name = "log_level")
  private String loglevel;

  @Column(name = "error_info")
  private String errorinfo;

  @Column(name = "payload")
  private String payload;

  @Column(name = "log_message")
  private String logMessage;

  @Column(name = "src_system")
  private String srcSystem;

  public UUID getLogId() {
    return logId;
  }

  public void setLogId(UUID logId) {
    this.logId = logId;
  }

  public Date getCreatedate() {
    return createdate;
  }

  public void setCreatedate(Date createdate) {
    this.createdate = createdate;
  }

  public String getSrcname() {
    return srcname;
  }

  public void setSrcname(String srcname) {
    this.srcname = srcname;
  }

  public String getLoglevel() {
    return loglevel;
  }

  public void setLoglevel(String loglevel) {
    this.loglevel = loglevel;
  }

  public String getErrorinfo() {
    return errorinfo;
  }

  public void setErrorinfo(String errorinfo) {
    this.errorinfo = errorinfo;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public String getLogMessage() {
    return logMessage;
  }

  public void setLogMessage(String logMessage) {
    this.logMessage = logMessage;
  }

  public String getSrcSystem() {
    return srcSystem;
  }

  public void setSrcSystem(String srcSystem) {
    this.srcSystem = srcSystem;
  }


}
