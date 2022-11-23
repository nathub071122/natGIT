package com.demo.spring;
import com.demo.spring.config.AppConfig;
import com.demo.spring.service.DigitalPayment;
import com.demo.spring.service.DigitalPaymentImpl;
import com.demo.spring.service.PaymentGatewayService;
import com.demo.spring.service.PaymentGatewayServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class IOCApp {
    public static void main(String[] args) {
        System.out.println("Stand alone app!");
//      Accessing the digital payment created by spring
        System.out.println("Using the bank app!");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        DigitalPayment digitalPayment = new DigitalPaymentImpl();
        for(int ctr= 0; ctr<5; ctr++) {
            DigitalPayment digitalPayment = applicationContext.getBean("digitalPayment", DigitalPayment.class);
            digitalPayment.payDigitally();
        }
//        System.out.println("Using the payment gateway");
//        // Directly creating and accessing the payment gateway service
//        PaymentGatewayService paymentGatewayService = new PaymentGatewayServiceImpl();
// Accessing the digital payment service created by spring
//        PaymentGatewayService paymentGatewayService = applicationContext.getBean("paymentGatewayService", PaymentGatewayService.class);
//        paymentGatewayService.pay();
//        for (int i = 0; i < 10; i++) {
//            applicationContext.getBean("paymentGatewayService", PaymentGatewayService.class);
//            paymentGatewayService.pay();
//        }
    }
}