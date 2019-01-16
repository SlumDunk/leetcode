package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/14/19 08:11
 * @Description: You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example
 * Given [3, 8, 4], return 8.
 * <p>
 * Challenge
 * O(n) time and O(1) memory.
 */
public class Lintcode392 {
    /**
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        long[] dp = new long[len + 1];

        dp[0] = 0;
        dp[1] = A[0];
        long max = dp[1];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(A[i - 1] + dp[i - 2], dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobberII(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        long[] dp = new long[2];

        dp[0] = 0;
        dp[1] = A[0];
        for (int i = 2; i <= len; i++) {
            dp[i % 2] = Math.max(A[i - 1] + dp[(i - 2) % 2], dp[(i - 1) % 2]);
        }
        return dp[len % 2];
    }
}
