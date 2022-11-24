package com.demo.controller;
import com.demo.model.EmployeeModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//@RestController
@Controller
@RequestMapping("/api/v0")
public class EmployeeController {
    @ResponseBody
    @GetMapping("/welcome")
    public String getWelcomeWithHTMLAsUI() {
        String htmlOutput = "<!DOCTYPE html>";
        htmlOutput += "<html>";
        htmlOutput += "<head><title>Welcome to the Web</title></head>";
        htmlOutput += "<body><h1>This demo is a from spring boot and REST API ....</h1>" +
                "<h1 style='color:orange;font-weight:bold'>Ensures developer productivity!</h1> <br/> " +
                " Enter text to search :  <input type = 'text' value=></input> <br/>" +
                " <input type='Submit' value='Search'></input>";
        htmlOutput += "</html>";
        return  htmlOutput;
    }

    //    JAVA OBJECT SERIALIZED INTO JSON
    @ResponseBody
    @GetMapping(value = "/employees", produces = {MediaType.APPLICATION_XML_VALUE})
    public EmployeeModel getEmployees(){
        EmployeeModel employeeModel = new EmployeeModel(1,"Ben",5000);
        return employeeModel;
    }
    //    IP : RETURN A LIST OF 3-5 EMPLOYEES
    @ResponseBody
    @GetMapping(value="/employees-list", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List getEmployeeList() {

        List <EmployeeModel> employeeModelList = new ArrayList<>();
        employeeModelList.add(new EmployeeModel(1,"Ben",5000));
        employeeModelList.add(new EmployeeModel(2,"Charles",6000));
        employeeModelList.add(new EmployeeModel(3,"Amber",7000));

        return employeeModelList;
    }
    //    IP : RETURN A MAP OF 3-5 EMPLOYEES (EMPLOYEEID : KEY, EMPLOYEE INSTANCE : VALUE
    @GetMapping("/employees-map")
    public Map getEmployeeMap() {

        Map<Integer,EmployeeModel> map=new HashMap();
        //Adding elements to map
        map.put(1,new EmployeeModel(1,"Ben",5000));
        map.put(2,new EmployeeModel(1,"Ben",5000));
        map.put(3,new EmployeeModel(1,"Ben",5000));

        return map;
    }


    //   EMPLOYEES OF DEPARTMENTS IT, FINANCE
    //   LIST OF TWO MAPS (EACH MAP WILL CONTAIN THREE EMPLOYEES OF THE DEPARTMENT)
    @GetMapping("/employees-list-map")
    public List<Map<Integer,EmployeeModel>> getDepartmentWiseEmployees() {

        Map<Integer,EmployeeModel> map=new HashMap();
        //Adding elements to map
        map.put(1,new EmployeeModel(1,"IT-Ben",5000));
        map.put(2,new EmployeeModel(2,"IT-Albert",5000));
        map.put(3,new EmployeeModel(3,"IT-Sin",5000));

        Map<Integer,EmployeeModel> map2=new HashMap();
        //Adding elements to map
        map2.put(4,new EmployeeModel(4,"Finance-Benneth",5000));
        map2.put(5,new EmployeeModel(5,"Finance-Ken",6000));
        map2.put(6,new EmployeeModel(6,"Finance-Ahmad",7000));

        List<Map<Integer,EmployeeModel>> listMap = new ArrayList<>();
        listMap.add(map);
        listMap.add(map2);

        return listMap;
    }
}
