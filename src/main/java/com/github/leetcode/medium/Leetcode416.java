package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/23/18 09:37
 * @Description: Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 * <p>
 * Input: [1, 5, 11, 5]
 * <p>
 * Output: true
 * <p>
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * <p>
 * Input: [1, 2, 3, 5]
 * <p>
 * Output: false
 * <p>
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class Leetcode416 {
    public static void main(String[] args) {
        Leetcode416 leetcode416 = new Leetcode416();
        int[] nums = {1, 5, 11, 5};
        leetcode416.canPartition(nums);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        return dp(nums, target);
    }

    private boolean dp(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    if (dp[i - 1][j - nums[i - 1]] == true) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[nums.length][target];
    }

}
