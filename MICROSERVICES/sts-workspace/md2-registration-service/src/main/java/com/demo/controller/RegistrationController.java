package com.demo.controller;
import com.demo.entity.Registration;
import com.demo.service.RegistrationService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v2")
public class RegistrationController {
//    Interface representing the environment in which the current application is running
    @Autowired
    private Environment environment;
    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/instance")
    public String getInstancePort() {
      String microservicePort =   environment.getProperty("local.server.port");
      return "Microservie running on port : " + microservicePort;
    }
    
    @PostMapping("/registrations/register")
    public Registration createRegistration(@RequestBody Registration registration) {
    	System.out.println("Registration : " + registration);
    	Registration savedRegistration = registrationService.save(registration);
    	return savedRegistration;
    }
}
