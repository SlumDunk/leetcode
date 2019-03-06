package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 3/3/19 10:48
 * @Description: Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Example:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 * <p>
 * You can assume that you can always reach the last index.
 */
public class Leetcode45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int len = nums.length;
            int[] dp = new int[len];
            for (int i = 0; i < len; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
            dp[0] = 0;
            for (int i = 0; i < len; i++) {
                for (int k = 1; k < nums[i]; k++) {
                    dp[i + k] = Math.min(dp[i + k], dp[i] + 1);
                }
            }

            return dp[len - 1];
        }
    }

    public int GreedyJump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < A.length - 1) {
            jumps++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (A[i] + i > farthest) {
                    farthest = A[i] + i;
                }
            }
            start = end + 1;
            end = farthest;
        }
        return jumps;
    }
}
