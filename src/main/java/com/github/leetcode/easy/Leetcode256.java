package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 2/25/19 14:49
 * @Description: There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 * <p>
 * Note:
 * All costs are positive integers.
 * <p>
 * Example:
 * <p>
 * Input: [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 * Minimum cost: 2 + 5 + 3 = 10.
 */
public class Leetcode256 {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        } else {
            int m = costs.length;
            int n = costs[0].length;
            int[][] dp = new int[m][n];
            for (int j = 0; j < n; j++) {
                dp[0][j] = costs[0][j];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < n; k++) {
                        if (k != j) {
                            min=Math.min(min, dp[i - 1][k]);
                        }
                    }
                    dp[i][j] = costs[i][j] + min;
                }
            }

            int minCost = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                minCost = Math.min(dp[m - 1][j], minCost);
            }
            return minCost;
        }
    }
}
