package org.jp.streams.example;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MoreStreamOperations {
    public static void main(String[] args) {
        List<Integer> nums = List.of(12, 3, 4, 5, 67, 15, 30);

        // double the nums and get a list out of it

        // create a mutable list
//        List<Integer> collect = nums.stream().map(x -> x + x).collect(Collectors.toList());
        // create a immutable list
        /* List<Integer> collect1 = nums.stream().map(x -> x + x).toList();*/


        // create behavour parameterization for map so
        // we can use same method to do double, triple square

        BiFunction<List<Integer>, Function<Integer, Integer>, List<Integer>> mapAndCollect = (numbers, mapper) -> numbers.stream().map(mapper).toList();

        // add 2 to all the nums

//        mapAndCollect.apply(nums, x -> x + 2).forEach(System.out::println);

        // square the nums

        mapAndCollect.apply(nums, x -> x *x).forEach(System.out::println);

//        String hello = "Hello";
//
//        Runnable runnable = () -> System.out.println(hello);
//

    }


}
