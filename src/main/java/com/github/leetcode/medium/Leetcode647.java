package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 2/5/19 13:07
 * @Description:
 */
public class Leetcode647 {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else {
            int len = s.length();
            boolean[][] dp = new boolean[len][len];
            int count = 0;
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
                count++;
            }
            for (int i = 0; i < len - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    count++;
                } else {
                    dp[i][i + 1] = false;
                }
            }

            for (int l = 2; l < len; l++) {
                for (int start = 0; start + l < len; start++) {
                    if (s.charAt(start) == s.charAt(start + l)) {
                        dp[start][start + l] = dp[start + 1][start + l - 1];
                    }
                    if (dp[start][start + l]) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public int countSubstrings__(String s) {
        int n = s.length();
        char[] array = s.toCharArray();

        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (boolean[] sub : dp) {
            Arrays.fill(sub, false);
        }

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        for (int i = 0; i < n - 1; i++) {
            if (array[i] == array[i + 1]) {
                dp[i][i + 1] = true;
                count++;
            } else {
                dp[i][i + 1] = false;
            }
        }

        for (int l = 3; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                if (array[i] == array[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
