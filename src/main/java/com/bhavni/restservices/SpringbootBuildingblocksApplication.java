package com.bhavni.restservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//Initial Application
@SpringBootApplication(scanBasePackages = {"com.bhavni.restservices.controller","com.bhavni.restservices.model"})
public class SpringbootBuildingblocksApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootBuildingblocksApplication.class, args);

	}
}
