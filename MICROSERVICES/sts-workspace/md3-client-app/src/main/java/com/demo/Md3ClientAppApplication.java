package com.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import com.demo.service.RegistrationService;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Md3ClientAppApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Md3ClientAppApplication.class, args);
		RegistrationService registrationService = applicationContext.getBean("registrationService", RegistrationService.class);
		String serverInstancePortString = registrationService.getServiceInstance();	
		System.out.println("Client connected to Registration Microservice @ port : " + serverInstancePortString);
		//Login using the microservice with load balancer
		String emailIdString = "admin1@email.com";
		String passwordString = "wrongpassword";
		boolean loggedIn = registrationService.login(emailIdString, passwordString);
		if(loggedIn) {
			System.out.println("Logged In Successfully");
		}
		else {
			System.out.println("Error logging in.. Please check credentials!");
		}
		
		emailIdString = "admin1@email.com";
		 passwordString = "passtheword";
		 loggedIn = registrationService.login(emailIdString, passwordString);
		if(loggedIn) {
			System.out.println("Logged In Successfully");
		}
		else {
			System.out.println("Error logging in.. Please check credentials!");
		}
	}

}
