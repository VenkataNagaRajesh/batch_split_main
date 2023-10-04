package com.ceva.batch.split.rest.usermanagement.inbound.dto;

import java.util.Date;
import javax.persistence.Column;
import org.springframework.stereotype.Component;
import com.datastax.driver.core.LocalDate;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

/*
 * 
 * 
 */
@Component
public class EmployeAddtionalDetailsInBoundXml {
  private String empId;
  private String passportNo;
  private Date passportExpiryDate;
  private String visaRejectedStatus;
  private Date visaRejectedDate;
  private String visaRejectedReason;
  private String visaRejectedCountry;
  private String panNo;
  private String itPanNo;
  private String drivingLicenseNo;
  private Date drivingLicenseValidDate;
  private String refernceStatus;
  private String referedPersonName;
  private String referedPersonOrg;
  private String referedPersonDesignation;
  private String referedPersonAddress;
  private String referedPersonContact;
  private String referedpersonEmail;

  public String getEmpId() {
    return empId;
  }

  public void setEmpId(String empId) {
    this.empId = empId;
  }

  public String getPassportNo() {
    return passportNo;
  }

  public void setPassportNo(String passportNo) {
    this.passportNo = passportNo;
  }

  public Date getPassportExpiryDate() {
    return passportExpiryDate;
  }

  public void setPassportExpiryDate(Date passportExpiryDate) {
    this.passportExpiryDate = passportExpiryDate;
  }

  public String getVisaRejectedStatus() {
    return visaRejectedStatus;
  }

  public void setVisaRejectedStatus(String visaRejectedStatus) {
    this.visaRejectedStatus = visaRejectedStatus;
  }

  public Date getVisaRejectedDate() {
    return visaRejectedDate;
  }

  public void setVisaRejectedDate(Date visaRejectedDate) {
    this.visaRejectedDate = visaRejectedDate;
  }

  public String getVisaRejectedReason() {
    return visaRejectedReason;
  }

  public void setVisaRejectedReason(String visaRejectedReason) {
    this.visaRejectedReason = visaRejectedReason;
  }

  public String getVisaRejectedCountry() {
    return visaRejectedCountry;
  }

  public void setVisaRejectedCountry(String visaRejectedCountry) {
    this.visaRejectedCountry = visaRejectedCountry;
  }

  public String getPanNo() {
    return panNo;
  }

  public void setPanNo(String panNo) {
    this.panNo = panNo;
  }

  public String getItPanNo() {
    return itPanNo;
  }

  public void setItPanNo(String itPanNo) {
    this.itPanNo = itPanNo;
  }

  public String getDrivingLicenseNo() {
    return drivingLicenseNo;
  }

  public void setDrivingLicenseNo(String drivingLicenseNo) {
    this.drivingLicenseNo = drivingLicenseNo;
  }

  public Date getDrivingLicenseValidDate() {
    return drivingLicenseValidDate;
  }

  public void setDrivingLicenseValidDate(Date drivingLicenseValidDate) {
    this.drivingLicenseValidDate = drivingLicenseValidDate;
  }

  public String getRefernceStatus() {
    return refernceStatus;
  }

  public void setRefernceStatus(String refernceStatus) {
    this.refernceStatus = refernceStatus;
  }

  public String getReferedPersonName() {
    return referedPersonName;
  }

  public void setReferedPersonName(String referedPersonName) {
    this.referedPersonName = referedPersonName;
  }

  public String getReferedPersonOrg() {
    return referedPersonOrg;
  }

  public void setReferedPersonOrg(String referedPersonOrg) {
    this.referedPersonOrg = referedPersonOrg;
  }

  public String getReferedPersonDesignation() {
    return referedPersonDesignation;
  }

  public void setReferedPersonDesignation(String referedPersonDesignation) {
    this.referedPersonDesignation = referedPersonDesignation;
  }

  public String getReferedPersonAddress() {
    return referedPersonAddress;
  }

  public void setReferedPersonAddress(String referedPersonAddress) {
    this.referedPersonAddress = referedPersonAddress;
  }

  public String getReferedPersonContact() {
    return referedPersonContact;
  }

  public void setReferedPersonContact(String referedPersonContact) {
    this.referedPersonContact = referedPersonContact;
  }

  public String getReferedpersonEmail() {
    return referedpersonEmail;
  }

  public void setReferedpersonEmail(String referedpersonEmail) {
    this.referedpersonEmail = referedpersonEmail;
  }

}
