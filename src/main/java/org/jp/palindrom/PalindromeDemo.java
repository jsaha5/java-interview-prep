package org.jp.palindrom;

import java.util.function.Predicate;

public class PalindromeDemo {

    static Predicate<String> palindromeUsingStringBuilder = (str) -> {
        StringBuilder builder = new StringBuilder(str);
        return builder.reverse().toString().equals(str);
    };


    public static void main(String[] args) {
        System.out.println(palindromeUsingStringBuilder.test("hih"));
    }


}
