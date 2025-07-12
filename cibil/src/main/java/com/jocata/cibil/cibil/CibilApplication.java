package com.jocata.cibil.cibil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CibilApplication {

	public static void main(String[] args) {
		SpringApplication.run(CibilApplication.class, args);
	}
}

