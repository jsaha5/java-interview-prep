package org.jp.streams.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamPractise01 {

    @Test
    public void problem1() {
        //Given a list of integers, filter out the even numbers and print them.

        List<Integer> numbers = Arrays.asList(1, 78, 8, 10, 100, 45, 78);

        numbers.stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);

    }

    @Test
    public void problem2() {
        //Use streams to find the longest string in a list of strings..

        List<String> courses = List.of("String", "Spring Boot", "API", "Micro services",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes");


        courses.stream()
                .max(Comparator.comparing(String::length))
                .ifPresent(System.out::println);

    }

    @Test
    public void problem3() {
        //Convert all strings in a list to uppercase using streams.

        List<String> courses = List.of("String", "Spring Boot", "API", "Micro services",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes");


        courses.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }

    @Test
    public void problem4() {
        //Given a list of integers, find the sum of the squares of all odd numbers.

        List<Integer> numbers = Arrays.asList(1, 78, 8, 10, 100, 45, 78);

        System.out.println(
                numbers.stream()
                        .filter(num -> num % 2 != 0)
                        .peek(System.out::println)
                        .mapToInt(n -> n * n)
                        .sum()
        );

    }

    @Test
    public void problem5() {
        //Given a list of strings, group them by their length using streams.

        List<String> courses = List.of(
                "String", "Spring Boot",
                "API", "Micro services",
                "AWS", "PCF", "Azure",
                "Docker", "Kubernetes");

        Map<Integer, List<String>> collect = courses.stream().collect(Collectors.groupingBy(String::length));
        collect.forEach((k, v) -> {
            System.out.println(k);
            System.out.println("-------------");
            v.forEach(System.out::println);
        });


    }

    @Test
    public void problem6() {
        //Given a list of strings and a character, count the total occurrences of that character in all strings.

        List<String> courses = List.of(
                "String", "Spring Boot",
                "API", "Micro services",
                "AWS", "PCF", "Azure",
                "Docker", "Kubernetes");
        char input = 'c';
//            var name = "Aditya";
//        Map<char[], List<char[]>> collect = List.of(name.toCharArray()).stream().collect(Collectors.groupingBy(a -> a));
//        System.out.println(collect.toString());
//        long count = courses.stream()
//                .flatMapToInt(String::chars)
//                .filter(c -> c == input)
//                .count();
//        System.out.println(count);

        courses.forEach(
                s -> {
                    System.out.println(s);
                    System.out.println(s.chars().filter(c -> c == input).count());
                }
        );


    }

    @Test
    public void problem7() {
//        Concatenate List of Strings with a Delimiter
        List<String> courses = List.of(
                "String", "Spring Boot",
                "API", "Micro services",
                "AWS", "PCF", "Azure",
                "Docker", "Kubernetes");

        String collect = courses.stream().collect(Collectors.joining(","));
//        String collect = String.join(",", courses);
        System.out.println(collect);
    }

    @Test
    public void problem8() {
        //Find First Non-Empty String
        List<String> strings = Arrays.asList("", "", "firstNonEmpty", "anotherString", "", "lastString");

        strings.stream().filter(Predicate.not(String::isBlank)).findFirst().ifPresent(System.out::println);
    }

    @Test
    public void problem9() {
//        Convert List of Integers to List of Strings
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        List<String> list = integers.stream().map(Object::toString).toList();
        System.out.println(list);

    }

    @Test
    public void problem10() {
//Given a list of doubles, calculate the average value using streams.
        List<Double> doubles = Arrays.asList(3.14, 2.71, 1.41, 1.73, 0.577, 1.618);
        doubles.stream().mapToDouble(Double::doubleValue).average().ifPresent(System.out::println);

    }

}
