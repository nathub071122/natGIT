package com.demo.java8;

public class FunctionalInterfaceCreateEx {
    public static void main(String[] args) {
//        assigning an expression to an object
        Adder adder = (int num1, int num2) -> {
            System.out.println(num1 + num2);
        };
//        invoking the expression
        adder.add(5,10);

        Greeting greetingVar = (String message) -> {
            System.out.println("Welcme to " + message + " training!");
        };
        greetingVar.greet(" Adv Java");
    }
}
// add functionality
//Multiple non-overriding abstract methods found in interface com.demo.java8.Adder
@FunctionalInterface
interface Adder {
    public void add(int num1, int num2);
//    public void subtract(int num1, int num2);
}

//IP : Use the functional interface and display a string message.
@FunctionalInterface
interface Greeting {
    public void greet(String message);
}


