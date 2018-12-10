package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/9/18 23:07
 * @Description: You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class Leetcode70 {
    public int climbStairs(int n) {
        //存储走到第n阶梯的方式
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            //走两步到达的+走一步到达的
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
