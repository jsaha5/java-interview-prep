package org.jp.leetcode.romantoint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));;
    }

    public static  int romanToInt(String s) {
        int intNum = 0;
        // Map to store Roman numeral values
        Map<String, Integer> romanNoMap = Map.of(
                "I", 1, "V", 5, "X", 10, "L", 50,
                "C", 100, "D", 500, "M", 1000
        );

        char[] charArray = s.toCharArray();
        int pre = 0; // Variable to store the value of the previous numeral

        // Loop through the string from the end to the beginning
        for (int i = charArray.length - 1; i >= 0; i--) {
            int currentValue = romanNoMap.get(String.valueOf(charArray[i]));

            // Add or subtract based on the comparison with the previous numeral
            if (currentValue >= pre) {
                intNum += currentValue;
            } else {
                intNum -= currentValue;
            }

            // Update the previous numeral value
            pre = currentValue;
        }
        return intNum;
    }
}
