package com.labs;

public class MultipleExceptionsSingleCatchEx {
    public static void main(String[] args) {
        try {
            String test = null;
            System.out.println(test.length());
            String names[] = {"test me", "for exceptions..."};
            System.out.println(names[1]);
            int result = 0;
            int num1 = 0;
            int num2 = 0;
            result = num1 / num2;
            System.out.println("does not reach here due to Arithmetic Exc....");
        }

        catch(Throwable exception) {
//IP
            //  Write the logic to test the type of exception and accordingly print a message.
            //  If null pointer : print "Check object for null ....
            if(exception instanceof NullPointerException){
                System.out.println("Check object for null ....");
            }
            //  If arithmetic : print "Check numbers to be a non zero value
            else if(exception instanceof ArithmeticException){
                System.out.println("Check numbers to be a non zero value");
            }
            //  If AIOOBE : print "Check the index to be within the bounds.
            else if(exception instanceof ArrayIndexOutOfBoundsException) {
                System.out.println("Check the index to be within the bounds.");
            }
            // check for RuntimeException (appropriate message), Exception  (appropriate message) and Throwable  (appropriate message)
            // Try to solve with one or max two catch blocks.
            else if(exception instanceof RuntimeException) {
                System.out.println("Any RuntimeException.........");
            }
            else if(exception instanceof Exception){
                System.out.println("Exceptions!");
            }else{
                System.out.println("All other exceptions!");
            }

            System.out.println(exception.getMessage());
        }

    }

}
