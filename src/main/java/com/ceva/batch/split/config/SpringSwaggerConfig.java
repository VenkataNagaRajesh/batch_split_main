package com.ceva.batch.split.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringSwaggerConfig {


  /**
   * brokerageRestApi brokerageRestApi.
   * 
   * @return
   */
  @Bean
  public OpenAPI batchSplitApi() {
    return new OpenAPI().components(new Components())
        .info(new Info().title("CFAST BI transaction batch split API")
            .description("Sample API for CFAST BI transaction batch split").version("2.2.0-RC1")
            .contact(
                new Contact().name("BATCH SPLIT Team").email("DG_GL-FM-CFAST-BI@cevalogistics.com")));
  }
}
