package com.github.lintcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 7/25/19 22:57
 * @Description:
 */
public class Lintcode563 {
    public int backPackV(int[] A, int T) {
        int i, j;
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] f = new int[T + 1];
        f[0] = 1;
        for (i = 1; i <= T; i++) {
            f[i] = 0;
        }
        for (i = 1; i <= n; i++) {
            for (j = T; j >= 0; j--) {
                if (j >= A[i - 1]) {
                    f[j] += f[j - A[i - 1]];
                }
            }
        }
        return f[T];
    }


    /**
     * @param nums:   an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV__(int[] nums, int target) {
        // write your code here
        //看最后一步
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 0);
        }
        dp[0][0] = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else if (i != 0 && j != 0) {
                    dp[i][j] += dp[i - 1][j];
                    if (target >= nums[i]) {
                        dp[i][j] += dp[i - 1][target - nums[i]];
                    }
                }
            }
        }

        return dp[n][target];


    }
}
