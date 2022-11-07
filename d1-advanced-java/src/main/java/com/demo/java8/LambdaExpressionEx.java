package com.demo.java8;

import java.util.ArrayList;

public class LambdaExpressionEx {
    public static void main(String[] args) {
//        forEachDemo();
        snippet2();
    }

    private static void forEachDemo() {
        //        ArrayList is from 1.2
        ArrayList employeeNames = new ArrayList();
        employeeNames.add("Sam");
        employeeNames.add("Peter");


//  lambda expression
//        () -> {};   left side (parameters to a function) - > right side (body of a function)
//        (String employeeName) -> System.out.println(employeeName);
//        employeeName - > System.out.println(employeeName)
//        forEach is from 1.8
//        old ways is pass primitives, objects as method parameters
//        java 8 pass expressions // lambda expressions
//         java.util.function.Consumer consumerObject = employeeName -> System.out.println(employeeName);
        employeeNames.forEach(employeeName -> System.out.println(employeeName));
//        forEach new in Java8
        employeeNames.forEach(employeeName -> {
                    System.out.println(employeeName);
                }
        );

//        question? if forEach is a method (what can we pass as parm, int, Integer, Object)
//        what is the type here? Functional Interface
//       int age // type of age is int
//       ArrayList employeesList // type of employeeList is arrayList
 // FunctionalInterface object =        employeeName -> System.out.println(employeeName)
//  FunctionalInterface : an interface with exactly one abstract method
    }

    public static void snippet2() {
        ArrayList<String> city = new ArrayList<>();
        // Add elements to ArrayList
        city.add("Jurong East");
        city.add("Bukit Batok");

        System.out.println("ArrayList: " + city.toString().toUpperCase());

//        traditional loop
        System.out.println("oldest");
        for(int i = 0; i< city.size();i++) {
            String city2 =   (String) city.get(i);
            if(city2 != null) {
                System.out.println(city2);
            }
        }
        System.out.println("old");
//      enhanced for loop
        for (String c : city) {
            if (c != null) {
                System.out.println(c.toUpperCase());
            }
        }
        System.out.println("new");
// java 8 way
        city.forEach( cityVar -> {
            if (cityVar != null) System.out.print(cityVar.toUpperCase() + "\t");
            if (cityVar != null) System.out.println(cityVar.toLowerCase());
        });
    }
//    public void print(String employeeName) {
//        System.out.println(employeeName);
//    }
    Runnable runnable;
}
