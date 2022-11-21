package com.demo.nospring.service;
public class DigitalPaymentImpl implements  DigitalPayment{
    @Override
    public void payDigitally(){
        System.out.println("Paid Digitally using credit, debit or wallet!");
    }
}
