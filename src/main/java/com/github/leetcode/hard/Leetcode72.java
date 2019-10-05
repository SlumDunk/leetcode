package com.github.leetcode.hard;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 2/20/19 23:07
 * @Description: Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 * <p>
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 * <p>
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'count')
 * exection -> execution (insert 'u')
 */
public class Leetcode72 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]) + 1, dp[i - 1][j - 1]);
                } else {
                    //replace, insert, delete
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }
        return dp[n][m];
    }

    public int minDistance__(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();

        int INF = (int) 1e9 + 7;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], INF);
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (array1[i - 1] == array2[j - 1]) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                    } else {
                        //最后一个替换
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                        //最后一个删除
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                        //最后一个增加
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                }
            }
        }

        return dp[m][n];
    }
}
