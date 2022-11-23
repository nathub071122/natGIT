package com.demo.controller;
import com.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class EmployeeControllerDb {
//  DEPENDENCY INJECTION
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/employees")
    public List getEmployees(){
        System.out.println("GET ALL EMPLOYEES FROM REPOSITORY");
        List employeesList = null;
        employeesList = employeeRepository.findAll();
        return  employeesList;
    }
}
