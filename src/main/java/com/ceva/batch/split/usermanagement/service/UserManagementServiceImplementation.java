package com.ceva.batch.split.usermanagement.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceva.batch.split.rest.usermanagement.inbound.dto.EmployeEducationInBound;
import com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployeAddtionalDetailsOut;
import com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployerDetails;
import com.ceva.batch.split.rest.usermanagement.outbound.dto.PersonalDetails;
import com.ceva.batch.split.usermanagement.dto.EmployeAddtionalDetails;
import com.ceva.batch.split.usermanagement.dto.EmployeAddtionalDetailsXml;
import com.ceva.batch.split.usermanagement.dto.EmployeEducation;
import com.ceva.batch.split.usermanagement.dto.EmployeEducationXml;
import com.ceva.batch.split.usermanagement.dto.EmployerDetailsXml;
import com.ceva.batch.split.usermanagement.dto.PersonalDetailsXml;
import com.ceva.batch.split.usermanagement.mapper.EmployeAdditionalDetailsMapper;
import com.ceva.batch.split.usermanagement.mapper.EmployeEducationMapper;
import com.ceva.batch.split.usermanagement.mapper.EmployerDetailsMapper;
import com.ceva.batch.split.usermanagement.mapper.PersonalDetailsMapper;
import com.ceva.batch.split.usermanagement.repository.UserManagmentRepository;

/**
 * UserManagmentServiceImplementation class.
 * 
 * @author rajesh.
 *
 */
@Service
public class UserManagementServiceImplementation implements UserManagementService {
  private static final Logger logger = LoggerFactory.getLogger(UserManagementService.class);

  @Autowired
  UserManagmentRepository usermanagementrepo;
  @Autowired
  PersonalDetailsMapper personaldetailsmapper;
  @Autowired
  EmployerDetailsMapper employermapper;
  @Autowired
  EmployeAdditionalDetailsMapper empAddtionalDetailsMapper;
  @Autowired
  EmployeEducationMapper empEducationalMapper;

  /**
   * saving PersonalDetails.
   */
  public void savePersonalDetails(
      com.ceva.batch.split.usermanagement.dto.PersonalDetails personaldetailsobject) {
    logger.info("Recieved personaldetails object from rest" + personaldetailsobject);
    PersonalDetails personaldetailsobject2 =
        personaldetailsmapper.mappingPersonalDetails(personaldetailsobject);
    usermanagementrepo.savePersonal(personaldetailsobject2);
  }

  /**
   * Getting all EmployerDetails.
   */
  @Override
  public List<EmployerDetails> employerDetails() {

    return usermanagementrepo.employerDetails();
  }

  /**
   * Getting all PersonalDetails.
   */
  @Override
  public List<PersonalDetails> personalDetails() {
    // TODO Auto-generated method stub
    return usermanagementrepo.personalDetails();
  }

  /**
   * Posting EmployerDetails.
   */
  @Override
  public void saveEmployer(
      com.ceva.batch.split.usermanagement.dto.EmployerDetails employerdetails) {
    // TODO Auto-generated method stub
    logger.info("Recieved employerobject from rest is " + employerdetails);
    EmployerDetails employerobject2 = employermapper.mappingTwoEmployerDto(employerdetails);
    usermanagementrepo.saveEmployer(employerobject2);

  }

  /**
   * posting EmployerDetailsXml.
   */
  @Override
  public void saveEmployerXml(EmployerDetailsXml employerdetailobject) {
    EmployerDetails employerobject2 = employermapper.mappingEmployerXml(employerdetailobject);
    logger.info("mapped xml object is  " + employerobject2);
    usermanagementrepo.saveEmployer(employerobject2);

  }

  /**
   * posting PersonalDetailsXml.
   */
  @Override
  public void savePersonalDetails(PersonalDetailsXml personaldetails) {
    logger.info("Recieved xml personaldetails " + personaldetails);
    PersonalDetails personaldetailsobject2 =
        personaldetailsmapper.mappingPersonalXml(personaldetails);
    usermanagementrepo.savePersonal(personaldetailsobject2);

  }


  // @Override
  // public List<EmployeeDetails> employeedetails() {
  // return null;
  // }

  @Override
  public List<EmployerDetails> employeeDetails(int employerSno) {
    logger.info("Recieved request to service for employer details by id ");
    return usermanagementrepo.employeeDetails(employerSno);
  }

  @Override
  public List<PersonalDetails> personalDetails(int employeeId) {
    logger.info("Recieved request to service for personaldetails by id");
    return usermanagementrepo.personalDetails(employeeId);
  }

  /**
   * saving employeAddtionalDetails.
   */
  @Override
  public void saveEmpAdditionalDetails(
      com.ceva.batch.split.rest.usermanagement.inbound.dto.EmployeAddtionalDetailsInBound employeAdditionalDetails) {
    EmployeAddtionalDetails employeAddtionalDetailsDto =
        empAddtionalDetailsMapper.mappingToEmployeAddtionalDto(employeAdditionalDetails);
    usermanagementrepo.saveEmpAddtionalDetails(employeAddtionalDetailsDto);
  }

  /**
   * saving employeAddtionalDetails in XmlFormat.
   */

  @Override
  public void saveEmployeAdditionalDetailsXml(EmployeAddtionalDetailsXml employeAdditionalDetails) {

    logger.info("recived to usermanagment implementation class");
    EmployeAddtionalDetails addtionalDetails =
        empAddtionalDetailsMapper.mappingEmployeAddtionalXmlDto(employeAdditionalDetails);
    usermanagementrepo.saveAdditionalXml(addtionalDetails);
  }

  /**
   * saving employeEducationDetails.
   */

  public void saveEducationalDetails(EmployeEducationInBound empEducationalDetails) {
    logger.info("user management method called");
    EmployeEducation empEducationDto =
        empEducationalMapper.mappingToEmployeEducationDto(empEducationalDetails);
    logger.info("usermanagment repo emp education saving method calling");
    usermanagementrepo.saveEmpEduJsonData(empEducationDto);
  }

  /**
   * saving employeEducationDetails in XmlFormat.
   */
  @Override
  public void saveEmployeEducationalDetailsXml(EmployeEducationXml employeEducationDetailsObject) {
    EmployeEducation educationDetails =
        empEducationalMapper.mappingEmployeEducationalXmlDto(employeEducationDetailsObject);
    usermanagementrepo.saveEmpEduxmlData(educationDetails);;
  }

  /**
   * getting employeAddtionalDetails.
   */
  @Override
  public List<com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployeEducation> getEducationDetails() {
    return usermanagementrepo.getAllEmpEducationDetails();
  }

  /**
   * getting employeEducationalDetails.
   */
  @Override
  public List<EmployeAddtionalDetailsOut> getEmployeAdditionalDetails() {
    return usermanagementrepo.getEmployeAllAddtionalDetials();
  }
  //
  // @Override
  // public List<com.ceva.batch.split.usermanagement.service.EmployeeDetails> employeedetails() {
  // // TODO Auto-generated method stub
  // return null;
  // }
  //

}
