package com.github.leetcode.easy;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * <p>
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 */
public class Leetcode746 {
    public static void main(String[] args) {
        Leetcode746 leetcode746 = new Leetcode746();
        int[] cost = {10, 15, 20};
        leetcode746.minCostClimbingStairs(cost);
    }

    public int minCostClimbingStairs(int[] cost) {
//        int length = cost.length + 1;
//        int[] dp = new int[length];
//        dp[0] = 0;
//        dp[1] = 0;
//        for (int i = 2; i < length; i++) {
//            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
//        }
//        return dp[length - 1];
        int len = cost.length;
        //[][0]走这一步的代价，[][1]不走这一步的代价
        int[][] dp = new int[len + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = cost[0];
        dp[1][1] = 0;
        for (int i = 2; i <= len; i++) {
            dp[i][0] = Math.min(dp[i - 2][0] + cost[i-1], dp[i - 1][0] + cost[i-1]);
            dp[i][1] = dp[i - 1][0];
        }
        return Math.min(dp[len][0], dp[len][1]);
    }
}
