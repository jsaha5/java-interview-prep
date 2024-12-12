package org.jp.leetcode.palindrom;

import java.util.function.Predicate;

public class PalindromeDemo {

    static Predicate<String> palindromeUsingStringBuilder = (str) -> {
        StringBuilder builder = new StringBuilder(str);
        return builder.reverse().toString().equals(str);
    };

    public static  boolean isPalindrome(int x) {
        if (x < 0 )
            return false;
        else {
            var reversedNo = 0;
            var num = x;
            while(num != 0 ) {
                var remainder = num % 10;
                reversedNo = reversedNo *10 + remainder;
                num = num/10;
            }

            if (x == reversedNo)
                return true;
            return false;
        }
    }
    public static void main(String[] args) {

        //   System.out.println(palindromeUsingStringBuilder.test("hih"));

        int num = -121;
        int reverseNo = 0;
        while (num != 0) {
            var remainder = num % 10;
            reverseNo = reverseNo * 10 + remainder;
            num = num / 10;
        }
        System.out.println(reverseNo);
    }


}
