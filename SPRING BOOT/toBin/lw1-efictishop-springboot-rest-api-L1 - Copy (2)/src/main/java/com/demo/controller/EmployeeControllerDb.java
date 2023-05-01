package com.demo.controller;
import com.demo.dto.EmployeeDTO;
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
    public List<EmployeeEntity> getEmployees() {
        System.out.println("GET ALL EMPLOYEES FROM REPOSITORY");
        List<EmployeeEntity> employeesList = null;
        employeesList = employeeRepository.findAll();
        employeesList.forEach(employee-> System.out.println(employee));
        return employeesList;
    }

    @PostMapping("/employees")
    public EmployeeEntity createEmployee(@RequestBody EmployeeDTO employeeFormClient) {
        EmployeeEntity employeeEntity  = new EmployeeEntity(employeeFormClient.getId(),employeeFormClient.getName(), employeeFormClient.getSalary());
        return employeeRepository.save(employeeEntity);
    
    }
    @DeleteMapping("/employees/{id}")
    public EmployeeEntity deleteEmployeeById(@PathVariable(value = "id") Integer idFromClient) {

        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(idFromClient);
        EmployeeEntity deleteEmployee = new EmployeeEntity();
        if(employeeEntityOptional.isPresent()){
             deleteEmployee = employeeEntityOptional.get();
        }
        employeeRepository.delete(deleteEmployee);
        return deleteEmployee;
    }
}
