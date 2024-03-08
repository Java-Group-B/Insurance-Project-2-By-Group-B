package com.insuranceproject2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class InsuranceProject2ByGroupBApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceProject2ByGroupBApplication.class, args);
	}

}
