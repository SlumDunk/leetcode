package com.github.lintcode.medium;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/15/19 21:14
 * @Description: Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.
 * <p>
 * If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|
 * <p>
 * Example
 * Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.
 * <p>
 * Return 2.
 * <p>
 * Notice
 * You can assume each number in the array is a positive integer and not greater than 100.
 */
public class Lintcode91 {
    /*
    * @param A: An integer array
    * @param target: An integer
    * @return: An integer
    */
    public int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
        int n = A.size();
        //第i个数调整成j，且相邻两个数差值不大于target的最小成本
        int[][] dp = new int[n + 1][101];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 100; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i <= 100; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 100; j++) {
                if (dp[i - 1][j] != Integer.MAX_VALUE) {
                    for (int k = 0; k <= 100; k++) {
                        //相邻两个差值不能大于target
                        if (Math.abs(j - k) <= target) {
                            dp[i][k] = Math.min(dp[i][k], dp[i - 1][j] + Math.abs(A.get(i - 1) - k));
                        }
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; i++) {
            ans = Math.min(dp[n][i], ans);
        }
        return ans;
    }

    /*
    * @param A: An integer array
    * @param target: An integer
    * @return: An integer
    */
    public int MinAdjustmentCost__(List<Integer> A, int target) {
        // write your code here
        int n = A.size();

        int INF = (int) (1e9 + 7);

        int[][] dp = new int[n + 1][101];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        Arrays.fill(dp[0], 0);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 100; j++) {
                if (dp[i - 1][j] != INF) {
                    for (int k = 0; k <= 100; k++) {
                        if (Math.abs(j - k) <= target) {
                            dp[i][k] = Math.min(dp[i][k], dp[i - 1][j] + Math.abs(A.get(i - 1) - k));
                        }
                    }
                }
            }
        }

        int ans = INF;
        for (int i = 0; i <= 100; i++) {
            ans = Math.min(dp[n][i], ans);
        }

        return ans;

    }
}
