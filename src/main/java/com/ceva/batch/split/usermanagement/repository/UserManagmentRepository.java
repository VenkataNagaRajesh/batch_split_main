package com.ceva.batch.split.usermanagement.repository;

import java.util.List;
import com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployeAddtionalDetailsOut;
import com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployerDetails;
import com.ceva.batch.split.rest.usermanagement.outbound.dto.PersonalDetails;
import com.ceva.batch.split.usermanagement.dto.EmployeAddtionalDetails;
import com.ceva.batch.split.usermanagement.dto.EmployeEducation;

/**
 * UsermanagementRepository interface.
 * 
 * @author rajesh
 *
 */

public interface UserManagmentRepository {

  public void saveEmployer(EmployerDetails employerDetails);

  public void savePersonal(PersonalDetails personaldetails);

  public List<EmployerDetails> employeeDetails(int employerSno);

  public List<PersonalDetails> personalDetails(int employeeId);

  public List<EmployerDetails> employerDetails();

  public List<PersonalDetails> personalDetails();

  // public List<EmployeeDetails> employeeDetails();

  public void saveEmpEduJsonData(EmployeEducation educationDetails);

  public void saveEmpEduxmlData(EmployeEducation educationDetails);

  public void saveAdditionalXml(EmployeAddtionalDetails empAddtionalDetailsXml);

  public void saveEmpAddtionalDetails(EmployeAddtionalDetails employeAddtionalDetails);

  List<EmployeAddtionalDetailsOut> getEmployeAllAddtionalDetials();

  List<com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployeEducation> getAllEmpEducationDetails();
}
