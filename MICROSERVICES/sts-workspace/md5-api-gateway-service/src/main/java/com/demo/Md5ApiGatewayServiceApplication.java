package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class Md5ApiGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Md5ApiGatewayServiceApplication.class, args);
	}

}
