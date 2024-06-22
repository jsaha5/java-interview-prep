package org.jp.streams.example;

import org.jp.behavior.parameterization.BehaviorParamererizationDemo;
import org.jp.models.Apple;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PlayingWithStreamOperations {
    public static void main(String[] args) {

        // sum of all the nums
        IntStream intStream = IntStream.range(1, 10);
      /*  System.out.println(
                intStream
                        .reduce(0, Integer::sum)
        );*/

        // find min num

     /*   System.out.println(
                IntStream.range(-5, 10)
                        .reduce(Integer.MIN_VALUE,  Integer::max)
        );*/

        // square no and find their sum

      /*  System.out.println(
                intStream
                        .map(i -> i * i)
                        .reduce(0, Integer::sum)
        );
*/
        // square of even nums and find their sum

     /*   System.out.println(
                intStream
                        .filter(i -> i % 2 == 0)
                        .map(x->x*x)
                        .reduce(0,Integer::sum)
        );*/

        // print distinct apples

        List<Apple> apples = BehaviorParamererizationDemo.getApples();
        /*apples.stream().distinct().forEach(System.out::println);*/

        // sort apples by size

        /*apples.stream()
                .sorted(Comparator.comparing(Apple::weight))
                .forEach(System.out::println);*/

        Stream<String> courses = Stream.of("Spring", "Spring Boot", "API", "MICROSERVICE", "AWS", "PCF", "AZURE", "DOCKER", "KUBERNETES");
        // sort courses

        /*courses.sorted().forEach(System.out::println);*/

        // sort courses in reverse

        /* courses.sorted(Comparator.reverseOrder()).forEach(System.out::println);*/

        // sort courses based on course length

        //courses.sorted(Comparator.comparing(String::length)).forEach(System.out::println);

        // sort courses based on course length reversed
        courses.sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);


    }
}
