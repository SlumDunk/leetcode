package com.github.lintcode.easy;

import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 14:38
 * @Description: Given an array of integers, find the subarray with smallest sum.
 * <p>
 * Return the sum of the subarray.
 * <p>
 * Example
 * For [1, -1, -2, 1], return -3.
 * <p>
 * Notice
 * The subarray should contain one integer at least.
 */
public class Lintcode44 {
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return 0;
        } else {
            //以某个数为结尾的子串最小和
            int len = nums.size();
            int[] dp = new int[len];
            dp[0] = nums.get(0);
            for (int i = 1; i < nums.size(); i++) {
                if (dp[i - 1] < 0) {
                    dp[i] = dp[i - 1] + nums.get(i);
                } else {
                    dp[i] = nums.get(i);
                }
            }

            int min = dp[0];
            for (int i = 1; i < len; i++) {
                min = Math.min(min, dp[i]);
            }
            return min;
        }
    }
}
