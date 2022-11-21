package com.demo.nospring;
import com.demo.spring.service.DigitalPayment;
import com.demo.spring.service.DigitalPaymentImpl;
import com.demo.spring.service.PaymentGatewayService;
import com.demo.spring.service.PaymentGatewayServiceImpl;
//ACTIVITY 1
// The application support three types of payments.Debit, Credit or wallet.
// Design three different implementations for the types of payments.

// ACTIVITY 2 : CONFIGURE PaymentGatewayService and access it through Application Context.
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Stand alone app!");
//        Directly creating and accessing the digital payment
        System.out.println("Using the bank app!");
        DigitalPayment digitalPayment = new DigitalPaymentImpl();
        digitalPayment.payDigitally();
        System.out.println("Using the payment gateway");
        // Directly creating and accessing the payment gateway service
        PaymentGatewayService paymentGatewayService = new PaymentGatewayServiceImpl();
        paymentGatewayService.pay();
    }
}
