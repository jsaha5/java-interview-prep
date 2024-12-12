package org.jp.leetcode.twopointer;

import java.util.Arrays;
import java.util.Optional;

/*•	Given a unsorted sorted array of integers and a target, find two numbers that add up to the target.
        (LeetCode: Two Sum II - Input Array Is Sorted)*/
public class FindTwoNumsThatAddUpTotheTarget {

    public Optional<int[]> twoSumUnsorted(int[] numbers, int target) {

        var pointer1 = 0;
        var pointer2 = pointer1 + 1;
        while (pointer1 < numbers.length - 1) {
            var pointer1Value = numbers[pointer1];
            var pointer2Value = numbers[pointer2];
            if (pointer1Value + pointer2Value == target) {
                return Optional.of(new int[]{pointer1, pointer2});
            } else {
                if (pointer2 == numbers.length - 1) {
                    pointer1++;
                    pointer2 = pointer1 + 1;
                } else {
                    pointer2++;
                }
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        Arrays.stream(ints).forEach(System.out::println);
    }
    public static  int[] twoSum(int[] nums, int target) {
        int i;
        int j=0;
        outerLoop:
        for ( i = 0; i< nums.length; i++) {

            for ( j = i+1; j< nums.length; j++) {
                var sum  = nums[i] + nums[j];

                if (sum == target )
                    break outerLoop;

            }
        }
        return new int []{i,j};
    }
    public Optional<int[]> twoSumSorted(int[] numbers, int target) {
        var pointer1 = 0;
        var pointer2 = numbers.length - 1;
        while (pointer1 < pointer2) {
            var sum = numbers[pointer1] + numbers[pointer2];
            if (sum == target) {
                return Optional.of(new int[]{pointer1, pointer2});
            } else {
                if (sum < target) {
                    pointer1++;
                } else {
                    pointer2--;
                }
            }
        }
        return Optional.empty();
    }
}
