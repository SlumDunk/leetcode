package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 2/22/19 06:36
 * @Description: Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 * <p>
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 * <p>
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * Examples:
 * <p>
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * <p>
 * Output:
 * 18
 * <p>
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 */
public class Leetcode410 {
    public int splitArray(int[] nums, int m) {
//        dp[i][j] : the max sum of numbers of i sub array when the end element is at position j
//        dp[1][j] = sum(0,j)
//        dp[i][j] = min{max(dp[i-1][k], sum(k+1,..., j)} 0<k<=j;
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int len = nums.length;
            int[] presum = new int[len];
            presum[0] = nums[0];
            for (int i = 1; i < len; i++) {
                presum[i] = presum[i - 1] + nums[i];
            }
            int[][] dp = new int[m + 1][len];
            for (int i = 0; i < len; i++) {
                dp[1][i] = presum[i];
            }
            for (int i = 2; i <= m; i++) {
                for (int j = i - 1; j < len; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < j; k++) {
                        //子数组里头取大的数，总切割方法里头取最小
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], presum[j] - presum[k]));
                    }
                }
            }
            return dp[m][len - 1];
        }
    }
}
