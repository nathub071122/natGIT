package com.demo.exception_handling;

public class ATMWithdrawalExceptionEx {
    public static void main(String[] args) {
        System.out.println("do");
        int withdrawal = 1000;
        try {
            withdraw(withdrawal);
        } catch (ATMWithdrawalException e) {
            System.out.println(e.getMessage());
//            throw new RuntimeException(e);
        }
        System.out.println("done");
    }

    private static void withdraw(int withdrawal) throws ATMWithdrawalException {
        if(withdrawal < 500 || withdrawal >1000) {
//            try {
                throw new ATMWithdrawalException("The ATM can only dispense an amount between 500 and 1000");
//            } catch (ATMWithdrawalException e) {
//                throw new RuntimeException(e);
//                System.out.println(e.getMessage());
//            }
        }
        else
        {
            System.out.println("Here is your money.... enjoy spending or saving....");
        }
    }
}

class ATMWithdrawalException extends  Exception {
    public ATMWithdrawalException(String message) {
        super(message);
    }
}