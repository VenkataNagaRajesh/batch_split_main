package com.ceva.cfastbi.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.logging.LogLevel;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.ceva.batch.split.common.Constant;
import com.ceva.batch.split.common.RestClientUtil;
import com.ceva.batch.split.exception.BatchSplitException;
import com.ceva.batch.split.jaxb.cwo.UniversalEventData;
import com.ceva.batch.split.jaxb.cwo.UniversalResponseData;
import com.ceva.batch.split.jaxb.cwo.UniversalShipmentData;
import com.ceva.batch.split.jaxb.cwo.UniversalTransactionBatchData;
import com.ceva.batch.split.jaxb.ofs.MasterForm;
import com.ceva.batch.split.jaxb.ofs.XMLBooking;
import com.ceva.batch.split.usermanagement.dto.EmployeAddtionalDetailsXml;
import com.ceva.batch.split.usermanagement.dto.EmployeEducationXml;
import com.ceva.batch.split.usermanagement.dto.EmployerDetailsXml;
import com.ceva.batch.split.usermanagement.dto.PersonalDetailsXml;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * CommonUtils.
 * 
 * @author Narayana
 */
public class CommonUtils {

  @Value("${fmds.base.service.user:cjf.admin}")
  private static String userName;

  @Value("${fmds.base.service.password:CJFAdmin1$}")
  private static String password;

  private static JAXBContext xmlJaxbContext = null;
  private static JAXBContext ofsMasterFormXmlBookingContext = null;
  private static JAXBContext universalShipmentJaxbContext = null;
  private static JAXBContext universalEventDataJaxbContext = null;
  private static JAXBContext universalResponseJaxbContext = null;
  private static JAXBContext contextResponse = null;
  private static final String FORMATED_OUTOUT = "jaxb.formatted.output";
  private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);

  private static ObjectMapper mapper =
      new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  private static String DEFAULT_SIZE_OBJECTS = "100";

  static {
    try {
      LOGGER.info("JAXBContext initializer....Start");

      universalShipmentJaxbContext = JAXBContext.newInstance(UniversalShipmentData.class);
      xmlJaxbContext = JAXBContext.newInstance(XMLBooking.class);
      ofsMasterFormXmlBookingContext = JAXBContext.newInstance(MasterForm.class);
      universalEventDataJaxbContext = JAXBContext.newInstance(UniversalEventData.class);
      universalResponseJaxbContext = JAXBContext.newInstance(UniversalResponseData.class);
      LOGGER.info("JAXBContext initializer....End");
    } catch (JAXBException e) {
      LOGGER.error("Error initializing JAXB Contexts, ErrorMessage {}", e.getMessage());
    }
  }

  /**
   * To convert request XML string to domain object.
   * 
   * @param request Data input
   * @return persistent entity object
   * @throws JAXBException when the object is not parsed successfully
   * 
   */
  public static UniversalShipmentData convertCwoStringToXmlObject(String request)
      throws JAXBException {
    JAXBElement<UniversalShipmentData> root = null;
    StreamSource source = new StreamSource(new ByteArrayInputStream(request.getBytes()));
    Unmarshaller universalShipmentUnmarshaller = universalShipmentJaxbContext.createUnmarshaller();
    root = universalShipmentUnmarshaller.unmarshal(source, UniversalShipmentData.class);
    LOGGER.debug("Unmarshalled CWO XML ");
    return root.getValue();
  }


  /**
   * To convert request XML string to domain object.
   * 
   * @param responseUnit Data input
   * @return String entity object
   * @throws Exception when the object is not parsed successfully
   */
  public static String getPayloadForCwoGeneralLegger(UniversalResponseData responseUnit)
      throws Exception {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
      QName qname = new QName(
          UniversalResponseData.class.getPackage().getAnnotation(XmlSchema.class).namespace(),
          "UniversalResponseData");
      JAXBElement<UniversalResponseData> root =
          new JAXBElement<>(qname, UniversalResponseData.class, responseUnit);
      Marshaller um = universalResponseJaxbContext.createMarshaller();
      um.setProperty(FORMATED_OUTOUT, Boolean.TRUE);
      um.marshal(root, baos);
      return new String(baos.toByteArray());
    } catch (Exception e) {
      throw new BatchSplitException("Failed marshalling CWO UniversalResponseData", null,
          LogLevel.FATAL.name(), null);
    }
  }



  /**
   * To convert request XML string to domain object.
   * 
   * @param request Data input
   * @return persistent entity object
   * @throws JAXBException when the object is not parsed successfully
   * 
   */
  public static UniversalEventData convertCwoEventStringToXmlObject(String request)
      throws JAXBException {
    JAXBElement<UniversalEventData> root = null;
    StreamSource source = new StreamSource(new ByteArrayInputStream(request.getBytes()));
    Unmarshaller universalShipmentUnmarshaller = universalEventDataJaxbContext.createUnmarshaller();
    root = universalShipmentUnmarshaller.unmarshal(source, UniversalEventData.class);
    LOGGER.debug("Unmarshalled CWO XML ");
    return root.getValue();
  }

  /**
   * Encoding URL param.
   * 
   * @param value inputstring
   * @return Encoded param
   * @throws UnsupportedEncodingException UnsupportedEncodingException
   */
  public static String encodeValue(String value) throws Exception {
    String encodedValue = URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    return encodedValue.replace("%2F", "%252F");
  }

  /**
   * callReadEndpoint.
   * 
   * @param baseUrl baseUrl
   * @param authorizationRequired authorizationRequired
   * @param responseFrom responseFrom
   * @return string
   * @throws BatchSplitException BatchSplitException
   */
  public static String callReadEndpoint(String baseUrl, boolean authorizationRequired,
      String responseFrom) throws BatchSplitException {
    long start = System.currentTimeMillis();
    RestClientUtil client = RestClientUtil.getInstance(baseUrl, userName, password);

    Map.Entry<Integer, String> response = client.sendGetRequest();
    LOGGER.info("Invoked {} service Endpoint and Total time taken to respond in ms is {}",
        responseFrom, System.currentTimeMillis() - start);
    if (response.getKey() == -1) {
      throw new BatchSplitException(response.getValue(), responseFrom, Constant.BATCH,
          LogLevel.FATAL.name());
    } else if (response.getKey() == 1) {
      return Constant.NO_RESULTS_FOUND;
    } else {
      return response.getValue();
    }

  }


  /**
   * To get the XMLBooking object.
   * 
   * @param bookingDataSource String
   * @return XMLBooking XMLBooking
   * @throws JAXBException JAXBException
   * 
   */
  public static XMLBooking getXmlStringtoXmlBooking(String bookingDataSource) throws JAXBException {
    MasterForm masterForm = convertXmlStringFromMasterFormData(bookingDataSource);
    if (Objects.nonNull(masterForm) && Objects.nonNull(masterForm.getHouses())
        && !CollectionUtils.isEmpty(masterForm.getHouses().getXMLBooking())
        && Objects.nonNull(masterForm.getHouses().getXMLBooking().get(0))) {
      return masterForm.getHouses().getXMLBooking().get(0);
    } else {
      return convertXmlStringtoXmlBookingObject(bookingDataSource);
    }
  }

  /**
   * To convert request XML string to domain object.
   * 
   * @param inputXmlContent Data input
   * @return persistent entity object
   * @throws JAXBException when the object is not parsed successfully
   * 
   */
  public static MasterForm convertXmlStringFromMasterFormData(String inputXmlContent)
      throws JAXBException {
    LOGGER.debug("Unmarshall: XML");
    JAXBElement<MasterForm> root = null;
    StreamSource source = new StreamSource(new ByteArrayInputStream(inputXmlContent.getBytes()));
    Unmarshaller xmlBookingUnmarshaller = ofsMasterFormXmlBookingContext.createUnmarshaller();
    root = xmlBookingUnmarshaller.unmarshal(source, MasterForm.class);
    LOGGER.debug("Unmarshalled OFS MasterForm ");
    return root.getValue();
  }

  /**
   * checking the data is json or not.
   * 
   */

  public static Boolean isJsonOrNot(String json) {
    LOGGER.info("Recieved json ");
    try {
      ObjectMapper mapper = new ObjectMapper();
      mapper.readTree(json);
      LOGGER.info("Recieved json is valid json");
      return true;
    } catch (Exception e) {
      LOGGER.error("Recieved json is not valid json");
      return false;
    }

  }

  /**
   * checking the data is XML or not.
   * 
   */
  public static boolean isXmlOrNot(String xml) {
    try {

      SAXParserFactory.newInstance().newSAXParser().getXMLReader()
          .parse(new InputSource(new StringReader(xml)));
      LOGGER.info("Recieved xml data is valid and it returns true");
      return true;
    } catch (ParserConfigurationException | SAXException | IOException ex) {
      LOGGER.error("Recieved xml is not valid xml");
      return false;
    }
  }



  /**
   * To convert request XML string to domain object.
   * 
   * @param inputXmlContent Data input
   * @return persistent entity object
   * @throws JAXBException when the object is not parsed successfully
   * 
   */
  public static XMLBooking convertXmlStringtoXmlBookingObject(String inputXmlContent)
      throws JAXBException {
    JAXBElement<XMLBooking> root = null;
    StreamSource source = new StreamSource(new ByteArrayInputStream(inputXmlContent.getBytes()));
    Unmarshaller ofsXmlUnmarshaller = xmlJaxbContext.createUnmarshaller();
    root = ofsXmlUnmarshaller.unmarshal(source, XMLBooking.class);
    LOGGER.debug("Unmarshalled OFS XML ");
    return root.getValue();
  }


  /**
   * To convert request XML string to domain object.
   * 
   * @param request Data input
   * @throws Exception .
   */
  public static UniversalResponseData convertCwoBatchStringToXmlObject(String request,
      Charset charset) throws Exception {
    LOGGER.debug("Unmarshall: XML CWO GL Batch");
    try {
      XMLInputFactory xif = XMLInputFactory.newFactory();
      xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
      xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
      ByteArrayInputStream bais;
      if (charset != null) {
        bais = new ByteArrayInputStream(replaceBadChars(request).getBytes(charset));
      } else {
        bais = new ByteArrayInputStream(replaceBadChars(request).getBytes());
      }
      XMLStreamReader xsr = xif.createXMLStreamReader(bais);
      Unmarshaller um = universalResponseJaxbContext.createUnmarshaller();
      JAXBElement<UniversalResponseData> root = um.unmarshal(xsr, UniversalResponseData.class);
      if (root.getValue() != null && root.getValue().getData() != null
          && root.getValue().getData().getAny() != null) {
        Object child = root.getValue().getData().getAny();
        if (!(child instanceof JAXBElement)) {
          root.getValue().getData().setAny(convertCwoResopnseDataStringToXmlObject((Node) child));
        }
      }
      return root.getValue();
    } catch (Exception e) {
      if (Objects.nonNull(e.getCause())) {
        LOGGER.error("Failed parsing xml for CWO UniversalResponseData : "
            + e.getCause().getCause().getMessage());
        throw new BatchSplitException(e.getCause().getCause().getMessage() + "  " + e.getMessage(),
            null, null, LogLevel.FATAL.toString());
      } else {
        LOGGER.error("Failed parsing xml for CWO UniversalResponseData : " + e.getMessage());
        throw e;
      }
    }
  }

  private static JAXBElement<UniversalTransactionBatchData> convertCwoResopnseDataStringToXmlObject(
      Node child) {
    if (child == null) {
      return null;
    }
    try {
      Unmarshaller um = universalResponseJaxbContext.createUnmarshaller();
      return (JAXBElement<UniversalTransactionBatchData>) um.unmarshal(child);
    } catch (Exception e) {
      LOGGER.error("Input Node:: {}", child.getLocalName());
      LOGGER.error("Failed parsing xml CWO UniversalTransactionBatchData", e);
    }
    return null;
  }



  private static String replaceBadChars(String request) {
    String result = request;
    if (result != null) {
      result = result.replace("\t", " ").replace("\n", " ");
    } else {
      result = "";
    }
    return result;
  }

  /**
   * json data validator.
   *
   */
  public boolean jsonData(String data) {
    try {
      new ObjectMapper().readTree(data);
      return true;
    } catch (IOException e) {
      return false;
    }
  }

  /**
   * xml data validation.
   * 
   */
  public static boolean xmlData(String xmlData) {
    try {
      DocumentBuilderFactory.newInstance().newDocumentBuilder()
          .parse(new InputSource(new StringReader(xmlData)));

      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Unmarshalling the data.
   * 
   */
  public static EmployerDetailsXml xmlToObject(String xml) throws JAXBException {
    LOGGER.info("Recieved employerdetails xml string  " + xml);

    JAXBContext jaxbContext = JAXBContext.newInstance(EmployerDetailsXml.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    StringReader reader = new StringReader(xml);
    return (EmployerDetailsXml) unmarshaller.unmarshal(reader);
  }

  /**
   * Parsing data of PersonalDetailsXml.
   * 
   * @return Personal DetailsXml data.
   * 
   */
  public static PersonalDetailsXml xmlToObjectPeronalDetails(String personaldetails) throws JAXBException {
    LOGGER.info("Recieved personaldetails xml " + personaldetails);
    JAXBContext context = JAXBContext.newInstance(PersonalDetailsXml.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    StringReader reader = new StringReader(personaldetails);
    return (PersonalDetailsXml) unmarshaller.unmarshal(reader);
  }

  /**
   * Parsing data of EmployeAddionalDetials data.
   * 
   * @return Personal DetailsXml data.
   * 
   */
  public static EmployeAddtionalDetailsXml xmlToObjectEmployeAddtionalDetails(String additionalDetails)
      throws JAXBException {
    LOGGER.info("Recieved additonal details xml " + additionalDetails);
    JAXBContext context = JAXBContext.newInstance(EmployeAddtionalDetailsXml.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    StringReader reader = new StringReader(additionalDetails);
    return (EmployeAddtionalDetailsXml) unmarshaller.unmarshal(reader);
  }

  /**
   * Parsing data of EmployeEducationDetails Data.
   * 
   * @throws JAXBException
   * 
   * @returns EmployeEducation Details xml Data.
   */

  public static EmployeEducationXml xmlToEducationDetailsObject(String educationDetails)
      throws JAXBException {
    LOGGER.info("Recived employeEducationalDetailsObject" + educationDetails);
    JAXBContext content = JAXBContext.newInstance(EmployeEducationXml.class);
    Unmarshaller unmarshaller = content.createUnmarshaller();
    StringReader reader = new StringReader(educationDetails);
    return (EmployeEducationXml) unmarshaller.unmarshal(reader);
  }
}
