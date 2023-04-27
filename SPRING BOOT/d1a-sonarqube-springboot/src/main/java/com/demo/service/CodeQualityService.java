package com.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CodeQualityService {

    private static final String MESSAGE_STRING  = "Object for Testing purpose";
    private static final String MESSAGE_STRING1  = "Code Quality and Coverage!";
    public String getMessage() {
        return MESSAGE_STRING1;
    }

    public Object getObject() {
        return MESSAGE_STRING;
    }
}
