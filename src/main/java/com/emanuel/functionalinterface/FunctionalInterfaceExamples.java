package com.emanuel.functionalinterface;

import java.util.function.Function;

public class FunctionalInterfaceExamples {

    public static void main(String[] args) {

        usdToInr(10);
        squareOfNumber(5);

        System.out.format("%n");

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

        Function<Boolean, Boolean> functionBooleanIdentity = Function.identity();
        System.out.println(functionBooleanIdentity.apply(true));

        Function<Integer, Integer> functionIntegerIdentity = Function.identity();
        System.out.println(functionIntegerIdentity.apply(100));
    }

    static void usdToInr(Integer inUsd) {
        Double inrRate = 71.0;
        Function<Integer, Double> functionApply = usd -> usd * inrRate;

        Double inr = functionApply.apply(inUsd);

        System.out.format("usdToInr: from input usd %d, to output inr %.2f%n", inUsd, inr);
    }

    static void squareOfNumber(Integer inNum) {
        Function<Integer, Integer> functionSquare = n1 -> n1 * n1;

        Integer theSquare = functionSquare.apply(inNum);

        System.out.format("squareOfNumber: input number: %d, square of number = %d%n", inNum, theSquare);
    }
}
