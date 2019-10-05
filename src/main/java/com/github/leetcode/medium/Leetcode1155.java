package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 9/14/19 16:26
 * @Description:
 */
public class Leetcode1155 {
    public int numRollsToTarget(int d, int f, int target) {
        //前d个dice能够组合出目标值target的方法数
        //dp[d+1][target+1]
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;

        int mod = (int) 1e9 + 7;

        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= f; j++) {
                for (int k = j; k <= target; k++) {
                    dp[i][k] = (dp[i][k] + dp[i - 1][k - j]) % mod;
                }
            }
        }
        return dp[d][target];
    }
}
