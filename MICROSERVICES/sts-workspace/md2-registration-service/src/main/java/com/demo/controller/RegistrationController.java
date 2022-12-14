package com.demo.controller;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v2")
public class RegistrationController {
//    Interface representing the environment in which the current application is running
    @Autowired
    private Environment environment;
    // TODO : Connect with the backend

    @GetMapping("/instance")
    public String getInstancePort() {
      String microservicePort =   environment.getProperty("local.server.port");
      return "Microservie running on port : " + microservicePort;
    }
}
