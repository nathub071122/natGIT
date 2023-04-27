package com.demo.controller;

import com.demo.service.CodeQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class CodeQualityController {
    @Autowired
    private CodeQualityService codeQualityService;

    public String getInfo() {
        return codeQualityService.getMessage();
    }

    public Object getObject() {
        return codeQualityService.getObject();
    }
}
