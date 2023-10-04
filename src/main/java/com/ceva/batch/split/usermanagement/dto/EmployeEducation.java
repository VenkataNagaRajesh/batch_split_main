package com.ceva.batch.split.usermanagement.dto;

import java.util.Date;
import com.datastax.driver.core.LocalDate;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Table(name = "employe_education_details", keyspace = "vensai")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeEducation {

  @PartitionKey
  private String employeId;
  private String qualificationWithSpecialization;
  private String instituteCity;
  private String universityCity;
  private String institutionName;
  private String universityName;
  private LocalDate periodFrom;
  private String studentId;
  private String program;
  private Double percentageMarks;
  private LocalDate periodTo;


  public String getEmployeId() {
    return employeId;
  }


  public void setEmployeId(String employeId) {
    this.employeId = employeId;
  }


  public EmployeEducation() {
    super();
    // TODO Auto-generated constructor stub
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

  public LocalDate getPeriodFrom() {
    return periodFrom;
  }

  public void setPeriodFrom(LocalDate periodFrom) {
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

  public LocalDate getPeriodTo() {
    return periodTo;
  }

  public void setPeriodTo(LocalDate periodTo) {
    this.periodTo = periodTo;
  }


}
