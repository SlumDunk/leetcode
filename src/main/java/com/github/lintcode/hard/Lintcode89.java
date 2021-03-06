package com.github.lintcode.hard;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 1/16/19 08:18
 * @Description: Given n distinct positive integers, integer k (k <= n) and a number target.
 * <p>
 * Find k numbers where sum is target. Calculate how many solutions there are?
 * <p>
 * Example
 * Given [1,2,3,4], k = 2, target = 5.
 * <p>
 * There are 2 solutions: [1,4] and [2,3].
 * <p>
 * Return 2.
 */
public class Lintcode89 {
    /**
     * @param A:      An integer array
     * @param k:      A positive integer (k <= length(A))
     * @param target: An integer
     * @return: An integer
     */
    public int kSum(int[] A, int k, int target) {
        // write your code here
        int len = A.length;
        int[][][] dp = new int[len + 1][k + 1][target + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][0][0] = 1;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    dp[i][j][t] = 0;
                    if (t >= A[i - 1]) {
                        dp[i][j][t] = dp[i - 1][j - 1][t - A[i - 1]];
                    }
                    dp[i][j][t] += dp[i - 1][j][t];
                }
            }
        }
        return dp[len][k][target];
    }

    /**
     * @param A:      An integer array
     * @param k:      A positive integer (k <= length(A))
     * @param target: An integer
     * @return: An integer
     */
    public int kSum__(int[] A, int k, int target) {
        // write your code here
        int n = A.length;
        int[][][] dp = new int[n + 1][k + 1][target + 1];

        Arrays.fill(dp[0][0], 0);
        dp[0][0][0] = 1;


        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int l = 0; l <= target; l++) {
                    if (j == 0 && l == 0) {
                        dp[i][j][l] = 1;
                    } else if (j == 0) {
                        dp[i][j][l] = 0;
                    } else {
                        dp[i][j][l] = dp[i - 1][j][l] + (l >= A[i - 1] ? dp[i - 1][j - 1][l - A[i - 1]] : 0);
                    }
                }
            }
        }
        return dp[n][k][target];
    }
}
