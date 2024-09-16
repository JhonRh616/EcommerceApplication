package com.spring.ecommerce.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class EcommerceConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceConfigApplication.class, args);
	}

}
