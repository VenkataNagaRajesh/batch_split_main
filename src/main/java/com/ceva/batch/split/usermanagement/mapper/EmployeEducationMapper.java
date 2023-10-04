package com.ceva.batch.split.usermanagement.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.ceva.batch.split.rest.usermanagement.inbound.dto.EmployeEducationInBound;
import com.ceva.batch.split.usermanagement.dto.EmployeEducation;
import com.ceva.batch.split.usermanagement.dto.EmployeEducationXml;
import com.datastax.driver.core.LocalDate;

/**
 * EmployeEducationMapper class to map the EmployeEducationDto to EmployeEducationInBound class. 
 * @author rajesh.
 *
 */
@Component
public class EmployeEducationMapper {

  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeEducationMapper.class);

  /**
   * setting fields to empEductionObject. EmployeEducationObject object as a parameter.
   * 
   * @return empEductionObject.
   */
  public EmployeEducation mappingToEmployeEducationDto(EmployeEducationInBound employeEducation) {

    EmployeEducation employeEducation2 = new EmployeEducation();
    LocalDate periodFrom =
        LocalDate.fromMillisSinceEpoch(employeEducation.getPeriodFrom().getTime());
    LocalDate periodTo = LocalDate.fromMillisSinceEpoch(employeEducation.getPeriodTo().getTime());
    LOGGER.info("Recieved employeEducationObject from rest controller  " + employeEducation);
    EmployeEducation empEductionObject = new EmployeEducation();

    employeEducation2.setEmployeId(employeEducation.getEmployeId());
    employeEducation2.setPeriodFrom(periodFrom);
    employeEducation2.setInstituteCity(employeEducation.getInstituteCity());
    employeEducation2.setInstitutionName(employeEducation.getInstitutionName());
    employeEducation2.setPercentageMarks(employeEducation.getPercentageMarks());
    employeEducation2.setProgram(employeEducation.getProgram());
    employeEducation2
        .setQualificationWithSpecialization(employeEducation.getQualificationWithSpecialization());
    employeEducation2.setUniversityCity(employeEducation.getUniversityCity());
    employeEducation2.setStudentId(employeEducation.getStudentId());
    employeEducation2.setUniversityName(employeEducation.getUniversityName());


    return employeEducation2;
  }

  /**
   * employeEducationDetailsObject education object.
   *
   * @return EmployeEducationObject.
   */
  public EmployeEducation mappingEmployeEducationalXmlDto(
      EmployeEducationXml employeEducationDetailsObject) {
    EmployeEducation employeEducation2 = new EmployeEducation();
    LocalDate periodFrom =
        LocalDate.fromMillisSinceEpoch(employeEducationDetailsObject.getPeriodFrom().getTime());
    LocalDate periodTo =
        LocalDate.fromMillisSinceEpoch(employeEducationDetailsObject.getPeriodTo().getTime());
    LOGGER.info(
        "Recieved employeEducationObject from rest controller  " + employeEducationDetailsObject);
    EmployeEducation empEductionObject = new EmployeEducation();

    employeEducation2.setEmployeId(employeEducationDetailsObject.getEmployeId());
    employeEducation2.setPeriodFrom(periodFrom);
    employeEducation2.setInstituteCity(employeEducationDetailsObject.getInstituteCity());
    employeEducation2.setInstitutionName(employeEducationDetailsObject.getInstitutionName());
    employeEducation2.setPercentageMarks(employeEducationDetailsObject.getPercentageMarks());
    employeEducation2.setProgram(employeEducationDetailsObject.getProgram());
    employeEducation2.setQualificationWithSpecialization(
        employeEducationDetailsObject.getQualificationWithSpecialization());
    employeEducation2.setUniversityCity(employeEducationDetailsObject.getUniversityCity());
    employeEducation2.setStudentId(employeEducationDetailsObject.getStudentId());
    employeEducation2.setUniversityName(employeEducationDetailsObject.getUniversityName());
    return employeEducation2;
  }


}
