package org.jp.streams.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class FpPerformance {
    public static void main(String[] args) {
        // given a list of string find string that have length of
        // specific number and upper case them

        List<String> courses = List.of("String", "Spring Boot", "API", "Micro services", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

      /*  courses.stream()
                .peek(System.out::println)
                .filter(course -> course.length() > 11)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .findFirst()
                .ifPresent(System.out::println);*/

        // parallel Stream
        // Suppose we want to add nums from 0 , 1000000000
       /* long time = System.currentTimeMillis();
        System.out.println(LongStream.range(0, 1000000000).parallel()
                .sum());
        System.out.println(System.currentTimeMillis()- time);*/

        // modify the list of string to upper case  in the same list

        ArrayList<String> mutableList = new ArrayList<>(courses);
        mutableList.replaceAll(String::toUpperCase);
        System.out.println(mutableList);

        // remove courses whose title is length is more than 7

        mutableList.removeIf(course -> course.length()> 11);
        System.out.println(mutableList);

    }
}
