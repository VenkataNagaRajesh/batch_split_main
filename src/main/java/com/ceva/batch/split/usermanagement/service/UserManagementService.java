package com.ceva.batch.split.usermanagement.service;

import java.util.List;
import com.ceva.batch.split.rest.usermanagement.inbound.dto.EmployeAddtionalDetailsInBound;
import com.ceva.batch.split.rest.usermanagement.inbound.dto.EmployeEducationInBound;
import com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployeAddtionalDetailsOut;
import com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployeEducation;
import com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployerDetails;
import com.ceva.batch.split.rest.usermanagement.outbound.dto.PersonalDetails;
import com.ceva.batch.split.usermanagement.dto.EmployeAddtionalDetailsXml;
import com.ceva.batch.split.usermanagement.dto.EmployeEducationXml;
import com.ceva.batch.split.usermanagement.dto.EmployerDetailsXml;


/**
 * UsermanagementService interface.
 * 
 * @author rajesh.
 *
 */
public interface UserManagementService {

  public void saveEmployer(com.ceva.batch.split.usermanagement.dto.EmployerDetails employerdetails);

  public void saveEmployerXml(EmployerDetailsXml employerdetailobject);

  public void savePersonalDetails(
      com.ceva.batch.split.usermanagement.dto.PersonalDetails personalDetails);

  public void savePersonalDetails(
      com.ceva.batch.split.usermanagement.dto.PersonalDetailsXml personalDetails);

  public List<EmployerDetails> employeeDetails(int employerSno);

  public List<PersonalDetails> personalDetails(int employeeId);

  // public List<EmployeeDetails> employeedetails();

  public List<EmployerDetails> employerDetails();

  public List<PersonalDetails> personalDetails();

  public List<EmployeEducation> getEducationDetails();

  public void saveEducationalDetails(EmployeEducationInBound employeEducationInBound);

  public void saveEmpAdditionalDetails(EmployeAddtionalDetailsInBound employeAdditionalDetails);

  public void saveEmployeEducationalDetailsXml(EmployeEducationXml employeEducationDetailsObject);

  public List<EmployeAddtionalDetailsOut> getEmployeAdditionalDetails();

  void saveEmployeAdditionalDetailsXml(EmployeAddtionalDetailsXml personaldetailsobject);
}
