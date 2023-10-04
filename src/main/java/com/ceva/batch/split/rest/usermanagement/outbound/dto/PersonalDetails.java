package com.ceva.batch.split.rest.usermanagement.outbound.dto;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

/**
 * PersonDetails object2.
 * 
 * @author shaik
 *
 */
@Table(name = "PersonalDetails")
public class PersonalDetails {
  @PartitionKey
  int employeeId;
  String primarySkill;
  String birthPlace;
  String fatherName;
  String motherMaidenName;
  String personalEmail;
  String presentAddress;
  LocalDate presentAddressFromDate;
  LocalDate permanentAddressFromDate;
  LocalDate presentAddressToDate;
  LocalDate permanentAddressToDate;
  String title;
  String natiionality;
  String maidenName;
  String motherName;
  LocalDate dob;
  String alternateEmail;
  String permanentAddress;

  /**
   * superClassConstructor.
   */

  public PersonalDetails() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * Parameterized constructor.
   * 
   * 
   */

  public PersonalDetails(int employeeId, String primarySkill, String birthPlace, String fatherName,
      String motherMaidenName, String personalEmail, String presentAddress,
      LocalDate presentAddressFromDate, LocalDate permanentAddressFromDate,
      LocalDate presentAddressToDate, LocalDate permanentAddressToDate, String title,
      String natiionality, String maidenName, String motherName, LocalDate dob,
      String alternateEmail, String permanentAddress) {
    super();
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

  public LocalDate getPresentAddressFromDate() {
    return presentAddressFromDate;
  }

  public void setPresentAddressFromDate(LocalDate presentAddressFromDate) {
    this.presentAddressFromDate = presentAddressFromDate;
  }

  public LocalDate getPermanentAddressFromDate() {
    return permanentAddressFromDate;
  }

  public void setPermanentAddressFromDate(LocalDate permanentAddressFromDate) {
    this.permanentAddressFromDate = permanentAddressFromDate;
  }

  public LocalDate getPresentAddressToDate() {
    return presentAddressToDate;
  }

  public void setPresentAddressToDate(LocalDate presentAddressToDate) {
    this.presentAddressToDate = presentAddressToDate;
  }

  public LocalDate getPermanentAddressToDate() {
    return permanentAddressToDate;
  }

  public void setPermanentAddressToDate(LocalDate permanentAddressToDate) {
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

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
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
