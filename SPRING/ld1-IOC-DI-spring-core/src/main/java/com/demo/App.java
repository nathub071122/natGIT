package com.demo;
import com.demo.nospring.service.DigitalPayment;
import com.demo.nospring.service.DigitalPaymentImpl;
import com.demo.nospring.service.PaymentGatewayService;
import com.demo.nospring.service.PaymentGatewayServiceImpl;
//ACTIVITY
// The application support three types of payments.Debit, Credit or wallet.
// Design three different implementations for the types of payments.
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Stand alone app!");
//        Directly accessing the digital payment
        System.out.println("Using the bank app!");
        DigitalPayment digitalPayment = new DigitalPaymentImpl();
        digitalPayment.payDigitally();
        System.out.println("Using the payment gateway");
        PaymentGatewayService paymentGatewayService = new PaymentGatewayServiceImpl();
        paymentGatewayService.pay();
    }
}
