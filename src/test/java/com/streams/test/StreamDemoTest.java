package com.streams.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StreamDemoTest {


    @Test
    @DisplayName("test Given a list of integers, filter out the even numbers and print them")
    public void filterEvenNo() {

        List<Integer> numbers = Arrays.asList(1, 78, 8, 10, 100, 45, 78);

        numbers.stream()
                .filter(num-> num%2 == 0)
                .forEach(System.out::println);


    }
}
