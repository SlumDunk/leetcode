package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 17:12
 * @Description: Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
 * <p>
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Note:
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 */
public class Leetcode583 {
    /**
     * 最长公共子序列
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0) continue;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }


    public int minDistance__(String word1, String word2) {
        //sea
        //eat
        int m = word1.length();
        int n = word2.length();

        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();

        int[][] dp = new int[m + 1][n + 1];
        int INF = (int) 1e9 + 7;

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
                        dp[i][j] = dp[i - 1][j - 1];
                    }

                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
            }
        }

        return dp[m][n];

    }
}
