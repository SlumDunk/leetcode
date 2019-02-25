package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 2/21/19 08:52
 * @Description: Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * <p>
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * <p>
 * Note:
 * <p>
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 * <p>
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class Leetcode312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int i, j, k, len;
        int[] A = new int[n + 2];
        A[0] = A[n + 1] = 1;
        for (i = 1; i <= n; i++) {
            A[i] = nums[i-1];
        }
        n += 2;
        //dp[i][j] 代表 burst i+1 ~ j-1 这段时间的所有气球之后，只剩下 i,j 的最大收益。
        //将原来的数组前面和后面增加两个1，最后结果就是 dp[0][n - 1]（burst 掉所有气球只剩两个1）
        int[][] dp = new int[n][n];
        for (i = 0; i < n - 1; i++) {
            dp[i][i + 1] = 0;
        }

        for (len = 3; len <= n; len++) {
            for (i = 0; i <= n - len; i++) {
                j = i + len - 1;
                dp[i][j] = 0;
                for (k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[k] * A[j]);
                }
            }
        }
        return dp[0][n];
    }
}
