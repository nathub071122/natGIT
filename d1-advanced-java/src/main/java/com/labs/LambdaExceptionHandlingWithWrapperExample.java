package com.labs;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExceptionHandlingWithWrapperExample {
    public static void main(String[] args) {
        exceptionHandlingWithWrapper();
    }

    private static void exceptionHandlingWithWrapper() {
        // Enhance the below application to  EFFECTIVELY IMPLEMENT NULLPOINTEREXCETPION
        // / SCORECANNOTBENEGATIVEEXCEPTION(CHECKED)
        // / ALL OTHER EXCPETIONS

        List<Integer> scores = Arrays.asList(150,-50,100,null,140,0);
        List<Integer> scores2 = Arrays.asList(150,0,120,140);
        List<Integer> scores3 = Arrays.asList(150,0,120,140);

        scores.forEach(exceptionHandlingWithLambdaWrapper(score -> System.out.println(50 / score)));
    }

    static Consumer<Integer> exceptionHandlingWithLambdaWrapper(Consumer<Integer> consumer) {
        Consumer<Integer> sorceConsumer = i -> {
            try {
                if (i < 0 ) throw new ScoreCannotBeNegativeException("Score Cannot Be Negative!");
                consumer.accept(i);
            } catch (NullPointerException | ScoreCannotBeNegativeException exception) {
                if (exception instanceof NullPointerException) {
                    System.out.println(exception);
                    System.out.println("Score cannot be null!");
                } else if (exception instanceof ScoreCannotBeNegativeException) {
                    System.out.println(exception);
                    System.out.println("Score Cannot Be Negative!");
                }
            } catch (Throwable e) {
                System.out.println(e);
                System.out.println("All other Exceptions!");
            }
        };
        return sorceConsumer;
    }

}

class ScoreCannotBeNegativeException extends Exception {
    public ScoreCannotBeNegativeException(String message) {
        super(message);
    }
}
