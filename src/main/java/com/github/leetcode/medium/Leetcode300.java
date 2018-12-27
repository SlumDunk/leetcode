package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/27/18 09:27
 * @Description: Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length < 1) return 0;
//        int[] d = new int[nums.length];
//        d[0] = 1;
//        int max = 1;
//        for (int i = 1; i < nums.length; i++) {
//            d[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    d[i] = Math.max(d[i], d[j] + 1);
//                }
//            }
//            max = Math.max(max, d[i]);
//        }
//        return max;
        //不需要连续
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
