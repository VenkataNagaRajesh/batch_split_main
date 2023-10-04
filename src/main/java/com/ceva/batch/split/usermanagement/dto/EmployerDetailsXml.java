package com.ceva.batch.split.usermanagement.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.bind.annotation.RequestMapping;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

/**
 * EmployerDetailsXml  class.
 * 
 * @author shaik.
 *
 */


@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployerDetailsXml {
  int employerSno;
  String previousCompanyName;
  String previousCompanyAdrress;
  String previousEmpType;
  String previousEmpDesignation;
  String reportingPersonName;
  String repostingPersonPosition;
  String reportingPersonContact;
  java.util.Date previousEmploymentPeriodFrom;
  java.util.Date previousEmploymentPeriodTo;
  String previousEmpId;
  String leavingReason;
  String leaveMode;
  String lastSalary;
  String paySlips;
  String form16;
  String relievingLetter;
  String appointmentLetter;
  String empId;


  /**
   * superClass Constructor.
   */
  public EmployerDetailsXml() {

  }

  /**
   * constructor.
   */
  public EmployerDetailsXml(int employerSno, String previousCompanyName,
      String previousCompanyAdrress, String previousEmpType, String previousEmpDesignation,
      String reportingPersonName, String repostingPersonPosition, String reportingPersonContact,
      java.util.Date previousEmploymentPeriodFrom, java.util.Date previousEmploymentPeriodTo,
      String previousEmpId, String leavingReason, String leaveMode, String lastSalary,
      String paySlips, String form16, String relievingLetter, String appointmentLetter,
      String empId) {
    super();
    this.employerSno = employerSno;
    this.previousCompanyName = previousCompanyName;
    this.previousCompanyAdrress = previousCompanyAdrress;
    this.previousEmpType = previousEmpType;
    this.previousEmpDesignation = previousEmpDesignation;
    this.reportingPersonName = reportingPersonName;
    this.repostingPersonPosition = repostingPersonPosition;
    this.reportingPersonContact = reportingPersonContact;
    this.previousEmploymentPeriodFrom = previousEmploymentPeriodFrom;
    this.previousEmploymentPeriodTo = previousEmploymentPeriodTo;
    this.previousEmpId = previousEmpId;
    this.leavingReason = leavingReason;
    this.leaveMode = leaveMode;
    this.lastSalary = lastSalary;
    this.paySlips = paySlips;
    this.form16 = form16;
    this.relievingLetter = relievingLetter;
    this.appointmentLetter = appointmentLetter;
    this.empId = empId;
  }

  public int getEmployerSno() {
    return employerSno;
  }

  public void setEmployerSno(int employerSno) {
    this.employerSno = employerSno;
  }

  public String getPreviousCompanyName() {
    return previousCompanyName;
  }

  public void setPreviousCompanyName(String previousCompanyName) {
    this.previousCompanyName = previousCompanyName;
  }

  public String getPreviousCompanyAdrress() {
    return previousCompanyAdrress;
  }

  public void setPreviousCompanyAdrress(String previousCompanyAdrress) {
    this.previousCompanyAdrress = previousCompanyAdrress;
  }

  public String getPreviousEmpType() {
    return previousEmpType;
  }

  public void setPreviousEmpType(String previousEmpType) {
    this.previousEmpType = previousEmpType;
  }

  public String getPreviousEmpDesignation() {
    return previousEmpDesignation;
  }

  public void setPreviousEmpDesignation(String previousEmpDesignation) {
    this.previousEmpDesignation = previousEmpDesignation;
  }

  public String getReportingPersonName() {
    return reportingPersonName;
  }

  public void setReportingPersonName(String reportingPersonName) {
    this.reportingPersonName = reportingPersonName;
  }

  public String getRepostingPersonPosition() {
    return repostingPersonPosition;
  }

  public void setRepostingPersonPosition(String repostingPersonPosition) {
    this.repostingPersonPosition = repostingPersonPosition;
  }

  public String getReportingPersonContact() {
    return reportingPersonContact;
  }

  public void setReportingPersonContact(String reportingPersonContact) {
    this.reportingPersonContact = reportingPersonContact;
  }

  public java.util.Date getPreviousEmploymentPeriodFrom() {
    return previousEmploymentPeriodFrom;
  }

  public void setPreviousEmploymentPeriodFrom(java.util.Date previousEmploymentPeriodFrom) {
    this.previousEmploymentPeriodFrom = previousEmploymentPeriodFrom;
  }

  public java.util.Date getPreviousEmploymentPeriodTo() {
    return previousEmploymentPeriodTo;
  }

  public void setPreviousEmploymentPeriodTo(java.util.Date previousEmploymentPeriodTo) {
    this.previousEmploymentPeriodTo = previousEmploymentPeriodTo;
  }

  public String getPreviousEmpId() {
    return previousEmpId;
  }

  public void setPreviousEmpId(String previousEmpId) {
    this.previousEmpId = previousEmpId;
  }

  public String getLeavingReason() {
    return leavingReason;
  }

  public void setLeavingReason(String leavingReason) {
    this.leavingReason = leavingReason;
  }

  public String getLeaveMode() {
    return leaveMode;
  }

  public void setLeaveMode(String leaveMode) {
    this.leaveMode = leaveMode;
  }

  public String getLastSalary() {
    return lastSalary;
  }

  public void setLastSalary(String lastSalary) {
    this.lastSalary = lastSalary;
  }

  public String getPaySlips() {
    return paySlips;
  }

  public void setPaySlips(String paySlips) {
    this.paySlips = paySlips;
  }

  public String getForm16() {
    return form16;
  }

  public void setForm16(String form16) {
    this.form16 = form16;
  }

  public String getRelievingLetter() {
    return relievingLetter;
  }

  public void setRelievingLetter(String relievingLetter) {
    this.relievingLetter = relievingLetter;
  }

  public String getAppointmentLetter() {
    return appointmentLetter;
  }

  public void setAppointmentLetter(String appointmentLetter) {
    this.appointmentLetter = appointmentLetter;
  }

  public String getEmpId() {
    return empId;
  }

  public void setEmpId(String empId) {
    this.empId = empId;
  }

  @Override
  public String toString() {
    return "EmployerDetailsXml [employerSno=" + employerSno + ", previousCompanyName="
        + previousCompanyName + ", previousCompanyAdrress=" + previousCompanyAdrress
        + ", previousEmpType=" + previousEmpType + ", previousEmpDesignation="
        + previousEmpDesignation + ", reportingPersonName=" + reportingPersonName
        + ", repostingPersonPosition=" + repostingPersonPosition + ", reportingPersonContact="
        + reportingPersonContact + ", previousEmploymentPeriodFrom=" + previousEmploymentPeriodFrom
        + ", previousEmploymentPeriodTo=" + previousEmploymentPeriodTo + ", previousEmpId="
        + previousEmpId + ", leavingReason=" + leavingReason + ", leaveMode=" + leaveMode
        + ", lastSalary=" + lastSalary + ", paySlips=" + paySlips + ", form16=" + form16
        + ", relievingLetter=" + relievingLetter + ", appointmentLetter=" + appointmentLetter
        + ", empId=" + empId + "]";
  }

}
