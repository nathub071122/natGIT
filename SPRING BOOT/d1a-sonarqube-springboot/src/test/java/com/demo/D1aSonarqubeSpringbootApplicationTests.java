package com.demo;

import com.demo.controller.CodeQualityController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class D1aSonarqubeSpringbootApplicationTests {
    @Autowired
    private CodeQualityController codeQualityController;
    @Test
    void contextLoads() {
        Assertions.assertNotNull(codeQualityController);
    }
    @Test
    void testGetInfo() {
        String info = codeQualityController.getInfo();
        Assertions.assertNotNull(info);
    }
}
