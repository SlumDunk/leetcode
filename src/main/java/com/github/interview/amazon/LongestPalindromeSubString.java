package com.github.interview.amazon;

/**
 * @Author: zerongliu
 * @Date: 4/9/19 22:33
 * @Description:
 */
public class LongestPalindromeSubString {
    public String longestPalindromeSubString(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }

        int len = s.length();
        int start = 0, end = 0;
        int maxLen = 1;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(j) == s.charAt(i)) {
                    if (j + 1 == i) {
                        dp[j][i] = 2;
                    } else if (j + 1 == i - 1 && dp[j + 1][i - 1] > 0) {
                        dp[j][i] = dp[j + 1][i - 1] + 2;
                    }
                    if (dp[j][i] > maxLen) {
                        maxLen = dp[j][i];
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }
}
