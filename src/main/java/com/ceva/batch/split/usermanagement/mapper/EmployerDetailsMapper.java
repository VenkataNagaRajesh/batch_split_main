package com.ceva.batch.split.usermanagement.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployerDetails;
import com.ceva.batch.split.usermanagement.dto.EmployerDetailsXml;
import com.datastax.driver.core.LocalDate;

/**
 * Mapping two objects.
 */
public class EmployerDetailsMapper {
  static final Logger logger = LoggerFactory.getLogger(EmployerDetailsMapper.class);

  /**
   * setting fields to employerobject2. EmployerDetails object as a parameter.
   * 
   * @return employerobject2.
   */
  public static EmployerDetails mappingTwoEmployerDto(
      com.ceva.batch.split.usermanagement.dto.EmployerDetails employerobject) {
    logger.info("Recieved employerobject from rest controller  " + employerobject);
    LocalDate employerfrom =
        LocalDate.fromMillisSinceEpoch(employerobject.getPreviousEmploymentPeriodFrom().getTime());
    LocalDate employerto =
        LocalDate.fromMillisSinceEpoch(employerobject.getPreviousEmploymentPeriodTo().getTime());
    com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployerDetails employerobject2 =
        new com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployerDetails();
    employerobject2.setAppointmentLetter(employerobject.getAppointmentLetter());
    employerobject2.setEmpId(employerobject.getEmpId());
    employerobject2.setEmployerSno(employerobject.getEmployerSno());
    employerobject2.setForm16(employerobject.getForm16());
    employerobject2.setLastSalary(employerobject.getLastSalary());
    employerobject2.setLeaveMode(employerobject.getLeaveMode());
    employerobject2.setLeavingReason(employerobject.getLeavingReason());
    employerobject2.setPaySlips(employerobject.getPaySlips());
    employerobject2.setPreviousCompanyName(employerobject.getPreviousCompanyAdrress());
    employerobject2.setPreviousCompanyAdrress(employerobject.getPreviousCompanyAdrress());
    employerobject2.setPreviousEmpDesignation(employerobject.getPreviousEmpDesignation());
    employerobject2.setPreviousEmploymentPeriodFrom(employerfrom);
    employerobject2.setPreviousEmploymentPeriodTo(employerto);
    employerobject2.setPreviousEmpType(employerobject.getPreviousEmpType());
    employerobject2.setRelievingLetter(employerobject.getRelievingLetter());
    employerobject2.setReportingPersonContact(employerobject.getReportingPersonContact());
    employerobject2.setReportingPersonName(employerobject.getReportingPersonName());
    employerobject2.setRepostingPersonPosition(employerobject.getRepostingPersonPosition());
    return employerobject2;
  }

  /**
   * setting fields to EmployerDetails.
   * 
   * @return EmployerDetailsobject2.
   */
  public static EmployerDetails mappingEmployerXml(EmployerDetailsXml employerdetailobject) {
    logger.info("Recieved employerxml object from rest controller");
    EmployerDetails employerobject2 = new EmployerDetails();
    LocalDate employerfrom = LocalDate
        .fromMillisSinceEpoch(employerdetailobject.getPreviousEmploymentPeriodFrom().getTime());
    LocalDate employerto = LocalDate
        .fromMillisSinceEpoch(employerdetailobject.getPreviousEmploymentPeriodTo().getTime());
    employerobject2.setAppointmentLetter(employerdetailobject.getAppointmentLetter());
    employerobject2.setEmpId(employerdetailobject.getEmpId());
    employerobject2.setEmployerSno(employerdetailobject.getEmployerSno());
    employerobject2.setForm16(employerdetailobject.getForm16());
    employerobject2.setLastSalary(employerdetailobject.getLastSalary());
    employerobject2.setLeaveMode(employerdetailobject.getLeaveMode());
    employerobject2.setLeavingReason(employerdetailobject.getLeavingReason());
    employerobject2.setPaySlips(employerdetailobject.getPaySlips());
    employerobject2.setPreviousCompanyName(employerdetailobject.getPreviousCompanyAdrress());
    employerobject2.setPreviousCompanyAdrress(employerdetailobject.getPreviousCompanyAdrress());
    employerobject2.setPreviousEmpDesignation(employerdetailobject.getPreviousEmpDesignation());
    employerobject2.setPreviousEmploymentPeriodFrom(employerfrom);
    employerobject2.setPreviousEmploymentPeriodTo(employerto);
    employerobject2.setPreviousEmpType(employerdetailobject.getPreviousEmpType());
    employerobject2.setRelievingLetter(employerdetailobject.getRelievingLetter());
    employerobject2.setReportingPersonContact(employerdetailobject.getReportingPersonContact());
    employerobject2.setReportingPersonName(employerdetailobject.getReportingPersonName());
    employerobject2.setRepostingPersonPosition(employerdetailobject.getRepostingPersonPosition());
    return employerobject2;
  }
}
