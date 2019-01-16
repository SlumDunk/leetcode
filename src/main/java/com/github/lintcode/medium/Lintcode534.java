package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/14/19 08:15
 * @Description: After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example
 * nums = [3,6,4], return 6
 * <p>
 * Notice
 * This is an extension of House Robber.
 */
public class Lintcode534 {
    /**
     * @param nums: An array of non-negative integers.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        if (start + 1 == end) {
            return Math.max(nums[start], nums[end]);
        }
        int[] dp = new int[2];
        dp[start % 2] = nums[start];
        dp[(start + 1) % 2] = Math.max(nums[start + 1], dp[start % 2]);

        for (int i = start + 2; i <= end; i++) {
            dp[i % 2] = Math.max(dp[(i - 2) % 2] + nums[i], dp[(i - 1) % 2]);
        }
        return dp[end % 2];
    }
}
