package com.demo.controller;
import com.demo.entity.EmployeeEntity;
import com.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1")
public class EmployeeControllerDb {
    //  DEPENDENCY INJECTION
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/employees")
    public List getEmployees() {
        System.out.println("GET ALL EMPLOYEES FROM REPOSITORY");
        List employeesList = null;
        employeesList = employeeRepository.findAll();
        return employeesList;
    }
    @PostMapping("/employees")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeFormClient) {
        EmployeeEntity employeeEntity = employeeRepository.save(employeeFormClient);
        return employeeEntity;
    }
    @DeleteMapping("/employees/{id}")
    public EmployeeEntity deleteEmployeeById(@PathVariable(value = "id") Integer idFromClient) {
//        FETCH THE EMPLOYEE ENTITY FROM THE DATABASE FOR THE SPECIFIC ID
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(idFromClient);
        EmployeeEntity deleteEmployee = employeeEntityOptional.get();
        employeeRepository.delete(deleteEmployee);
        return deleteEmployee;
    }
}
