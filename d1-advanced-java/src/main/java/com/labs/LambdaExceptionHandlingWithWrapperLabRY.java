package com.labs;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExceptionHandlingWithWrapperLabRY {
    public static void main(String[] args) {
        exceptionHandlingInLambdaWithwrapper();
    }
    private static void exceptionHandlingInLambdaWithwrapper() {
        List<Value> scores = Arrays.asList(() -> 100,null,() -> -200,() -> 100, () -> 1100, () -> 0);
        scores.forEach(wrapperForLamdaWithArithmeticException(score -> System.out.println(1000 / score.getValue())));
    }

    //    The wrapper handles exception in an elegant manner with lambda
//    inputs : score, Consumer<Integer> to Consume the Integer
//    return : a consumer that is capable of handling ArithmeticException
    static Consumer<Value> wrapperForLamdaWithArithmeticException(Consumer<Value> scoreConsumer) {

        Consumer<Value> consumer = (scores) -> {
            try {
                if (scores.getValue() < 0 )
                    throw new ScoreCannotBeNegativeExceptions("Negative integer!");
                scoreConsumer.accept(scores);


            } catch (NullPointerException | ArithmeticException | ScoreCannotBeNegativeExceptions exception) {
                if (exception instanceof ArithmeticException) {
                    System.out.println("ArithmeticException");
                } else if (exception instanceof NullPointerException) {
                    System.out.println("NullPointerException");
                } else if (exception.toString().contains("ScoreCannotBeNegativeExceptions")) {
                    System.out.println("ScoreCannotBeNegativeException");
                } else {
                    System.out.println("Check the Object for null value");
                }
            }
        };
        return consumer;
    }

}


@FunctionalInterface
interface Value {

    int get();

    default int getValue() {
        return get();
    }
}

//Custom Exception
class ScoreCannotBeNegativeExceptions extends Exception {

        public ScoreCannotBeNegativeExceptions(String message){
            super(message);
        }

    }
