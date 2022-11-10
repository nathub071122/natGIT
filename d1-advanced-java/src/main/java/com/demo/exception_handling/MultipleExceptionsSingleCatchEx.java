package com.demo.exception_handling;

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

        catch(NullPointerException | ArithmeticException | ArrayIndexOutOfBoundsException  exception) {
//IP
            //  Write the logic to test the type of exception and accordingly print a message.
//  If arithmetic : print "Check numbers to be a non zero value
//  If null pointer : print "Check object for null ....
//            If AIOOBE : print "Check the index to be within the bounds.
            System.out.println("Any RuntimeException.........");
            System.out.println(exception);
            System.out.println(exception.getMessage());
        }
//        catch(RuntimeException exception) {
//            System.out.println("specific message  to ArrayIndex......");
//            System.out.println(exception.getMessage());
//        }
//        catch (RuntimeException exception) {
//            System.out.println("All other exceptions!");
//            System.out.println(exception);
//        }
//        catch (Exception exception) {
//            System.out.println("All other exceptions!");
//            System.out.println(exception);
//        }
//        catch (Throwable exception) {
//            System.out.println("All other exceptions!");
//            System.out.println(exception);
//        }
//        anything that is not throwable cannot be thrown and caught....
//        catch (Object exception) {
//            System.out.println("All other exceptions!");
//            System.out.println(exception);
//        }
    }
}
