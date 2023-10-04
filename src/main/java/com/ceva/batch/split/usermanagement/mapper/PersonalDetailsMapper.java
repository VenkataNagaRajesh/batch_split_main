package com.ceva.batch.split.usermanagement.mapper;

import org.slf4j.Logger;
import com.ceva.batch.split.rest.usermanagement.outbound.dto.PersonalDetails;
import com.ceva.batch.split.usermanagement.dto.PersonalDetailsXml;
import com.datastax.driver.core.LocalDate;

/**
 * Mapping two PersonalDetails objects.
 * 
 * @author shaik
 *
 */
public class PersonalDetailsMapper {
  static final Logger logger = org.slf4j.LoggerFactory.getLogger(PersonalDetailsMapper.class);

  /**
   * Setting fields to PersonalDetailsObject2.
   * 
   * 
   * @return PersonalDetailsObject2.
   */
  public PersonalDetails mappingPersonalDetails(
      com.ceva.batch.split.usermanagement.dto.PersonalDetails personaldetailsobject) {
    logger.info("Recived personaldetailsobject from rest controller");

    com.ceva.batch.split.rest.usermanagement.outbound.dto.PersonalDetails personaldetailsobject2 =
        new com.ceva.batch.split.rest.usermanagement.outbound.dto.PersonalDetails();
    LocalDate presentaddressfromdate =
        LocalDate.fromMillisSinceEpoch(personaldetailsobject.getPresentAddressFromDate().getTime());
    personaldetailsobject2.setPresentAddressFromDate(presentaddressfromdate);
    LocalDate permanentaddressfromdate = LocalDate
        .fromMillisSinceEpoch(personaldetailsobject.getPermanentAddressFromDate().getTime());
    LocalDate permanentaddresstodate =
        LocalDate.fromMillisSinceEpoch(personaldetailsobject.getPermanentAddressToDate().getTime());
    LocalDate.fromMillisSinceEpoch(personaldetailsobject.getPresentAddressToDate().getTime());
    LocalDate dob = LocalDate.fromMillisSinceEpoch(personaldetailsobject.getDob().getTime());
    personaldetailsobject2.setPresentAddressToDate(permanentaddresstodate);
    personaldetailsobject2.setPermanentAddress(personaldetailsobject.getPermanentAddress());
    personaldetailsobject2.setPermanentAddressToDate(permanentaddresstodate);
    personaldetailsobject2.setDob(dob);
    personaldetailsobject2.setEmployeeId(personaldetailsobject.getEmployeeId());
    personaldetailsobject2.setFatherName(personaldetailsobject.getFatherName());
    personaldetailsobject2.setMotherName(personaldetailsobject.getMotherName());
    personaldetailsobject2.setTitle(personaldetailsobject.getTitle());
    personaldetailsobject2.setPersonlEmail(personaldetailsobject.getPersonlEmail());
    personaldetailsobject2.setNatiionality(personaldetailsobject.getNatiionality());
    personaldetailsobject2.setAlternateEmail(personaldetailsobject.getAlternateEmail());
    personaldetailsobject2.setPresentAddress(personaldetailsobject.getPresentAddress());

    personaldetailsobject2.setMaidenName(personaldetailsobject.getMaidenName());
    personaldetailsobject2.setPrimarySkill(personaldetailsobject.getPrimarySkill());
    personaldetailsobject2.setBirthPlace(personaldetailsobject.getBirthPlace());
    return personaldetailsobject2;
  }

  /**
   * Setting fields to PersonalDetails.
   * 
   * 
   * @return PersonalDetails object2.
   */
  public PersonalDetails mappingPersonalXml(PersonalDetailsXml personaldetailsobject) {
    logger.info("Recieved personaldetails xml from rest controller");
    LocalDate presentaddressfromdate2 =
        LocalDate.fromMillisSinceEpoch(personaldetailsobject.getPresentAddressFromDate().getTime());
    LocalDate.fromMillisSinceEpoch(personaldetailsobject.getPresentAddressToDate().getTime());
    LocalDate permanentaddressfromdate2 = LocalDate
        .fromMillisSinceEpoch(personaldetailsobject.getPermanentAddressFromDate().getTime());
    LocalDate permanentaddresstodate2 =
        LocalDate.fromMillisSinceEpoch(personaldetailsobject.getPermanentAddressToDate().getTime());
    LocalDate dob2 = LocalDate.fromMillisSinceEpoch(personaldetailsobject.getDob().getTime());
    com.ceva.batch.split.rest.usermanagement.outbound.dto.PersonalDetails personaldetailsobject2 =
        new com.ceva.batch.split.rest.usermanagement.outbound.dto.PersonalDetails();
    personaldetailsobject2.setPresentAddressFromDate(presentaddressfromdate2);
    personaldetailsobject2.setPresentAddressToDate(permanentaddresstodate2);
    personaldetailsobject2.setPermanentAddress(personaldetailsobject.getPermanentAddress());
    personaldetailsobject2.setPermanentAddressFromDate(permanentaddressfromdate2);
    personaldetailsobject2.setPermanentAddressToDate(permanentaddresstodate2);
    personaldetailsobject2.setDob(dob2);
    personaldetailsobject2.setEmployeeId(personaldetailsobject.getEmployeeId());
    personaldetailsobject2.setFatherName(personaldetailsobject.getFatherName());
    personaldetailsobject2.setMotherName(personaldetailsobject.getMotherName());;
    personaldetailsobject2.setTitle(personaldetailsobject.getTitle());
    personaldetailsobject2.setPersonlEmail(personaldetailsobject.getPersonlEmail());
    personaldetailsobject2.setNatiionality(personaldetailsobject.getNatiionality());
    personaldetailsobject2.setAlternateEmail(personaldetailsobject.getAlternateEmail());
    personaldetailsobject2.setPresentAddress(personaldetailsobject.getPresentAddress());
    personaldetailsobject2.setMaidenName(personaldetailsobject.getMaidenName());
    personaldetailsobject2.setPrimarySkill(personaldetailsobject.getPrimarySkill());
    personaldetailsobject2.setBirthPlace(personaldetailsobject.getBirthPlace());
    return personaldetailsobject2;
  }

}
