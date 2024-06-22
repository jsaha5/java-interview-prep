package org.jp.streams.example;

import java.util.List;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // print even numbers
        BiConsumer<Integer, Integer> printEvenNumbers = (i, j) ->
                IntStream.range(i, j)
                        .filter(num -> num % 2 == 0)
                        .forEach(System.out::println);
        //    printEvenNumbers.accept(1, 100);

        // print odd numbs
        BiConsumer<Integer, Integer> printOddNumbers = (i, j) ->
                IntStream.range(i, j)
                        .filter(num -> num % 2 != 0)
                        .forEach(System.out::println);
        //  printOddNumbers.accept(1,5);

        Stream<String> courses = Stream.of("Spring", "Spring Boot", "API", "MICROSERVICE", "AWS", "PCF", "AZURE", "DOCKER", "KUBERNETES");
        // print All Courses Containing String
        Runnable printAllCoursesContainingString = () ->
                courses
                        .filter(cources -> cources.contains("Spring"))
                        .forEach(System.out::println);
        // printAllCoursesContainingString.run();

        // print Courses Whose Name Has4Letters
        Runnable printCoursesWhoseNameHas4Letters = () ->
                courses
                        .filter(course -> course.length() >= 4)
                        .forEach(System.out::println);
        // printCoursesWhoseNameHas4Letters.run();

        BiConsumer<IntStream, IntFunction<Integer>> intOperations = (intStream, mapper) -> intStream.map(mapper::apply).forEach(System.out::println);

        // print square of all the nums

        //   intOperations.accept(IntStream.range(1, 10), (num) -> num * num);

        // print all nums and multiply by 10

        // intOperations.accept(IntStream.range(1, 10), (num) -> num * 10);

        // print the number of charecters in each course
       // courses.mapToInt(String::length).forEach(System.out::println);

        // print cube of odd number

        IntStream.range(1, 9)
                .filter(num -> num % 2 != 0)
                .map(num -> num * num * num)
                .forEach(System.out::println);

    }


}

