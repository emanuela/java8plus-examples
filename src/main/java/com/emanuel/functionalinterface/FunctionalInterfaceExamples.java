package com.emanuel.functionalinterface;

import java.util.function.Function;

public class FunctionalInterfaceExamples {

    public static void main(String[] args) {
        Function<String, String> function1 = s -> s.toUpperCase();
        Function<String, String> function2 = s -> s + " World";

        System.out.println("Output of function1 : " + function1.apply("Hello"));

        // andThen() example
        System.out.println("andThen Output : "  + function1.andThen(function2).apply("Hello"));

        // compose() example - 'Hello' is appended to ' World' first (function2) and then 'Hello World' is applied to
        // function1 to yield 'HELLO WORLD'.
        System.out.println("Output - Compose() : " + function1.compose(function2).apply("Hello"));

        Function<String, String> functionStringIdentity = Function.identity();
        System.out.println(functionStringIdentity.apply("Java8"));

        Function<Boolean, Boolean> functionBooleanIdenty = Function.identity();
        System.out.println(functionBooleanIdenty.apply(true));

        Function<Integer, Integer> functionIntegerIdentity = Function.identity();
        System.out.println(functionIntegerIdentity.apply(100));
    }
}
