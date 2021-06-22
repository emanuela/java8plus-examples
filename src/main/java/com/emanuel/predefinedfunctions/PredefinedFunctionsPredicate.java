package com.emanuel.predefinedfunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredefinedFunctionsPredicate {
    public static void main(String[] args) {
        Predicate<String> nonEmptyStringPredicate = (String str) -> ! str.isEmpty();
        PredefinedFunctionsPredicate demo = new PredefinedFunctionsPredicate();
        List<String> list = new ArrayList<>(Arrays.asList("Apple", "Mango", "Orange"));
        List<String> results = demo.filter(list, nonEmptyStringPredicate);
        System.out.println(results);
    }

    /**
     * filter using a predicate.
     * @param list
     * @param predicate
     * @param <T>
     * @return
     */
    public <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                results.add(t);
            }
        }
        return results;
    }
}
