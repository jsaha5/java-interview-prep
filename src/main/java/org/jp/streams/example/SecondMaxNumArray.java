package org.jp.streams.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class SecondMaxNumArray {
    public static void main(String[] args) {
        int nums [] = {2,56,7,8,9,10,45};
        IntStream stream = Arrays.stream(nums);
        System.out.println(stream.boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst());

      //  System.out.println(first);
    }
}
