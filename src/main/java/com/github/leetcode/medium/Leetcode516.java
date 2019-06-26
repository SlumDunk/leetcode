package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 2/25/19 08:30
 * @Description:
 */
public class Leetcode516 {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else {
            int len = s.length();
            //以i字符开头，j字符结尾的最长回文序列长度
            int[][] dp = new int[len][len];
            int i, j;
            for (i = 0; i < len; i++) {
                dp[i][i] = 1;
            }
            for (i = 0; i < len - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = 2;
                } else {
                    dp[i][i + 1] = 1;
                }
            }
            for (int l = 3; l <= len; l++) {
                for (i = 0; i <= len - l; i++) {
                    j = i + l - 1;
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    if (s.charAt(i) == s.charAt(j) && dp[i][j] < dp[i + 1][j - 1] + 2) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                }
            }
            int result = 0;
            for (i = 0; i < len; i++) {
                for (j = 0; j < len; j++) {
                    result = Math.max(dp[i][j], result);
                }
            }
            return result;
        }
    }
}