package org.jp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;

/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.*/

interface TriFunction<K, V, N, M> {
    M apply(K k, V v, N n);
}

public class RemoveElements {

    // using streams
    public static BiFunction<int[], Integer, Long> removeElements = (nums, val) ->
            Arrays.stream(nums).filter(num -> num != val).count();
    // find fist index of val in nums from last
    public static TriFunction<int[], Integer, Integer, Integer> findFirstIndexFromLast =
            (numbers, val, lastIndex) -> {
                for (int i = lastIndex; i >= 0; i--) {
                    if (numbers[i] != val) {
                        return i;
                    }
                }
                return -1;
            };

    public static void main(String[] args) {


      /*  BiFunction<int[], Integer, Integer> findFirstIndexFromFirst =
                (int numbers[], Integer val) -> {
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] != val) {
                            return i;
                        }
                        i--;
                    }
                    return -1;
                };*/
        int nums[] = {1,2,4,7,8,9,2,2};
        int val = 2;
        int i = removeElement1(nums, val);
        System.out.println(i);

        Arrays.stream(nums).forEach(System.out::println);

    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 1) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (val == nums[start]) {
                int elementToReplace = findFirstIndexFromLast.apply(nums, val, end);
                if (elementToReplace != -1) {
                    nums[start] = nums[elementToReplace];
                    nums[elementToReplace] = val;
                    end = elementToReplace - 1;
                }
            }
            start++;
        }
        return end + 1;

    }

    public static int removeElement1(int[] nums, int val) {
        int i = 0;  // Pointer to track the position of the next non-val element
        for (int num : nums) {
            if (num != val) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }
    ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }


}

