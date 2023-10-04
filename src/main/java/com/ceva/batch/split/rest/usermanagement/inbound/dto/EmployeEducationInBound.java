package com.ceva.batch.split.rest.usermanagement.inbound.dto;

import java.util.Date;
import javax.persistence.Entity;


public class EmployeEducationInBound {

  private String employeId;
  private String qualificationWithSpecialization;
  private String instituteCity;
  private String universityCity;
  private String institutionName;
  private String universityName;
  private Date periodFrom;
  private String studentId;
  private String program;
  private Double percentageMarks;
  private Date periodTo;

  public String getEmployeId() {
    return employeId;
  }


  public void setEmployeId(String employeId) {
    this.employeId = employeId;
  }


  public String getQualificationWithSpecialization() {
    return qualificationWithSpecialization;
  }

  public void setQualificationWithSpecialization(String qualificationWithSpecialization) {
    this.qualificationWithSpecialization = qualificationWithSpecialization;
  }

  public String getInstituteCity() {
    return instituteCity;
  }

  public void setInstituteCity(String instituteCity) {
    this.instituteCity = instituteCity;
  }

  public String getUniversityCity() {
    return universityCity;
  }

  public void setUniversityCity(String universityCity) {
    this.universityCity = universityCity;
  }

  public String getInstitutionName() {
    return institutionName;
  }

  public void setInstitutionName(String institutionName) {
    this.institutionName = institutionName;
  }

  public String getUniversityName() {
    return universityName;
  }

  public void setUniversityName(String universityName) {
    this.universityName = universityName;
  }

  public Date getPeriodFrom() {
    return periodFrom;
  }

  public void setPeriodFrom(Date periodFrom) {
    this.periodFrom = periodFrom;
  }

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public String getProgram() {
    return program;
  }

  public void setProgram(String program) {
    this.program = program;
  }

  public Double getPercentageMarks() {
    return percentageMarks;
  }

  public void setPercentageMarks(Double percentageMarks) {
    this.percentageMarks = percentageMarks;
  }

  public Date getPeriodTo() {
    return periodTo;
  }

  public void setPeriodTo(Date periodTo) {
    this.periodTo = periodTo;
  }


}
