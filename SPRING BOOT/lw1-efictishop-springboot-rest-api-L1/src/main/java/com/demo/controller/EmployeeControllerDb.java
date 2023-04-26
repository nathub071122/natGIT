package com.demo.controller;
import com.demo.entity.EmployeeEntity;
import com.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class EmployeeControllerDb {
    //  DEPENDENCY INJECTION
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping(value = "/employees", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List getEmployees() {
        System.out.println("GET ALL EMPLOYEES FROM REPOSITORY");
        List employeesList = null;
        employeesList = employeeRepository.findAll();
        employeesList.forEach((employee)-> {System.out.println(employee);});
        return employeesList;
    }

    //INSTANT PRACTICE
    public EmployeeEntity getEmployeeById(@PathVariable(value = "id") Integer idFromClient) {
        System.out.println("GET EMPLOYEE WITH THE GIVEN ID FROM REPOSITORY");
        return null;
    }

    public EmployeeEntity updateEmployee(@PathVariable(value = "id") Integer idFromClient, @RequestBody EmployeeEntity employeeFormClient) {
        System.out.println("UPDATE EMPLOYEE WITH THE GIVEN ID TO REPOSITORY");
        return null;
    }
    @PostMapping("/employees")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeFormClient) {
        System.out.println("ADD EMPLOYEE TO REPOSITORY");
        EmployeeEntity employeeEntity = employeeRepository.save(employeeFormClient);
        return employeeEntity;
    }
    @DeleteMapping("/employees/{id}")
    public EmployeeEntity deleteEmployeeById(@PathVariable(value = "id") Integer idFromClient) {
        System.out.println("DELETE EMPLOYEE FROM REPOSITORY");
//        FETCH THE EMPLOYEE ENTITY FROM THE DATABASE FOR THE SPECIFIC ID
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(idFromClient);
        EmployeeEntity deleteEmployee = employeeEntityOptional.get();
        employeeRepository.delete(deleteEmployee);
        return deleteEmployee;
    }
}
