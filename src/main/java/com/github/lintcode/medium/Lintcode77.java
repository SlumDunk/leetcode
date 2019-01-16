package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/15/19 09:48
 * @Description: Given two strings, find the longest common subsequence (LCS).
 * <p>
 * Your code should return the length of LCS.
 * <p>
 * Example
 * For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
 * <p>
 * For "ABCD" and "EACB", the LCS is "AC", return 2.
 * <p>
 * Clarification
 * What's the definition of Longest Common Subsequence?
 * <p>
 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 * http://baike.baidu.com/view/2020307.htm
 */
public class Lintcode77 {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
