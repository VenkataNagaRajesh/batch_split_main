package com.ceva.batch.split.rest;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ceva.batch.split.common.ResponseMessage;
import com.ceva.batch.split.exception.InvalidInputException;
import com.ceva.batch.split.jaxb.employeedetails.EmployeeDetails;
import com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployeAddtionalDetailsOut;
import com.ceva.batch.split.service.finance.FinanceService;
import com.ceva.batch.split.usermanagement.dto.EmployeAddtionalDetailsXml;
import com.ceva.batch.split.usermanagement.dto.EmployeEducationXml;
import com.ceva.batch.split.usermanagement.dto.EmployerDetails;
import com.ceva.batch.split.usermanagement.dto.EmployerDetailsXml;
import com.ceva.batch.split.usermanagement.dto.PersonalDetails;
import com.ceva.batch.split.usermanagement.dto.PersonalDetailsXml;
import com.ceva.batch.split.usermanagement.mapper.EmployerDetailsMapper;
import com.ceva.batch.split.usermanagement.mapper.PersonalDetailsMapper;
import com.ceva.batch.split.usermanagement.service.UserManagementService;
import com.ceva.cfastbi.common.CommonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/*
 * @author Laxminarayana
 *
 */
@RestController
@RequestMapping(value = "/batch-split")
public class BatchSplitRestController {

  private static final Logger logger = LoggerFactory.getLogger(BatchSplitRestController.class);

  @Autowired
  UserManagementService usermanagementservice;
  @Autowired
  FinanceService financeService;
  @Autowired
  PersonalDetailsMapper personaldetailsmapper;
  @Autowired
  EmployerDetailsMapper employermapper;

  /**
   * posting employer details xml data.
   * 
   */
  @RequestMapping(path = "/employerdetails", method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public String insertEmployeeDetails(@RequestBody String employerdetails,
      @RequestHeader HttpHeaders header) throws Exception {
    EmployerDetails employerobject;
    com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployerDetails employerobject2 = null;
    MediaType type = header.getContentType();
    String media = String.valueOf(type);
    logger.info("Recieving data is  " + employerdetails);
    if (CommonUtils.isJsonOrNot(employerdetails) == true && media.equals("application/json")) {
      ObjectMapper mapper = new ObjectMapper();
      employerobject = mapper.readValue(employerdetails, EmployerDetails.class);
      // employerobject2 = employermapper.mappingTwoEmployerDto(employerobject);
      // logger.info("mapped object is " + employerobject);
      usermanagementservice.saveEmployer(employerobject);
      return employerdetails;
    } else if (CommonUtils.isXmlOrNot(employerdetails) == true && media.equals("application/xml")) {
      EmployerDetailsXml employerdetailobject = CommonUtils.xmlToObject(employerdetails);
      // employerobject2 = employermapper.mappingEmployerXml(employerdetailobject);
      // logger.info("mapped xml object is " + employerobject2);
      usermanagementservice.saveEmployerXml(employerdetailobject);
      return employerdetails;
    } else {
      logger.error("Given input is not a valid json or xml");
      throw new InvalidInputException("inavlid input format");
    }

  }

  /**
   * posting personaldetails data.
   * 
   */
  @RequestMapping(path = "/personaldetails", method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public String insertPersonalDetails(@RequestBody String personaldetails,
      @RequestHeader HttpHeaders header) throws Exception {
    MediaType type = header.getContentType();
    String media = String.valueOf(type);
    logger.info("Recieving data is  " + personaldetails);
    com.ceva.batch.split.rest.usermanagement.outbound.dto.PersonalDetails personaldetailsobject2;
    if (CommonUtils.isJsonOrNot(personaldetails) == true && media.equals("application/json")) {
      ObjectMapper mapper = new ObjectMapper();
      PersonalDetails personaldetailsobject =
          mapper.readValue(personaldetails, PersonalDetails.class);
      personaldetailsobject2 = personaldetailsmapper.mappingPersonalDetails(personaldetailsobject);
      logger.info("mapped object of personaldetails xml is " + personaldetailsobject2);
      usermanagementservice.savePersonalDetails(personaldetailsobject);
      return personaldetails;
    }
    if (CommonUtils.isXmlOrNot(personaldetails) == true && media.equals("application/xml")) {
      PersonalDetailsXml personaldetailsobject =
          CommonUtils.xmlToObjectPeronalDetails(personaldetails);
      usermanagementservice.savePersonalDetails(personaldetailsobject);
      return personaldetails;
    } else {
      logger.error("Given input is not a valid json or xml");
      throw new InvalidInputException("inavlid input format");
    }

  }


  // /**
  // * Getting EmployeeDetails all.
  // *
  // * @return EmployeeDetails.
  // */
  // @GetMapping("/employeedetails")
  // public ResponseEntity<EmployeeDetails> employeeDetails() {
  // EmployeeDetails employeedetails = new EmployeeDetails();
  // return new ResponseEntity<>(employeedetails, HttpStatus.OK);
  //
  // }

  /**
   * Getting EmployeeDetails all.
   * 
   * @return EmployeeDetails.
   */
  @GetMapping("/employeedetails")
  public ResponseEntity<EmployeeDetails> getEmployeeDetails() {
    EmployeeDetails employeedetails = new EmployeeDetails();
    return new ResponseEntity<>(employeedetails, HttpStatus.OK);

  }

  @GetMapping("/employerdetails")
  public List<com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployerDetails> getEmployerDetails() {
    logger.info("Recieved request for getting all employerDetails");
    return usermanagementservice.employerDetails();
  }


  @GetMapping("/employeeducationdetails")
  public String getEmployeEducationDetails() {
    return "employer details";
  }

  /**
   * Getting EmployerDetails all.
   * 
   * @return EmployerDetails.
   */
  @GetMapping("/employeeadditionaldetails")
  public String getEmployeAdditonalDetails() {
    return "PersonalDetails";
  }

  /**
   * Getting EmployerDetails by employerSno.
   *
   * @return EmployerDetails.
   */
  @GetMapping("/employee/{employerSno}")
  public List<com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployerDetails> getEmployerBySno(
      @PathVariable int employerSno) {
    logger.info("Recieved request to Employer in rest for getting data by id");
    return usermanagementservice.employeeDetails(employerSno);
  }

  /**
   * Getting PersonalDetails by employeeId.
   * 
   * @return PersonalDetails.
   */
  @GetMapping("/personaldetails/{employeeId})")
  public List<com.ceva.batch.split.rest.usermanagement.outbound.dto.PersonalDetails> getPersonalDetailsById(
      @PathVariable int employeeId) {
    logger.info("Recieved request to personalDdetails get end point by id ");
    return usermanagementservice.personalDetails(employeeId);
  }

  @GetMapping("/personaldetails")
  public List<com.ceva.batch.split.rest.usermanagement.outbound.dto.PersonalDetails> getPersonalDetails() {
    return usermanagementservice.personalDetails();
  }


  @GetMapping("/employeeducationdetails")
  public List<com.ceva.batch.split.rest.usermanagement.outbound.dto.EmployeEducation> employeEducationDetails() {
    return usermanagementservice.getEducationDetails();
  }

  @GetMapping("/employeadditionaldetails")
  public List<EmployeAddtionalDetailsOut> employeAdditonalDetails() {
    return usermanagementservice.getEmployeAdditionalDetails();
  }


  /**
   * posting additionaldetails xml data.
   * 
   */
  @RequestMapping(value = "addtionaldetials",
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      method = RequestMethod.POST,
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public String insertAdditionalDetails(@RequestBody String addtionalDetails,
      @RequestHeader HttpHeaders httpHeader) throws Exception {
    MediaType mediaType = httpHeader.getContentType();
    String contentType = mediaType.toString();
    com.ceva.batch.split.rest.usermanagement.inbound.dto.EmployeAddtionalDetailsInBound employeAddtionalDetails2;
    if ((contentType.contains("application/json"))) {
      try {
        if ((CommonUtils.isJsonOrNot(addtionalDetails) == true)) {
          ObjectMapper mapper = new ObjectMapper();
          com.ceva.batch.split.rest.usermanagement.inbound.dto.EmployeAddtionalDetailsInBound employeAdditionalDetails =
              mapper.readValue(addtionalDetails,
                  com.ceva.batch.split.rest.usermanagement.inbound.dto.EmployeAddtionalDetailsInBound.class);
          usermanagementservice.saveEmpAdditionalDetails(employeAdditionalDetails);
          return addtionalDetails;
        } else {
          throw new InvalidInputException("Data is not in json format");
        }
      } catch (Exception e) {
        throw new InvalidInputException(
            "Data is not in json format. Do you want to save the Data please change the Data into json format.");
      }
    } else if (contentType.contains("application/xml")) {

      try {
        if (CommonUtils.isXmlOrNot(addtionalDetails)) {
          EmployeAddtionalDetailsXml additionalDetails =
              CommonUtils.xmlToObjectEmployeAddtionalDetails(addtionalDetails);
          usermanagementservice.saveEmployeAdditionalDetailsXml(additionalDetails);
          return addtionalDetails;
        } else {
          throw new InvalidInputException("Data is not in Xml format");
        }
      } catch (Exception e) {
        logger.info(e.toString());
        throw new InvalidInputException(
            "Data is not in Xml format. Do you want to save the Data please change the Data into XML format.");
      }
    }

    return null;
  }


  /**
   * posting additionaldetails xml data.
   * 
   */
  @RequestMapping(value = "educationaldetials",
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      method = RequestMethod.POST,
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public String insertEducationalDetails(@RequestBody String educationalDetails,
      @RequestHeader HttpHeaders httpHeader) throws Exception {
    MediaType mediaType = httpHeader.getContentType();
    String contentType = mediaType.toString();
    if ((contentType.contains("application/json"))) {
      try {
        if ((CommonUtils.isJsonOrNot(educationalDetails) == true)) {
          ObjectMapper mapper = new ObjectMapper();
          com.ceva.batch.split.rest.usermanagement.inbound.dto.EmployeEducationInBound employeEducationInBound1 =
              mapper.readValue(educationalDetails,
                  com.ceva.batch.split.rest.usermanagement.inbound.dto.EmployeEducationInBound.class);
          usermanagementservice.saveEducationalDetails(employeEducationInBound1);
          return educationalDetails;
        } else {
          throw new InvalidInputException("Data is not in json format");
        }
      } catch (Exception e) {
        logger.info(e.toString());
        throw new InvalidInputException(
            "Data is not in json format. Do you want to save the Data please change the Data into json format."
                + e.toString());
      }
    } else if (contentType.contains("application/xml")) {

      try {
        if (CommonUtils.isXmlOrNot(educationalDetails)) {
          EmployeEducationXml employeEducationDetailsObject =
              CommonUtils.xmlToEducationDetailsObject(educationalDetails);
          usermanagementservice.saveEmployeEducationalDetailsXml(employeEducationDetailsObject);
          return educationalDetails;
        } else {
          throw new InvalidInputException("Data is not in Xml format");
        }
      } catch (Exception e) {
        logger.info(e.toString());
        throw new InvalidInputException(
            "Data is not in Xml format. Do you want to save the Data please change the Data into XML format.");
      }
    }

    return null;
  }


  /**
   * writeUnifiedData.
   * 
   * @param request String
   * @return
   */
  @PostMapping(value = "")
  @ApiOperation(value = "Process transcation batch to individual records",
      notes = "Process transcation batch to individual records")
  public ResponseEntity<ResponseMessage> splitTranscationBatch(
      @ApiParam(value = "Provide mentioned transaction batch ",
          required = true) @RequestBody String request) {

    return ResponseEntity.status(HttpStatus.OK)
        .body(new ResponseMessage("Application is not ready to proceed"));
  }


  /**
   * financeTranscationBatch.
   * 
   * @param request String
   * @throws Exception Exception
   * @return
   */
  @PostMapping(value = "finance")
  @ApiOperation(value = "Process finance transcation batch to individual records",
      notes = "Process finance transcation batch to individual records")
  public ResponseEntity<ResponseMessage> financeTranscationBatch(
      @ApiParam(value = "Provide mentioned transaction batch ",
          required = true) @RequestBody String request)
      throws Exception {
    StringBuilder message = financeService.processfinanceService(request);
    if (StringUtils.isBlank(message)) {
      message.append("Request is not processed.");
    }
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message.toString()));
  }

}


