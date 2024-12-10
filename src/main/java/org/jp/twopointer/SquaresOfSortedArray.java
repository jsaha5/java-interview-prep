package org.jp.twopointer;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {
        // Result array to store squared values
        int[] result = new int[nums.length];

        // Two pointers: one at the start and one at the end
        int left = 0, right = nums.length - 1;
        int index = nums.length - 1; // Fill the result array from the back

        while (left <= right) {
            // Compare absolute values
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--; // Move backward in the result array
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, 0, 3, 5};
        int[] squaredArray = sortedSquares(nums);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(squaredArray));
    }
}

