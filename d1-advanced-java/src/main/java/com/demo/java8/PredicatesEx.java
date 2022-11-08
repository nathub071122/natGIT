package com.demo.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicatesEx {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of( "Singapore", "India","Japan", "Russia", "Netherlands", "Ukraine","France", "Italy");
        Predicate<String> predicate = Predicate.isEqual("Singapore");
        Predicate<String> predicate1 = Predicate.isEqual("India");

        List<String> selectedCountries = new ArrayList<>();
//        stream.peek(System.out::println)
         stream       .filter(predicate1.or(predicate))
                .forEach(selectedCountries::add);
        System.out.println(selectedCountries);
    }

}
