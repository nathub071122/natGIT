package com.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;
@RestController

public class WelcomeController {
DispatcherServlet
    @GetMapping("/welcome")
    public String getWelcomeWithHTMLAsUI() {
        String htmlOutput = "<!DOCTYPE html>";
        htmlOutput += "<html>";
        htmlOutput += "<head><title>Welcome to the Web</title></head>";
        htmlOutput += "<body><h1>This demo is a from spring boot and REST API ....</h1>" +
                "<h1 style='color:red;font-weight:bold'>Ensures developer productivity!</h1>";
        htmlOutput += "</html>";
        return  htmlOutput;
    }
}

