package com.emanuel.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionalInterfaceWithStreams {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList();

        studentList.add(new Student(1, 45, "Alice"));
        studentList.add(new Student(2, 65, "Bob"));
        studentList.add(new Student(3, 80, "Clair"));
        studentList.add(new Student(4, 20, "Dom"));

        List<Student> studentList2 = new ArrayList();
        studentList2.add(new Student(1, 25, "Adam"));
        studentList2.add(new Student(2, 35, "Bob"));
        studentList2.add(new Student(3, 45, "Danny"));
        studentList2.add(new Student(4, 55, "Will"));

        functionApplyExample(studentList);
        functionAndThenExample(studentList2);
        functionComposeExample(studentList2);
    }

    static void functionApplyExample(List<Student> studentList) {
        System.out.format("functionApplyExample: %n");
        Function<Integer, Integer> markIncrement = mark -> mark + 20;

        studentList.stream()
                .map(student -> markIncrement.apply(student.getMark()))
                .forEach(System.out::println);
    }

    static void functionAndThenExample(List<Student> students) {
        System.out.format("functionAndThenExample: %n");
        Function<Student, Integer> getMark = student -> student.getMark();
        Function<Integer, Integer> markIncrement = mark -> mark + 20;

        students.stream()
                .map(student -> getMark.andThen(markIncrement).apply(student))
                .forEach(System.out::println);
    }

    static void functionComposeExample(List<Student> students) {
        System.out.format("functionComposeExample: %n");
        Function<Student, String> getName = student -> student.getName();
        Function<String, String> addCountry = name -> name + " US";

        students.stream()
                .map(student -> addCountry.compose(getName).apply(student))
                .forEach(System.out::println);
    }
}
