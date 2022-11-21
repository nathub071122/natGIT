package com.demo.nospring.service;
public class PaymentGatewayServiceImpl implements  PaymentGatewayService {
    DigitalPayment digitalPayment;
    @Override
    public void pay(){
        digitalPayment = new DigitalPaymentImpl();
        digitalPayment.payDigitally();
    }
}
