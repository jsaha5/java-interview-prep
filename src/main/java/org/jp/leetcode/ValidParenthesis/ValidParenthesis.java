package org.jp.leetcode.ValidParenthesis;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {

        System.out.println(isValidParenthesis("]["));
    }

    public static Boolean isValidParenthesis(String input) {

        Stack<String> stack = new Stack<>();
        for (var a : input.toCharArray()) {
            switch (a) {
                case '[', '{', '(':
                    stack.push(String.valueOf(a));
                    break;
                case ']':
                    if (!stack.empty() && stack.peek().equals(String.valueOf('['))) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (!stack.empty() && stack.peek().equals(String.valueOf('{'))) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ')':
                    if (!stack.empty() && stack.peek().equals(String.valueOf('('))) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;

            }
        }
        return stack.empty();
    }
}
