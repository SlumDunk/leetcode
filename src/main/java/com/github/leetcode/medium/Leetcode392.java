package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/20/18 10:23
 * @Description: Given a string s and a string t, check if s is subsequence of t.
 * <p>
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * Return true.
 * <p>
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * Return false.
 * <p>
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 * <p>
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test cases.
 */
public class Leetcode392 {
    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length()) return false;
//        int prev = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char tmpChar = s.charAt(i);
//            prev = t.indexOf(tmpChar, prev);
//            if (prev == -1) return false;
//            prev++;
//        }
//        return true;

        int prev = 0;
        //遍历短的字符串
        for (int i = 0; i < s.length(); i++) {
            char tmpChar = s.charAt(i);
            //看看从上一个位置开始能否找到对应的字符，有顺序要求
            prev = t.indexOf(tmpChar, prev);
            if (prev == -1) {
                return false;
            }
            prev++;
        }
        return true;

        //求两个字符串的最长公共子串 动态规划 内存溢出
//        int m = s.length();
//        int n = t.length();
//        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 0; i <= m; i++) {
//            dp[i][0] = 0;
//        }
//        for (int i = 0; i <= n; i++) {
//            dp[0][i] = 0;
//        }
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (s.charAt(i - 1) == t.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        if (dp[m][n] == m) {
//            return true;
//        } else {
//            return false;
//        }
    }
}
