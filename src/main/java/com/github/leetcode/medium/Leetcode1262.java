package com.github.leetcode.medium;

/**
 * Given an array nums of integers, we need to find the maximum possible sum of elements of the array such that it is divisible by three.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,6,5,1,8]
 * Output: 18
 * Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
 * Example 2:
 * <p>
 * Input: nums = [4]
 * Output: 0
 * Explanation: Since 4 is not divisible by 3, do not pick any number.
 * Example 3:
 * <p>
 * Input: nums = [1,2,3,4,4]
 * Output: 12
 * Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 */
public class Leetcode1262 {
    int max = 0;

    public int maxSumDivThree(int[] nums) {
        helper(nums, 0, 0);
        return max;
    }

    /**
     * 超时
     *
     * @param nums
     * @param index
     * @param preSum
     */
    private void helper(int[] nums, int index, int preSum) {
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            // 取
            preSum += nums[i];
            helper(nums, i + 1, preSum);
            if (preSum % 3 == 0) {
                max = Math.max(max, preSum);
            }
            // 不取
            preSum -= nums[i];
        }
    }

    public int maxSumDivThreeDP(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][nums[i] % 3] = nums[i];
            }else{
                for (int j = 0; j < 3; j++) {
                    // 取 nums[i]
                    int sum=dp[i-1][j]+nums[i];
                    dp[i][sum%3]=Math.max(dp[i][sum%3],sum);
                    // 不取 nums[i]
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
                }
            }
        }
        return dp[n-1][0];
    }
}
