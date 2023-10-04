package com.ceva.batch.split.usermanagement.dto;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

/**
 * Personal details xml Table.
 * 
 * @author shaik.
 *
 */


@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonalDetailsXml {
  int employeeId;
  String primarySkill;
  String birthPlace;
  String fatherName;
  String motherMaidenName;
  String personalEmail;
  String presentAddress;
  java.util.Date presentAddressFromDate;
  java.util.Date permanentAddressFromDate;
  java.util.Date presentAddressToDate;
  java.util.Date permanentAddressToDate;
  String title;
  String natiionality;
  String maidenName;
  String motherName;
  java.util.Date dob;
  String alternateEmail;
  String permanentAddress;


  /**
   * zero parameterized constructor.
   */
  public PersonalDetailsXml() {
    super();
    // TODO Auto-generated constructor stub
  }


  /**
   * constructor.
   * 
   */
  public PersonalDetailsXml(int employeeId, String primarySkill, String birthPlace,
      String fatherName, String motherMaidenName, String personalEmail, String presentAddress,
      Date presentAddressFromDate, Date permanentAddressFromDate, Date presentAddressToDate,
      Date permanentAddressToDate, String title, String natiionality, String maidenName,
      String motherName, Date dob, String alternateEmail, String permanentAddress) {
    this.employeeId = employeeId;
    this.primarySkill = primarySkill;
    this.birthPlace = birthPlace;
    this.fatherName = fatherName;
    this.motherMaidenName = motherMaidenName;
    this.personalEmail = personalEmail;
    this.presentAddress = presentAddress;
    this.presentAddressFromDate = presentAddressFromDate;
    this.permanentAddressFromDate = permanentAddressFromDate;
    this.presentAddressToDate = presentAddressToDate;
    this.permanentAddressToDate = permanentAddressToDate;
    this.title = title;
    this.natiionality = natiionality;
    this.maidenName = maidenName;
    this.motherName = motherName;
    this.dob = dob;
    this.alternateEmail = alternateEmail;
    this.permanentAddress = permanentAddress;
  }


  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getPrimarySkill() {
    return primarySkill;
  }

  public void setPrimarySkill(String primarySkill) {
    this.primarySkill = primarySkill;
  }

  public String getBirthPlace() {
    return birthPlace;
  }

  public void setBirthPlace(String birthPlace) {
    this.birthPlace = birthPlace;
  }

  public String getFatherName() {
    return fatherName;
  }

  public void setFatherName(String fatherName) {
    this.fatherName = fatherName;
  }

  public String getMotherMaidenName() {
    return motherMaidenName;
  }

  public void setMotherMaidenName(String motherMaidenName) {
    this.motherMaidenName = motherMaidenName;
  }

  public String getPersonlEmail() {
    return personalEmail;
  }

  public void setPersonlEmail(String personalEmail) {
    this.personalEmail = personalEmail;
  }

  public String getPresentAddress() {
    return presentAddress;
  }

  public void setPresentAddress(String presentAddress) {
    this.presentAddress = presentAddress;
  }

  public java.util.Date getPresentAddressFromDate() {
    return presentAddressFromDate;
  }

  public void setPresentAddressFromDate(java.util.Date presentAddressFromDate) {
    this.presentAddressFromDate = presentAddressFromDate;
  }

  public java.util.Date getPermanentAddressFromDate() {
    return permanentAddressFromDate;
  }

  public void setPermanentAddressFromDate(java.util.Date permanentAddressFromDate) {
    this.permanentAddressFromDate = permanentAddressFromDate;
  }

  public java.util.Date getPresentAddressToDate() {
    return presentAddressToDate;
  }

  public void setPresentAddressToDate(java.util.Date presentAddressToDate) {
    this.presentAddressToDate = presentAddressToDate;
  }

  public java.util.Date getPermanentAddressToDate() {
    return permanentAddressToDate;
  }

  public void setPermanentAddressToDate(java.util.Date permanentAddressToDate) {
    this.permanentAddressToDate = permanentAddressToDate;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getNatiionality() {
    return natiionality;
  }

  public void setNatiionality(String natiionality) {
    this.natiionality = natiionality;
  }

  public String getMaidenName() {
    return maidenName;
  }

  public void setMaidenName(String maidenName) {
    this.maidenName = maidenName;
  }

  public String getMotherName() {
    return motherName;
  }

  public void setMotherName(String motherName) {
    this.motherName = motherName;
  }

  public java.util.Date getDob() {
    return dob;
  }

  public void setDob(java.util.Date dob) {
    this.dob = dob;
  }

  public String getAlternateEmail() {
    return alternateEmail;
  }

  public void setAlternateEmail(String alternateEmail) {
    this.alternateEmail = alternateEmail;
  }

  public String getPermanentAddress() {
    return permanentAddress;
  }

  public void setPermanentAddress(String permanentAddress) {
    this.permanentAddress = permanentAddress;
  }

}
