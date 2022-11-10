package com.demo.java8;

import java.util.Arrays;
import java.util.List;

public class LambdaExceptionHandlingEx {
    public static void main(String[] args) {
        List<Integer> scores = Arrays.asList(150,180,120,140);
        // divide 500 by these scores...
        scores.forEach(score -> System.out.println(500/score));
        System.out.println("generate exception....");
        scores = Arrays.asList(150,180,0,140);

//        conciseness of the lambdo had gone for a toss.....
        scores.forEach(score -> {
          try {
              System.out.println(500 / score);
          }
          catch (ArithmeticException arithmeticException) {
              System.out.println("Check for zero values : " + arithmeticException.getMessage());
          }
        });
    }
}
