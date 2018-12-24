package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/2/18 13:31
 * @Description: Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 * <p>
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class Leetcode343 {
    public static void main(String[] args) {
        Leetcode343 leetcode343 = new Leetcode343();
        System.out.println(leetcode343.integerBreak(10));
    }

    public int integerBreak(int n) {
        //n 大于2
        if (n <= 1) {
            return 0;
        }
        //存储第n个数可以分解成的最大的积
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                //分成两部分，每部分看情况决定要不要继续分解，只取各部分最大的值
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }
}
