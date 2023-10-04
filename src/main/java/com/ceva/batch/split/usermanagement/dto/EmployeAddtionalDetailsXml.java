package com.ceva.batch.split.usermanagement.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * EmployeAddtionalDetailsXml class to accept the xml input.
 * @author rajesh
 *
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)

public class EmployeAddtionalDetailsXml {
  @Id
  private String empId;
  @Column(name = "passport_no")
  private String passportNo;
  @Column(name = "passport_expiry_date")
  private Date passportExpiryDate;
  @Column(name = "visa_rejected_status")
  private String visaRejectedStatus;
  @Column(name = "visa_rejected_date")
  private Date visaRejectedDate;
  @Column(name = "visa_rejected_reason")
  private String visaRejectedReason;
  @Column(name = "visa_rejected_country")
  private String visaRejectedCountry;
  @Column(name = "panNo")
  private String panNo;
  @Column(name = "it_pan_no")
  private String itPanNo;
  @Column(name = "driving_license_no")
  private String drivingLicenseNo;
  @Column(name = "driving_license_valid_date")
  private Date drivingLicenseValidDate;
  @Column(name = "reference_status")
  private String refernceStatus;
  @Column(name = "refered_person_name")
  private String referedPersonName;
  @Column(name = "refered_person_org")
  private String referedPersonOrg;
  @Column(name = "refered_person_designation")
  private String referedPersonDesignation;
  @Column(name = "refered_person_address")
  private String referedPersonAddress;
  @Column(name = "refered_person_contact")
  private String referedPersonContact;
  @Column(name = "refered_person_email")
  private String referedpersonEmail;

  /**
   * constructor.
   * 
   * 
   */
  public EmployeAddtionalDetailsXml(String empId, String passportNo, Date passportExpiryDate,
      String visaRejectedStatus, Date visaRejectedDate, String visaRejectedReason,
      String visaRejectedCountry, String panNo, String itPanNo, String drivingLicenseNo,
      Date drivingLicenseValidDate, String refernceStatus, String referedPersonName,
      String referedPersonOrg, String referedPersonDesignation, String referedPersonAddress,
      String referedPersonContact, String referedpersonEmail) {
    super();
    this.empId = empId;
    this.passportNo = passportNo;
    this.passportExpiryDate = passportExpiryDate;
    this.visaRejectedStatus = visaRejectedStatus;
    this.visaRejectedDate = visaRejectedDate;
    this.visaRejectedReason = visaRejectedReason;
    this.visaRejectedCountry = visaRejectedCountry;
    this.panNo = panNo;
    this.itPanNo = itPanNo;
    this.drivingLicenseNo = drivingLicenseNo;
    this.drivingLicenseValidDate = drivingLicenseValidDate;
    this.refernceStatus = refernceStatus;
    this.referedPersonName = referedPersonName;
    this.referedPersonOrg = referedPersonOrg;
    this.referedPersonDesignation = referedPersonDesignation;
    this.referedPersonAddress = referedPersonAddress;
    this.referedPersonContact = referedPersonContact;
    this.referedpersonEmail = referedpersonEmail;
  }

  public EmployeAddtionalDetailsXml() {
    // TODO Auto-generated constructor stub
  }

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

  public void setPassportExpiryDate(Date passportExpiryDate2) {
    this.passportExpiryDate = passportExpiryDate2;
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

  public void setVisaRejectedDate(Date drivingLicenseValidDate2) {
    this.visaRejectedDate = drivingLicenseValidDate2;
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

  public void setDrivingLicenseValidDate(Date drivingLicenseValidDate2) {
    this.drivingLicenseValidDate = drivingLicenseValidDate2;
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
