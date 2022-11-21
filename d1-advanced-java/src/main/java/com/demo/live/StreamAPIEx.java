package com.demo.live;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIEx {
    public static void main(String[] args) {
        streamsOnPrimitiveArray();
    }

    private static void streamsOnPrimitiveArray() {
        //        setting up the source
//        int [] numbers = null;
        int [] numbers = new int[500];
        for(int ctr = 0; ctr < 500; ctr++) {
            numbers[ctr] = ctr+1;
//            numbers[ctr] = 1;
        }
//        numbers[5]= 2;
//        numbers[6] = 2;
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
        System.out.println(Arrays.stream(numbers).min().getAsInt());
        System.out.println(Arrays.stream(numbers).max().getAsInt());
        System.out.println(Arrays.stream(numbers).count());
        System.out.println(intStream.average().getAsDouble());
        System.out.println(Arrays.stream(numbers).sum());
        System.out.println(Arrays.stream(numbers).sum());
    }

    private static void streamsOnWrapperCollection() {
        Integer [] numbers = new Integer[500];
        for(int ctr = 0; ctr < 500; ctr++) {
            numbers[ctr] = ctr+1;
//            numbers[ctr] = 1;
        }

//      INTERMEDIATE OPERATIONS
//        1. Intermediate operations return a new stream
//        2. The mapToInt() is a lazy operation
//        3. The traversal of pipeline begins on calling the terminal operation (min())
        List<Integer> integerList = Arrays.asList(numbers);
//        Accessing an instance method using method reference (Integer::intValue)
        Stream<Integer> integerStream =  integerList.parallelStream();
//         sequence of primitive int-valued elements
        IntStream intStream = integerStream.mapToInt(Integer::intValue);
        OptionalInt optionalInt =  intStream.min();
        System.out.println(optionalInt.getAsInt());
    }
}
