package org.jp.streams.example;

import org.jp.models.Course;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamGrouping {

    private static final Supplier<List<Course>> courseSupplier = () -> List.of(
            new Course("Spring", "Framework", 98, 20000),
            new Course("Spring Boot", "Framework", 95, 18000),
            new Course("API", "Microservices", 97, 22000),
            new Course("Microservices", "Microservices", 96, 25000),
            new Course("FullStack", "FullStack", 91, 14000),
            new Course("AWS", "Cloud", 92, 21000),
            new Course("Azure", "Cloud", 99, 21000),
            new Course("Docker", "Cloud", 92, 20000),
            new Course("Kubernetes", "Cloud", 91, 20000)
    );

    public static void main(String[] args) {
        List<Course> courses = courseSupplier.get();

        // group courses by category

        Map<String, List<Course>> groupedCourses =
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory));

        System.out.println(groupedCourses);

        // group by categories and find count

        Map<String, Long> groupedCourcesWithCount = courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()));

        System.out.println(groupedCourcesWithCount);

        // group by categories and find name
        Map<String, List<String>> groupedCourcesWithName = courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList())));

        System.out.println(groupedCourcesWithName);

        // group by categories and find course in each category that has highest review

        Map<String, Optional<Course>> groupedCoursesWithMaxReviewScore = courses.stream()
                .collect(
                        Collectors.groupingBy(
                                Course::getCategory,
                                Collectors.maxBy(
                                        Comparator.comparingInt(Course::getReviewScore))
                        ));

        System.out.println(groupedCoursesWithMaxReviewScore);

        // group by categories and find course in each category that has highest review and return their name

        Map<String, String> highestRatedCourseNamesByCategory = courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Course::getReviewScore)),
                                optionalCourse -> optionalCourse.map(Course::getName).orElse(null)
                        )
                ));
        System.out.println(highestRatedCourseNamesByCategory);
    }
}
