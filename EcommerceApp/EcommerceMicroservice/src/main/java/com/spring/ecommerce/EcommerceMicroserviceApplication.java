package com.spring.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EcommerceMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceMicroserviceApplication.class, args);
	}

}
