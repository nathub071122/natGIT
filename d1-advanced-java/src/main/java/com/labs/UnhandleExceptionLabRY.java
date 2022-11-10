package com.labs;

public class UnhandleExceptionLabRY {

    public static void main (String s[]) {
        try {
            //NullPointerException
            String d = null;
            System.out.println(d.length());

//            ArithmeticException
            int result = 12 / 0;
            System.out.println(result);

//            ArrayIndexOutOfBoundsException
            int array[] = new int[0];
            System.out.println(array[0]);


        } catch (ArithmeticException | NullPointerException | ArrayIndexOutOfBoundsException anyException) {
//            System.out.println(anyException);
            if (anyException.toString().contains("java.lang.NullPointerException")) {
                System.out.println(anyException + " Exception trigger 1");
                System.out.println("Check the Object for null value");
            } else if (anyException.toString().contains("java.lang.ArithmeticException")) {
                System.out.println(anyException + " Exception trigger 2");
                System.out.println("Check the number for null value");
            } else if (anyException.toString().contains("java.lang.ArrayIndexOutOfBoundsException")) {
                System.out.println(anyException + " Exception trigger 3");
                System.out.println("Check the Index to be within bounds");
            } else {
                System.out.println(anyException + " Exception trigger 4");
                System.out.println("Check the Object for null value");
            }
        } catch (Throwable e) {
            if (e instanceof RuntimeException) {
                System.out.println("Runtime Exception");
                System.out.println(" Exception trigger 5");
            } else if (e instanceof Exception) {
                System.out.println("Exception");
                System.out.println(" Exception trigger 6");
            } else if (e instanceof Throwable) {
                System.out.println("Throwable");
                System.out.println(" Exception trigger 7");
            }

        }
    }
}
