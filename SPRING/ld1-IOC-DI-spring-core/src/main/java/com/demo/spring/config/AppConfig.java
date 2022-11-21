package com.demo.spring.config;
import com.demo.spring.service.DigitalPayment;
import com.demo.spring.service.DigitalPaymentImpl;
import com.demo.spring.service.PaymentGatewayService;
import com.demo.spring.service.PaymentGatewayServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
@Configuration
public class AppConfig {
    @Bean
    @Scope(value= BeanDefinition.SCOPE_PROTOTYPE)
//    @Scope("prototype")
    DigitalPayment digitalPayment(){

        DigitalPayment digitalPayment = new DigitalPaymentImpl();
        System.out.println("InstanceC : " + digitalPayment);
        return digitalPayment;

    }
    @Bean
    PaymentGatewayService paymentGatewayService(){
       PaymentGatewayService paymentGatewayService = new PaymentGatewayServiceImpl();
        return paymentGatewayService;
    }
}
