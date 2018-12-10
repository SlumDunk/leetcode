package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/9/18 21:39
 * @Description: Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class Leetcode303 {
    class NumArray {
        int[] dp;
        int len;

        public NumArray(int[] nums) {
            this.len = nums.length;
            if (this.len != 0) {
                dp = new int[this.len + 1];
                dp[0] = 0;
                for (int i = 1; i <= this.len; i++) {
                    dp[i] = dp[i - 1] + nums[i - 1];
                }
            }

        }

        public int sumRange(int i, int j) {
            if (dp != null && i < this.len && j < this.len) {
                return dp[j + 1] - dp[i];
            } else {
                return -1;
            }
        }
    }
}
