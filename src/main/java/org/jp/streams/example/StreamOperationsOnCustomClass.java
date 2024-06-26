package org.jp.streams.example;


import org.jp.models.Course;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Supplier;

public class StreamOperationsOnCustomClass {
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
        // courses.forEach(System.out::println);

        // all match
        // Returns whether all elements of this stream match the provided predicate. May not evaluate the predicate on all elements if not necessary for determining the result. If the stream is empty then true is returned and the predicate is not evaluated.
        // check
        System.out.println(courses.stream().allMatch(course -> course.getNoOfStudents() < 10));
        // none match

        System.out.println(courses.stream().noneMatch(course -> course.getNoOfStudents() < 10));

        // any match

        System.out.println(courses.stream().anyMatch(course -> course.getName().startsWith("D")));

        // sort courses by no of students in decreasing order if the number of students same srort based on review score

       /* courses.stream()
                .sorted(Comparator
                        .comparingInt(Course::getNoOfStudents)
                        .thenComparingInt(Course::getReviewScore)
                        .reversed())
                .forEach(System.out::println);*/

        // after sorting print only first 2

        /*courses.stream()
                .sorted(Comparator
                        .comparingInt(Course::getNoOfStudents)
                        .thenComparingInt(Course::getReviewScore)
                        .reversed())
                .limit(2)
                .forEach(System.out::println);*/

        // after sorting print last 2

        /*courses.stream()
                .sorted(Comparator
                        .comparingInt(Course::getNoOfStudents)
                        .thenComparingInt(Course::getReviewScore)
                        .reversed())
                .skip(7)
                .forEach(System.out::println);*/

        // after sorting print all the elements except first and last

       /* courses.stream()
                .sorted(Comparator
                        .comparingInt(Course::getNoOfStudents)
                        .thenComparingInt(Course::getReviewScore)
                        .reversed())
                .skip(1)
                .limit(7)
                .forEach(System.out::println);*/

            // take elements from list until predicate is matching
        courses.forEach(System.out::println);
        System.out.println("-----------------------");
        /*List<Course> list = courses.stream().takeWhile(c -> c.getReviewScore() >= 95).toList();
        list.forEach(System.out::println);*/

        // skip  elements from list until predicate is matching
//        List<Course> list1 = courses.stream().dropWhile(c -> c.getReviewScore() >= 95).toList();
//        list1.forEach(System.out::println);


        // stream max
       /* Optional<Course> max = courses.stream().max(Comparator.comparing(Course::getNoOfStudents));
        System.out.println(max);*/

        // stream min

      /*  Optional<Course> min = courses.stream().min(Comparator.comparing(Course::getNoOfStudents));
        System.out.println(min);*/
        // min /max returns optional
       /* Course course1 = courses.stream()
                .filter(course -> course.getReviewScore() < 10)
                .max(Comparator.comparing(Course::getNoOfStudents))
                .orElse(new Course("Spring", "Framework", 98, 20000));
        System.out.println(course1);*/

        // find first element that matches the predicate

        /*Course couseFound = courses.stream()
                .filter(c -> c.getReviewScore() > 10)
                .findFirst()
                .orElseThrow();

        System.out.println(couseFound);

        Course noCouseFound = courses.stream()
                .filter(c -> c.getReviewScore() < 10)
                .findFirst()
                .orElseThrow();

        System.out.println(noCouseFound);*/

        // find any element that matches the predicate

        /*Course noCouseFound = courses.stream()
                .filter(c -> c.getReviewScore() > 10)
                .findAny()
                .orElseThrow();
        System.out.println(noCouseFound);*/


        // find the total no of students for courses where review rating is above 95
        courses.stream()
                .filter(c -> c.getReviewScore() <= 91).forEach(System.out::println);
        int sum = courses.stream()
                .filter(c -> c.getReviewScore() <= 91)
                .mapToInt(Course::getNoOfStudents)
                        .sum();
        OptionalDouble average = courses.stream()
                .filter(c -> c.getReviewScore() <= 91)
                .mapToInt(Course::getNoOfStudents)
                .average();
        System.out.println("AVG: "+average);
        System.out.println("SUM: "+sum);

        System.out.println("count: "+ courses.stream()
                .filter(c -> c.getReviewScore() <= 91)
                .count());


    }


}
