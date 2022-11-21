package com.demo.spring.config;
import com.demo.spring.service.DigitalPayment;
import com.demo.spring.service.DigitalPaymentImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppConfig {
    @Bean
    DigitalPayment digitalPayment(){
        DigitalPayment digitalPayment = new DigitalPaymentImpl();
        return digitalPayment;
    }
}
