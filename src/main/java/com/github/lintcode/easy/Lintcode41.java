package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 15:06
 * @Description: Given an array of integers, find a contiguous subarray which has the largest sum.
 * <p>
 * Example
 * Example1:
 * Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * Example2:
 * Given the array [1,2,3,4], the contiguous subarray [1,2,3,4] has the largest sum = 10.
 * <p>
 * Challenge
 * Can you do it in time complexity O(n)?
 * <p>
 * Notice
 * The subarray should contain at least one number.
 */
public class Lintcode41 {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = nums[0];
            //包括前面子串和不包括前面子串，取最大
            for (int i = 1; i < len; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            }

            int max = dp[0];
            for (int i = 1; i < len; i++) {
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
