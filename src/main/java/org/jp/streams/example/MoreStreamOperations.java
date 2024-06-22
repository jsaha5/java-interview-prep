package org.jp.streams.example;

import java.util.List;
import java.util.stream.Collectors;

public class MoreStreamOperations {
    public static void main(String[] args) {
        List<Integer> nums = List.of(12, 3, 4, 5, 67, 15, 30);

        // double the nums and get a list out of it

        // create a mutable list
        List<Integer> collect = nums.stream().map(x -> x + x).collect(Collectors.toList());
        // create a immutable list
        List<Integer> collect1 = nums.stream().map(x -> x + x).toList();

        collect.add(45);


    }
}
