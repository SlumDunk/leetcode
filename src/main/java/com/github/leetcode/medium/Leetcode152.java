package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 09:30
 * @Description: Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class Leetcode152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxP = nums[0], minN = nums[0], dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int locMax = nums[i] * maxP, locMin = nums[i] * minN;
            maxP = Math.max(nums[i], Math.max(locMax, locMin));
            minN = Math.min(nums[i], Math.min(locMax, locMin));
            dp = Math.max(dp, maxP);
        }
        return dp;
    }
}
