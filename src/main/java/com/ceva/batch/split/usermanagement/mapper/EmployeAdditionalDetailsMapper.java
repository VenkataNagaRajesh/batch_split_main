package com.ceva.batch.split.usermanagement.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ceva.batch.split.rest.usermanagement.inbound.dto.EmployeAddtionalDetailsInBound;
import com.ceva.batch.split.usermanagement.dto.EmployeAddtionalDetails;
import com.ceva.batch.split.usermanagement.dto.EmployeAddtionalDetailsXml;
import com.datastax.driver.core.LocalDate;

/**
 * Mapping to empAddtionalDetails objects.
 * 
 * @author rajesh
 *
 */
@Component
public class EmployeAdditionalDetailsMapper {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(EmployeAdditionalDetailsMapper.class);
  @Autowired
  EmployeAddtionalDetailsInBound employeAddtionalDetails2;

  /**
   * setting fields to empAdditionalDetailsObject. EmployeAddtionalDetailsObject object as a
   * parameter.
   * 
   * @return empAdditoinalDetailsObject.
   */
  public static com.ceva.batch.split.usermanagement.dto.EmployeAddtionalDetails mappingToEmployeAddtionalDto(
      EmployeAddtionalDetailsInBound empAdditionalDetails) {
    com.ceva.batch.split.usermanagement.dto.EmployeAddtionalDetails employeAdditionalData2 =
        new com.ceva.batch.split.usermanagement.dto.EmployeAddtionalDetails();
    // LOGGER.info(java.sql.Date.valueOf(passportExpiryDate.toString()).toString());
    employeAdditionalData2.setPassportExpiryDate(LocalDate
        .fromMillisSinceEpoch(empAdditionalDetails.getDrivingLicenseValidDate().getTime()));
    employeAdditionalData2.setVisaRejectedDate(
        LocalDate.fromMillisSinceEpoch(empAdditionalDetails.getPassportExpiryDate().getTime()));
    employeAdditionalData2.setDrivingLicenseValidDate(LocalDate
        .fromMillisSinceEpoch(empAdditionalDetails.getDrivingLicenseValidDate().getTime()));

    employeAdditionalData2.setDrivingLicenseNo(empAdditionalDetails.getDrivingLicenseNo());
    employeAdditionalData2.setEmpId(empAdditionalDetails.getEmpId());
    employeAdditionalData2.setItPanNo(empAdditionalDetails.getItPanNo());
    employeAdditionalData2.setPassportNo(empAdditionalDetails.getPassportNo());
    employeAdditionalData2.setReferedPersonAddress(empAdditionalDetails.getReferedPersonAddress());
    employeAdditionalData2.setReferedPersonContact(empAdditionalDetails.getReferedPersonContact());
    employeAdditionalData2
        .setReferedPersonDesignation(empAdditionalDetails.getReferedPersonDesignation());
    employeAdditionalData2.setReferedpersonEmail(empAdditionalDetails.getReferedpersonEmail());
    employeAdditionalData2.setReferedPersonName(empAdditionalDetails.getReferedPersonName());
    employeAdditionalData2.setReferedPersonOrg(empAdditionalDetails.getReferedPersonOrg());
    employeAdditionalData2.setReferenceStatus(empAdditionalDetails.getRefernceStatus());
    employeAdditionalData2.setVisaRejectedCountry(empAdditionalDetails.getVisaRejectedCountry());
    employeAdditionalData2.setVisaRejectedReason(empAdditionalDetails.getVisaRejectedReason());
    employeAdditionalData2.setVisaRejectedStatus(empAdditionalDetails.getVisaRejectedStatus());
    return employeAdditionalData2;
  }

  /**
   * empAdditionalDetails for xml recieving.
   * 
   * @return AddtionalDetials Object from xml to object parameter
   */
  public EmployeAddtionalDetails mappingEmployeAddtionalXmlDto(
      EmployeAddtionalDetailsXml empAdditionalDetails) {
    LOGGER.info("Recieved employe Additional Object from rest controller  " + empAdditionalDetails);
    EmployeAddtionalDetails employeAddtionalDetails2 = new EmployeAddtionalDetails();
    employeAddtionalDetails2.setDrivingLicenseNo(empAdditionalDetails.getDrivingLicenseNo());
    employeAddtionalDetails2.setPassportExpiryDate(
        LocalDate.fromMillisSinceEpoch(empAdditionalDetails.getPassportExpiryDate().getTime()));
    employeAddtionalDetails2.setVisaRejectedDate(
        LocalDate.fromMillisSinceEpoch(empAdditionalDetails.getVisaRejectedDate().getTime()));
    employeAddtionalDetails2.setDrivingLicenseValidDate(LocalDate
        .fromMillisSinceEpoch(empAdditionalDetails.getDrivingLicenseValidDate().getTime()));
    employeAddtionalDetails2.setEmpId(empAdditionalDetails.getEmpId());
    employeAddtionalDetails2.setItPanNo(empAdditionalDetails.getItPanNo());
    employeAddtionalDetails2.setPassportNo(empAdditionalDetails.getPassportNo());
    employeAddtionalDetails2
        .setReferedPersonAddress(empAdditionalDetails.getReferedPersonAddress());
    employeAddtionalDetails2
        .setReferedPersonContact(empAdditionalDetails.getReferedPersonContact());
    employeAddtionalDetails2
        .setReferedPersonDesignation(empAdditionalDetails.getReferedPersonDesignation());
    employeAddtionalDetails2.setReferedpersonEmail(empAdditionalDetails.getReferedpersonEmail());
    employeAddtionalDetails2.setReferedPersonName(empAdditionalDetails.getReferedPersonName());
    employeAddtionalDetails2.setReferedPersonOrg(empAdditionalDetails.getReferedPersonOrg());
    employeAddtionalDetails2.setReferenceStatus(empAdditionalDetails.getRefernceStatus());
    employeAddtionalDetails2.setVisaRejectedCountry(empAdditionalDetails.getVisaRejectedCountry());
    employeAddtionalDetails2.setVisaRejectedReason(empAdditionalDetails.getVisaRejectedReason());
    employeAddtionalDetails2.setVisaRejectedStatus(empAdditionalDetails.getVisaRejectedStatus());

    return employeAddtionalDetails2;

  }


}
