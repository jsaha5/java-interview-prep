package org.jp.leetcode.twopointer;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicate(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));

    }
    public static int removeDuplicate(int [] nums) {

        if (nums.length == 0) return 0;

        // Initialize the pointer for the last unique element
        int i = 0;

        // Iterate through the array
        for (int j = 1; j < nums.length; j++) {
            // If the current element is not a duplicate
            if (nums[j] != nums[i]) {
                i++;               // Move the pointer for unique elements
                nums[i] = nums[j]; // Update the unique element position
            }
        }

        // Return the new length of the array with unique elements
        return i + 1;
    }
}
