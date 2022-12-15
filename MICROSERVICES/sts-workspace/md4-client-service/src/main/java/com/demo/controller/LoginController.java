package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.RegistrationService;

@RestController
@RequestMapping("api/v3")
public class LoginController {
	@Autowired
	private RegistrationService registrationService;

	@GetMapping("/api/v2/instance")
	public String getServiceInstance() {
		String serverInstancePortString = registrationService.getServiceInstance();	
		return serverInstancePortString;
	}
	
	@GetMapping("/registrations/{email}/{password}")
	public boolean login(@PathVariable(value = "email") String email,
			@PathVariable(value = "password") String password) {
		boolean loggedIn = registrationService.login(email, password);
		if (loggedIn) {
			return true;
		} else {
			return false;
		}
	}
}
