package com.labs;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExceptionHandlingWithWrapperEx {
    public static void main(String[] args) {
        exceptionHandlingInLambdaWithwrapperLab();
    }


    private static void exceptionHandlingInLambdaWithwrapperLab() {
        //ENHANCEMENT LAB : EFFECTIVELY IMPLEMENT NULLPOINTEREXCETPION  / SCORECANNOTBENEGATIVEEXCEPTION(CHECKED) / ALL OTHER EXCPETIONS
        List<Integer> scores = Arrays.asList(150, -50, null, 140);
        List<Integer> scores2 = Arrays.asList(150, 0, -120, 140);
        List<Integer> scores3 = Arrays.asList(150, 0, 120, 0);
        System.out.println("test");
        Consumer<Integer> exceptionConsumer = score -> {
            if (score == null) {
                throw new NullPointerException("null value");
            } else if (score < 0) {
                throw new ScoreCannotBeNegativeException("negative values not allowed");
            }
        };
        scores.forEach(handleExceptionUsingWrapper(exceptionConsumer));
        scores2.forEach(handleExceptionUsingWrapper(exceptionConsumer));
        scores3.forEach(handleExceptionUsingWrapper(exceptionConsumer));
        System.out.println("Ended");
    }


    static Consumer<Integer> handleExceptionUsingWrapper(Consumer<Integer> function) {
        System.out.println("Entered");
        Consumer<Integer> returnedResult = (value) -> {
            try {
                function.accept(value);
            } catch (NullPointerException | ScoreCannotBeNegativeException e) {
                System.out.println(e.getMessage());
            } catch (Exception ex) {
                System.out.println("All other exceptions");
            }

        };
        return returnedResult;
    }

    static class ScoreCannotBeNegativeException extends RuntimeException {
        public ScoreCannotBeNegativeException(String message) {
            super(message);
        }
    }
}
