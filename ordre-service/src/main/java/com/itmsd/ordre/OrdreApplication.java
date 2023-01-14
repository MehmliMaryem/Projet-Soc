package com.itmsd.ordre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class OrdreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdreApplication.class, args);
		
	}
}
