package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 9/25/18 13:16
 * @Description: Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class Leetcode5 {
    public static void main(String[] args) {
        Leetcode5 leetcode5 = new Leetcode5();
        System.out.println(leetcode5.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }
        int len = s.length();
        //开始位置，结束位置
        int start = 0, end = 0;
        int maxLength = 0;
        //存放i...j回文字符串中间结果
        int[][] dp = new int[len][len];
        //字符本身看成一个长度为1的回文字符串
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < len; i++) {
            //从后往前走
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(j) == s.charAt(i)) {//j和i的字符相等
                    if (j + 1 == i) {
                        dp[j][i] = 2;
                    } else if (j + 1 <= i - 1 && dp[j + 1][i - 1] > 0) {//中间字符串也是回文序列
                        dp[j][i] = dp[j + 1][i - 1] + 2;
                    }
                    if (dp[j][i] > maxLength) {
                        maxLength = dp[j][i];
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * O(N^2)
     * @param s
     * @return
     */
    public String longestPalindrome__(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        int max = 1;
        String result = "";

        boolean[][] dp = new boolean[n][n];
        for (boolean[] sub : dp) {
            Arrays.fill(sub, false);
        }

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            result = s.substring(i, i + 1);
        }

        for (int i = 0; i < n - 1; i++) {
            if (array[i] == array[i + 1]) {
                dp[i][i + 1] = true;
                if (max < 2) {
                    result = s.substring(i, i + 2);
                }
            } else {
                dp[i][i + 1] = false;
            }
        }

        for (int l = 3; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                if (array[i] == array[j]) {
                    dp[i][j] |= dp[i + 1][j - 1];
                }
                if (l > max && dp[i][j] == true) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }
}
