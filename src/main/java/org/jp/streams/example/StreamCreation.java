package org.jp.streams.example;

import java.math.BigInteger;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreation {

    public static void main(String[] args) {
       /* // create stream of nums from 1 to 9and add them

        int sum = IntStream.range(1, 10).sum();

        System.out.println(sum);

        OptionalDouble average = IntStream.rangeClosed(1, 10).peek(System.out::println).average();

        System.out.println(average);
        System.out.println("--------------------");

        // create int stream with incrementing by 2
        IntStream.iterate(1, i -> i + 2).limit(10).forEach(System.out::println);

        // print first 10 even nums and add them
        System.out.println("--------------------");
        int sum1 = IntStream.iterate(2, i -> i + 2).limit(10).peek(System.out::println).sum();

        System.out.println(sum1);

        // first 10 power of 2 and collect them to a list
        System.out.println("--------------------");
        List<Integer> list = IntStream.iterate(2, i -> i * 2).limit(10).peek(System.out::println).boxed().toList();*/

        // factorial of first 10 nums

        BigInteger factorial = IntStream.rangeClosed(1, 50).peek(System.out::println).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, (BigInteger::multiply));
        System.out.println(factorial);

    }
}
