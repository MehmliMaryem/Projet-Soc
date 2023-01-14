package com.itmsd.Services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@EnableEurekaClient
public class ProduitApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProduitApplication.class, args);

	}
}
