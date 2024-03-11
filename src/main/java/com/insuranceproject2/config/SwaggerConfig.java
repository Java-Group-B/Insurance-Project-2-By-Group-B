package com.insuranceproject2.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@EnableAutoConfiguration
public class SwaggerConfig {

	 @Bean
	  public OpenAPI getRestApiDocumentation() {
	      return new OpenAPI()
	              .info(new Info().title("Insurance API")
	              .description("Insurance details for users")
	              .termsOfService("https://www.hdfclife.com/terms-and-conditions")		
	              .version("1.0")
	              .contact(new Contact().name("Hdfc insurance").email("Merchanthelpdesk.Pune@hdfcbank.com").url("www.hdfclife.com"))
	              .license(new License().name("Apache 2.0").url("http://insurance.org"))
	              )
	              .externalDocs(new ExternalDocumentation()
	              .description("This is details of insurance plans")
	              .url("https://www.hdfclife.com/all-insurance-plans"));
	  }
}
