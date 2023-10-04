
package com.ceva.batch.split;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import com.ceva.batch.split.datastax.Connection;
import com.ceva.batch.split.usermanagement.mapper.EmployerDetailsMapper;
import com.ceva.batch.split.usermanagement.mapper.PersonalDetailsMapper;
import com.ceva.batch.split.usermanagement.repository.UserManagementRepositoryImplementation;
import com.ceva.batch.split.usermanagement.service.UserManagementServiceImplementation;
import com.ceva.cfastbi.common.CommonUtils;

/**
 * Main Class.
 * 
 * @author Rajasekar.T
 *
 */
@SpringBootApplication(scanBasePackages = {"com.ceva", "com.ceva.cjf.rest"})
@EnableAutoConfiguration(
    exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class BatchSplitTemplate {

  private static final Logger LOGGER = LoggerFactory.getLogger(BatchSplitTemplate.class);

  /**
   * Main Class.
   * 
   * @author Rajasekar .T
   */
  public static void main(String[] args) {
    LOGGER.info("Starting Spring Boot Application");
    SpringApplication.run(BatchSplitTemplate.class, args);
  }

  /**
   * Creating bean of Connection class.
   * 
   * @return Connection object.
   */
  @Bean
  public Connection databaseConnnection() {
    return new Connection();
  }

  /**
   * Creating bean of CommonUtils class.
   * 
   * @return
   */
  @Bean
  public CommonUtils commonutilsObject() {
    return new CommonUtils();
  }

  @Bean
  public EmployerDetailsMapper employerMapperObject() {
    return new EmployerDetailsMapper();
  }

  @Bean
  public PersonalDetailsMapper personalMapperObject() {
    return new PersonalDetailsMapper();
  }
}
