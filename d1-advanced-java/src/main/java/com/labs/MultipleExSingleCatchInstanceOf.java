package com.labs;

public class MultipleExSingleCatchInstanceOf {

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
            if(exception instanceof NullPointerException){
                System.out.println("Check object for null ....");
            }else if(exception instanceof ArithmeticException){
                System.out.println("Check numbers to be a non zero value");
            }else if(exception instanceof ArrayIndexOutOfBoundsException){
                System.out.println("Check the index to be within the bounds.");
            }
        }catch(Throwable e){
          if(e instanceof RuntimeException){
              System.out.println("Runtime Exception");
          }else if (e instanceof Exception){
              System.out.println("Exception");
          }else if(e instanceof Throwable){
//              e.printStackTrace();
              System.out.println("Throwable");
          }
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
