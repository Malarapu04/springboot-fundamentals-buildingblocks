package com.bhavni.restservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//Initial Application
@SpringBootApplication(scanBasePackages = {"com.bhavni.restservices.controller","com.bhavni.restservices.model"
})
@EntityScan("com.bhavni.restservices.entities")
public class SpringbootBuildingblocksApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootBuildingblocksApplication.class, args);

	}
}
