package com.github.lintcode.medium;

import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 1/15/19 07:48
 * @Description: Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.
 * <p>
 * Example
 * Given s = "lintcode", dict = ["lint", "code"].
 * <p>
 * Return true because "lintcode" can be break as "lint code".
 */
public class Lintcode107 {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if ((s == null || s.length() == 0) && (!dict.isEmpty())) {
            return false;
        }
        if ((s == null || s.length() == 0) && (dict.isEmpty())) {
            return true;
        }
        int len = s.length();
        int maxLength = getMaxLength(dict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int lastWordLength = 1; lastWordLength <= i && lastWordLength <= maxLength; lastWordLength++) {
                if (dp[i - lastWordLength] != true) {
                    continue;
                }
                String substr = s.substring(i - lastWordLength, i);
                if (dict.contains(substr)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(word.length(), maxLength);
        }
        return maxLength;
    }
}
