package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 2/22/19 07:35
 * @Description: In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
 * <p>
 * Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
 * <p>
 * Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.
 * <p>
 * Example:
 * Input: [1,2,1,2,6,7,5,1], 2
 * Output: [0, 3, 5]
 * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
 * We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
 * Note:
 * nums.length will be between 1 and 20000.
 * nums[i] will be between 1 and 65535.
 * k will be between 1 and floor(nums.length / 3).
 */
public class Leetcode689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] presum = new int[len + 1], sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            //前i个数的和
            presum[i] = presum[i - 1] + nums[i - 1];
            if (i >= k) {
                //以i结尾长度为k的子序列的和
                sum[i] = presum[i] - presum[i - k];
            }
        }
        //前i个数的最大子串和
        int[][] dp = new int[len + 1][2];
        //长度为i的数组的最大子串和对应的三个子串索引位置
        int[][][] result = new int[len + 1][2][3];
        for (int j = 1; j < 4; j++) {
            int cur = j % 2;
            int pre = (j - 1) % 2;
            //i....len每个位置能取到的长度为k的最大和子串
            for (int i = k * j; i <= len; i++) {
                //长度为k的子串, include nums[i]和exlucde nums[i]取大的值
                boolean flag = i == k * j || dp[i - k][pre] + sum[i] > dp[i - 1][cur];
                //长度为k的子串, include nums[i] 和 exclude nums[i]取最大值
                dp[i][cur] = flag ? dp[i - k][pre] + sum[i] : dp[i - 1][cur];
                //更新索引
                for (int p = 0; p < j - 1; p++)
                    result[i][cur][p] = flag ? result[i - k][pre][p] : result[i - 1][cur][p];
                result[i][cur][j - 1] = flag ? i - k : result[i - 1][cur][j - 1];
            }
        }
        return result[len][3 % 2];
    }
}
