package com.demo.java8;

import java.util.Arrays;

public class MultipleDefaultMehtodsFromTwoInterfacesEx {
    public static void main(String[] args) {
        Test test = new Test();
        String results[] = test.method();
        Arrays.asList(results).forEach(item -> System.out.println(item));
    }
}
 interface interface1 {
     default String[] method() {
         return new String[] {"interface1 method"};
     }
 }
interface interface2 {
    default String[] method() {
        return new String[] {"interface2 method"};
    }
}

class Test implements  interface1,interface2{
    @Override
    public String[] method() {
//        return interface1.super.method();
//        return interface2.super.method();
        String [] results = {interface1.super.method()[0], interface2.super.method()[0]};
//        return "the latest override";
        return  results;
    }
}
