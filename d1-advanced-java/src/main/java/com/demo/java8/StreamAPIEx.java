package com.demo.java8;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamAPIEx {
    public static void main(String[] args) {
//        setting up the source
//        int [] numbers = null;
        int [] numbers = new int[500];
        for(int ctr = 0; ctr < 500; ctr++) {
//            numbers[ctr] = ctr+1;
            numbers[ctr] = 1;
        }
        numbers[5]= 2;
        numbers[6] = 2;
        for(int ctr = 0; ctr < 500; ctr++) {
            System.out.print(numbers[ctr] + " " );
        }

//        STREAM : A SEQUENCE OF ELEMENTS SUPPORTING SEQUENTIAL AND PARALLEL OPERATIONS
        //1. Establish a stream from an array as the source

//        if(numbers != null) {
            IntStream intStream = Arrays.stream(numbers);
//      TERMINAL OPERATIONS
//      Min is a terminal operation.
//      Traverses and produces a result.
//      The stream is considered CONSUMED
//      Cannot be used again.
//      The operation did not modify the source
//      Return the source to get a new strem.
            OptionalInt optionalInt = intStream.max();
            if(optionalInt.isPresent()) {
                int min = optionalInt.getAsInt();
                System.out.println("************");
                System.out.println(min);
                System.out.println(optionalInt);
            }
            optionalInt.orElse(0);
//        }
//        else
//        {
//            System.out.println("No values.....");
//        }

        System.out.println("****************");
        intStream = Arrays.stream(numbers);
        System.out.println(Arrays.stream(numbers).min());
        System.out.println(Arrays.stream(numbers).max());
        System.out.println(Arrays.stream(numbers).count());
        System.out.println(intStream.average());
        System.out.println(Arrays.stream(numbers).sum());
    }
}
