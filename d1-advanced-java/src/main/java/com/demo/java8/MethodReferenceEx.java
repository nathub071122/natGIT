package com.demo.java8;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceEx {
    public static void main(String[] args) {
//        rawTypes();
genericTypes();
    }

    private static void rawTypes() {
        //    raw type pre generics 1.5 (generics were revolutionary)
        List colorsList = new ArrayList();
        colorsList.add("voilet");
        colorsList.add("idigo");
        colorsList.add("blue");
        colorsList.add("yellow");

//        pre java 5 traditional way
        for(int ctr=0; ctr <colorsList.size();ctr++) {
            System.out.print(colorsList.get(ctr) + "\t");
        }
        System.out.println();
        // java 5 enhanced for loop, but using raw types pre generics
        for(Object color : colorsList) {
//          downcasting / Object > String
            String colorString = (String)color;
            System.out.print(colorString + "\t");
        }
        System.out.println();
//        java8 forEach
        colorsList.forEach((color)-> {
            System.out.print(color + "\t");
        });
        System.out.println();

        colorsList.forEach(color-> System.out.print(color + "\t"));
        System.out.println();

//      :: is the method reference operator, concise syntax
        System.out.println("Concise code with method reference.....");
        colorsList.forEach(System.out::println);
//      Using method reference
    }

    private static void genericTypes() {
        //    raw type pre generics 1.5 (generics were revolutionary)
        // pre 1.7
//        List<String> colorsList = new ArrayList<String>();
//        post 1.7
        List<String> colorsList = new ArrayList<>();
        colorsList.add("voilet");
        colorsList.add("idigo");
        colorsList.add("blue");
        colorsList.add("yellow");

//        pre java 5 traditional way
        for(int ctr=0; ctr <colorsList.size();ctr++) {
            System.out.print(colorsList.get(ctr) + "\t");
        }
        System.out.println();
        // java 5 enhanced for loop, with generics
        for(String color : colorsList) {
            System.out.print(color + "\t");
        }
        System.out.println();
//        java8 forEach
        colorsList.forEach((color)-> {
            System.out.print(color + "\t");
        });
        System.out.println();

        colorsList.forEach(color-> System.out.print(color + "\t"));
        System.out.println();

//      :: is the method reference operator, concise syntax
        System.out.println("Concise code with method reference.....");
        colorsList.forEach(System.out::println);
//      Using method reference
    }
}
