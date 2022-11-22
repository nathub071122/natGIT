package com.demo.controller;
import com.demo.model.EmployeeModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/v0")
public class EmployeeController {
    @GetMapping("/welcome")
    public String getWelcomeWithHTMLAsUI() {
        String htmlOutput = "<!DOCTYPE html>";
        htmlOutput += "<html>";
        htmlOutput += "<head><title>Welcome to the Web</title></head>";
        htmlOutput += "<body><h1>This demo is a from spring boot and REST API ....</h1>" +
                "<h1 style='color:red;font-weight:bold'>Ensures developer productivity!</h1> <br/> " +
                " Enter text to search :  <input type = 'text' value=></input> <br/>" +
                " <input type='Submit' value='Search'></input>";
        htmlOutput += "</html>";
        return  htmlOutput;
    }

//    JAVA OBJECT SERIALIZED INTO JSON
    @GetMapping("/employee")
    public EmployeeModel getEmployee(){
        EmployeeModel employeeModel = new EmployeeModel(1,"Ben",5000);
        return employeeModel;
    }

//    IP : RETURN A LIST OF 3-5 EMPLOYEES
    public List getEmployeeList() {
        return null;
    }
    //    IP : RETURN A MAP OF 3-5 EMPLOYEES (EMPLOYEEID : KEY, EMPLOYEE INSTANCE : VALUE
    public Map getEmployeeMap() {
        return null;
    }
}
