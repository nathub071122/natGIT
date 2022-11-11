package com.labs;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class StringTestRY {

    public static void main(String... a) {

        StringTestRY.linesExample();
        System.out.println("=================================================");
        StringTestRY.isBlankExample();
        System.out.println("=================================================");
        StringTestRY.repeatExample();
        System.out.println("=================================================");
        StringTestRY.stripExample();
        System.out.println("=================================================");
        StringTestRY.stripLeadingExample();
        System.out.println("=================================================");
        StringTestRY.stripTrailingExample();
        System.out.println("=================================================");
    }

    public static void linesExample() {

        String str = " A \n B \n C \n D";
        Stream<String> lines = str.lines();
        lines.forEach(System.out::println);
    }


    public static void isBlankExample() {

        String input = "";
        Predicate<String> p = (s) -> s.isBlank();

        if (p.test(input))
            System.out.println("The String is blank");

    }


    public static void repeatExample() {

        String str = "Abc";

        System.out.println(str.repeat(3));
    }


    public static void stripExample() {

        String input = "   hello   ";
        System.out.println("Input string length : " + input.length());
        String stripStr = input.strip();
        System.out.println("Stripped string length : " + stripStr.length());

    }


    public static void stripLeadingExample() {

        String input = "   hello   ";
        System.out.println("Input string length : " + input.length());
        String stripStr = input.stripLeading();
        System.out.println("Stripped string length : " + stripStr.length());
        System.out.println("Input String :" + input);
        System.out.println("Output String :" + stripStr);
    }

    public static void stripTrailingExample() {

        String input = "   hello   ";
        System.out.println("Input string length : " + input.length());
        String stripStr = input.stripTrailing();
        System.out.println("Stripped string length : " + stripStr.length());
        System.out.println("Input String :" + input);
        System.out.println("Output String :" + stripStr);
    }
}