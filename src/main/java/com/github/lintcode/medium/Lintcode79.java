package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/15/19 10:17
 * @Description: Given two strings, find the longest common substring.
 * <p>
 * Return the length of it.
 * <p>
 * Example
 * Given A = "ABCD", B = "CBCE", return 2.
 * <p>
 * Challenge
 * O(n x m) time and memory.
 * <p>
 * Notice
 * The characters in substring should occur continuously in original string. This is different with subsequence.
 */
public class Lintcode79 {

    public static void main(String[] args) {
        Lintcode79 lintcode79 = new Lintcode79();
        lintcode79.longestCommonSubstring("abc", "a");
    }

    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
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
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int len = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                len = Math.max(dp[i][j], len);
            }
        }
        return len;
    }
}
