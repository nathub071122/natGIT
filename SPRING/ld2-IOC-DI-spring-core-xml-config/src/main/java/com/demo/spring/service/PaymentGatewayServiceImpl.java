package com.demo.spring.service;
public class PaymentGatewayServiceImpl implements  PaymentGatewayService {
    DigitalPayment digitalPayment;
    @Override
    public void pay(){
//        already available in spring, why are we instantiating this?
//        we can apply Dependency Injection here.
//        digitalPayment = new DigitalPaymentImpl();
        System.out.println("InstanceS: " + digitalPayment);
        digitalPayment.payDigitally();
    }

    public PaymentGatewayServiceImpl() {
        System.out.println(" public PaymentGatewayServiceImpl() DEFAULT CONS!");
    }
    public PaymentGatewayServiceImpl(DigitalPayment digitalPayment) {
    // CONSTRUCTOR BASED DEPENDENCY INJECTION
        System.out.println("CONSTRUCTOR BASED DEPENDENCY INJECTION public PaymentGatewayServiceImpl(DigitalPayment digitalPayment) ");
        this.digitalPayment = digitalPayment;
    }
// SETTER BASED DEPENDENCY INJECTION. TRY IT WITH XML.
    public void setDigitalPayment(DigitalPayment digitalPayment) {
        this.digitalPayment = digitalPayment;
    }
}
