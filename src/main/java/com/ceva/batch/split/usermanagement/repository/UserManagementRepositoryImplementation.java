package com.ceva.batch.split.usermanagement.repository;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ceva.batch.split.datastax.Connection;
import com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployeAddtionalDetailsOut;
import com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployerDetails;
import com.ceva.batch.split.rest.usermanagement.outbound.dto.PersonalDetails;
import com.ceva.batch.split.usermanagement.dto.EmployeAddtionalDetails;
import com.ceva.batch.split.usermanagement.dto.EmployeEducation;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;

/*
 * @author Rajesh.
 *
 */
@Repository
public class UserManagementRepositoryImplementation implements UserManagmentRepository {
  static final Logger logger = LoggerFactory.getLogger(UserManagmentRepository.class);
  @Autowired
  Connection connection;


  /**
   * save employe education xml.
   * 
   */

  public Mapper<EmployeEducation> getXmlConnectionEmployerDetails() {
    MappingManager manager = new MappingManager(connection.getSession());
    return manager.mapper(EmployeEducation.class);
  }

  @Override
  public void saveEmpEduxmlData(EmployeEducation educationDetails) {
    MappingManager mappingManager = connection.getManager();
    Mapper<EmployeEducation> map = mappingManager.mapper(EmployeEducation.class);
    logger.info("Data got saved");
    map.save(educationDetails);

  }

  @Override
  public void saveEmployer(EmployerDetails employerdetails) {
    logger.info("Recieved employerdetails for saving the data in database");
    MappingManager manager = connection.getManager();
    Mapper<EmployerDetails> map = manager.mapper(EmployerDetails.class);
    map.save(employerdetails);
  }

  @Override
  public void savePersonal(PersonalDetails personaldetails) {
    logger.info("Recieved personaldetails object for saving into databse");
    MappingManager manager = connection.getManager();
    Mapper<PersonalDetails> map = manager.mapper(PersonalDetails.class);
    map.save(personaldetails);

  }

  @Override
  public List<EmployerDetails> employerDetails() {
    logger.info("Recieved get request from the service for all employer details");
    Select select = QueryBuilder.select().all().from("employerdetails");
    ResultSet resultset = connection.getSession().execute(select);
    MappingManager manager = connection.getManager();
    Mapper<EmployerDetails> map = manager.mapper(EmployerDetails.class);
    Result<EmployerDetails> result = map.map(resultset);
    return result.all();
  }

  @Override
  public List<PersonalDetails> personalDetails() {
    logger.info("Recieved get request from the service for all personal details");
    Select select = QueryBuilder.select().all().from("personaldetails");
    ResultSet resultSet = connection.getSession().execute(select);
    MappingManager manager = connection.getManager();
    Mapper<PersonalDetails> map = manager.mapper(PersonalDetails.class);
    Result<PersonalDetails> result = map.map(resultSet);
    return result.all();
  }

  @Override
  public List<EmployeAddtionalDetailsOut> getEmployeAllAddtionalDetials() {
    Select select = QueryBuilder.select().all().from("emp_additional_details");
    ResultSet resultSet = connection.getSession().execute(select);
    MappingManager manager = connection.getManager();
    Mapper<EmployeAddtionalDetailsOut> map = manager.mapper(EmployeAddtionalDetailsOut.class);
    Result<EmployeAddtionalDetailsOut> result = map.map(resultSet);
    return result.all();
  }

  @Override
  public List<PersonalDetails> personalDetails(int employeeId) {
    logger.info("Recieved request to  repository for getting personaldetails by id");
    Select selectingPersonalDetails = QueryBuilder.select().all().from("personaldetails");
    selectingPersonalDetails.where(QueryBuilder.eq("employeeId", employeeId));
    ResultSet resultSet = connection.getSession().execute(selectingPersonalDetails);
    MappingManager manager = connection.getManager();
    Mapper<PersonalDetails> map = manager.mapper(PersonalDetails.class);
    Result<PersonalDetails> result = map.map(resultSet);
    return result.all();
  }



  @Override
  public void saveEmpAddtionalDetails(
      com.ceva.batch.split.usermanagement.dto.EmployeAddtionalDetails employeAddtionalDetails) {
    MappingManager mappingManager = connection.getManager();
    Mapper<com.ceva.batch.split.usermanagement.dto.EmployeAddtionalDetails> map = mappingManager
        .mapper(com.ceva.batch.split.usermanagement.dto.EmployeAddtionalDetails.class);

    logger.info("Data got saved");
    map.save(employeAddtionalDetails);

  }

  @Override
  public void saveAdditionalXml(EmployeAddtionalDetails addtionalDetails) {
    MappingManager mappingManager = connection.getManager();
    Mapper<EmployeAddtionalDetails> map = mappingManager.mapper(EmployeAddtionalDetails.class);
    map.save(addtionalDetails);
  }


  @Override
  public void saveEmpEduJsonData(EmployeEducation educationDetails) {
    MappingManager mappingManager = connection.getManager();
    logger.info("" + educationDetails.toString());
    Mapper<EmployeEducation> map = mappingManager.mapper(EmployeEducation.class);
    logger.info("Data got saved");
    map.save(educationDetails);
  }

  @Override
  public List<com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployeEducation> getAllEmpEducationDetails() {
    logger.info("Recieved get request from the service for all employe Edcucation details");
    Select select = QueryBuilder.select().all().from("employe_education_details");
    ResultSet resultset = connection.getSession().execute(select);
    MappingManager manager = connection.getManager();
    Mapper<com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployeEducation> map = manager
        .mapper(com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployeEducation.class);
    Result<com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployeEducation> result =
        map.map(resultset);
    return result.all();
  }

  @Override
  public List<EmployerDetails> employeeDetails(int employerSno) {
    logger.info("Recieved request to repository for getting employerdetails by id");
    Select selectingEmployerDetails = QueryBuilder.select().all().from("employerdetails");
    selectingEmployerDetails.where(QueryBuilder.eq("employerSno", employerSno));
    selectingEmployerDetails.allowFiltering();
    ResultSet resultSet = connection.getSession().execute(selectingEmployerDetails);
    MappingManager manager = connection.getManager();
    Mapper<EmployerDetails> map = manager.mapper(EmployerDetails.class);
    Result<EmployerDetails> result = map.map(resultSet);
    return result.all();
  }

 

}
