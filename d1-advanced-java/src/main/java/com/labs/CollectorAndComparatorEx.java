package com.labs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectorAndComparatorEx {
    public static void main(String[] args) {
        String [] countries = new String[] {"Singapore", "India" ,"Japan", "Russia", "Netherlands", "Ukraine","France", "Italy"};
        // Process the stream to find out
//        1. Count of countries with the minimum characters
//        2. Display the countries in the upper case that has minimum characters.

        final Comparator<String> comparator = Comparator.comparing(String::length);
        int minSize = Arrays.stream(countries).min(comparator).get().length();
        long count = Arrays.stream(countries)
                .filter(i -> i.length()==minSize)
                .count();
        System.out.println("countries with the minimum:"+count);

        List<String> output = Arrays.stream(countries)
                .filter(i -> i.length()==minSize)
                .map(i -> i.toUpperCase())
                .collect(Collectors.toList());
        output.forEach(System.out::println);
    }
}