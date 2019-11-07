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
    public static void main(String[] args) {
        Leetcode152 leetcode152 = new Leetcode152();
        int[] nums = {2, -5, -2, -4, 3};
        leetcode152.dpMaxProduct(nums);
    }

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

    public int dpMaxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        //因为存在负负得正，所以必须保存最大值和最小值
        int[][] dp = new int[len + 1][2];
        dp[0][0] = 1;//存放最大值
        dp[0][1] = 1;//存放最小值
        for (int i = 1; i < len + 1; i++) {
            dp[i][0] = nums[i - 1];
            dp[i][1] = nums[i - 1];
        }
        for (int i = 1; i < len + 1; i++) {
            dp[i][0] = Math.max(dp[i][0], Math.max(dp[i - 1][0] * nums[i - 1], dp[i - 1][1] * nums[i - 1]));
            dp[i][1] = Math.min(dp[i][1], Math.min(dp[i - 1][0] * nums[i - 1], dp[i - 1][1] * nums[i - 1]));
            max = Math.max(dp[i][0], max);
        }

        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.printf(dp[i][j] + " ");
            }
            System.out.println();
        }
        return max;
    }

    /**
     * O(N)
     * @param nums
     * @return
     */
    public int maxProduct__(int[] nums) {
        int n = nums.length;
        //以元素nums[i]结尾的最大乘积和最小乘积
        int[][] dp = new int[n][2];

        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        int max = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i][1] = nums[i];

            if (nums[i] > 0) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][0] * nums[i]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] * nums[i]);
            } else if (nums[i] < 0) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] * nums[i]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] * nums[i]);
            }

            max = Math.max(max, dp[i][0]);
        }

        return max;

    }
}
