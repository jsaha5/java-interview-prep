package org.jp.leetcode.LongestCommonPrefix;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestPrefix(String[] strs) {
        String preFix = "";
        String firstString = strs[0];
        String matchedPrefix = "";
        for (char a : firstString.toCharArray()) {
            preFix = preFix + a;
            boolean isPrefix = true;
            for (int i = 1; i < strs.length; i++) {
                var stringToMatch = strs[i];
                if (!stringToMatch.startsWith(preFix)) {
                    isPrefix = false;
                    break;
                }
            }
            if(isPrefix) {
                matchedPrefix = preFix;
            } else {
                break;
            }

        }
        return matchedPrefix;
    }
}
