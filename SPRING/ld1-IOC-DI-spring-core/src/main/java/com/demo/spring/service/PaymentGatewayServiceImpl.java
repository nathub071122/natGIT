package com.demo.spring.service;
public class PaymentGatewayServiceImpl implements  PaymentGatewayService {
    DigitalPayment digitalPayment;
    @Override
    public void pay(){
//        already available in spring, why are we instantiating this?
//        we can apply Dependency Injection here.
        digitalPayment = new DigitalPaymentImpl();
        digitalPayment.payDigitally();
    }
}
