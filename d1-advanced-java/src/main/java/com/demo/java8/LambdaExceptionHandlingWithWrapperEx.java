package com.demo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExceptionHandlingWithWrapperEx {
    public static void main(String[] args) {
//      exceptionHandlingInLambda();
        exceptionHandlingInLambdaWithwrapper();
    }


    private static void exceptionHandlingInLambda() {
        List<Integer> scores = Arrays.asList(150,180,120,140);
        List<Integer> scores2 = Arrays.asList(150,0,120,140);
        // divide 500 by these scores...
//        scores.forEach(score -> System.out.println(500/score));
//        System.out.println("generate exception....");

        scores = Arrays.asList(50,180,0,140);
//        conciseness of the lambdo had gone for a toss.....
        scores.forEach(score -> {
          try {
              System.out.println(500 / score);
          }
          catch (ArithmeticException arithmeticException) {
              System.out.println("Check for zero values : " + arithmeticException.getMessage());
          }
        });
        System.out.println("Reptitive code.....");
        Consumer<Integer> scoreConsumer = score -> {
            try {
                System.out.println(500 / score);
            }
            catch (ArithmeticException arithmeticException) {
                System.out.println("Check for zero values : " + arithmeticException.getMessage());
            }
        };
        scores2.forEach(scoreConsumer);
    }

    private static void exceptionHandlingInLambdaWithwrapper() {
        List<Integer> scores = Arrays.asList(150,180,120,140);
        List<Integer> scores2 = Arrays.asList(150,0,120,140);
        List<Integer> scores3 = Arrays.asList(150,0,120,140);
//        conciseness of the lambdo had gone for a toss.....
        Consumer<Integer> scoreConsumer = score -> System.out.println(500 / score);
        scores.forEach(wrapperForLamdaWithArithmeticException(scoreConsumer));
        System.out.println("Compact code.....");
        scores2.forEach(wrapperForLamdaWithArithmeticException(scoreConsumer));
        System.out.println("Still Compact code.....");
        scores3.forEach(wrapperForLamdaWithArithmeticException(score -> System.out.println(1000 / score)));
    }

//    The wrapper handles exception in an elegant manner with lambda
//    inputs : score, Consumer<Integer> to Consume the Integer
//    return : a consumer that is capable of handling ArithmeticException
    static Consumer<Integer> wrapperForLamdaWithArithmeticException(Consumer<Integer> scoreConsumer) {
        //wrapping the consumer for excpetion handling capabilities....
        Consumer<Integer> scoreConsumerWithArithmeticExceptionHandlingCapabilites = (score) -> {
            try {
                scoreConsumer.accept(score);
            } catch (ArithmeticException arithmeticException) {
                System.out.println("Check for zero values : " + arithmeticException.getMessage());
            }
        };
        return scoreConsumerWithArithmeticExceptionHandlingCapabilites;
    }


//    var parameterFunctionObject = function() {
//        console.log("functional programming........")
//    };
//    function consumerWrapper(consumerObject) {
//// invoking the function (consumerObject())
//        console.log(consumerObject())
//    };
    // passing a function as a variable/ideitifer (consumerObject)
//    consumerWrapper(parameterFunctionObject);
//
//    passing a function as a parameter to another function
//    consumerWrapper(function() {
//        console.log("functional programming method 2........")
//    });
}