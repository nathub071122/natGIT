package com.demo.exception_handling;

public class TryFinallyEx {
    public static void main(String[] args) {
//        System.out.println("Unhandled Exception");
        int result = 0;
        int num1 = 0, num2 = 20;
        try {
            result = num2 / num1;
            try{

            }
            catch(Exception exception)
            {
                try {

                }
                finally {
                    try{

                    }
                    catch(Exception exception1)
                    {
                        try {

                        }
                        finally {

                        }
                    }
                }
            }
        }
//        System.out.println("Welcome");
        catch (Exception exception) {
            System.out.println("Check the values. Value cannot be zero!");
        }
        finally {
            System.out.println("clean up operations!");
        }
        System.out.println(result);
        System.out.println("Proceeding with the normal flow");
    }
}
