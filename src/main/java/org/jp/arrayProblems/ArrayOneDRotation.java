package org.jp.arrayProblems;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ArrayOneDRotation {
    static BiConsumer<int[], Integer> arrayRightRotation = (arr, times) -> {
        int i = 0;
        while (i < times) {
            for (int j = arr.length - 1; j > 0; j--) {
                int previous = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = previous;
            }
            i++;
        }
    };
    static BiConsumer<int[], Integer> arrayLeftRotation = (arr, times) -> {

        int i = 0;
        while (i < times) {
            for (int j = 0; j < arr.length - 1; j++) {
                int next = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = next;
            }
            i++;
        }
    };
    static Consumer<int[]> printArray = (arr) -> {
        System.out.println(" ");
        Arrays.stream(arr).forEach(num -> {
            System.out.print(num);
            System.out.print(" ");
        });
        System.out.println(" ");
    };

    public static void main(String[] args) {


        int[] nums = {1, 2, 3, 4, 5};

        System.out.println("Array Before Rotation");
        printArray.accept(nums);

        System.out.println("Array after 1 time Right rotation");
        arrayRightRotation.accept(nums, 1);
        printArray.accept(nums);

        System.out.println("Array after 2 time Left rotation");
        arrayLeftRotation.accept(nums,2);
        printArray.accept(nums);

    }
}
