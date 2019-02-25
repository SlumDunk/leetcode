package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 2/22/19 05:57
 * @Description: Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
 * <p>
 * Example 1:
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * Example 2:
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 * Note:
 * The length of the array won't exceed 10,000.
 * You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
public class Leetcode523 {
    public static void main(String[] args) {
        Leetcode523 leetcode523 = new Leetcode523();
        int[] nums = {0, 1, 0};
        int k = 0;
        leetcode523.checkSubarraySum(nums, k);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        //连续和subsum 为k的倍数
        if (nums == null || nums.length < 2) {
            return false;
        } else {
            int len = nums.length;
            int[] presum = new int[len];
            init(presum, nums, len);
            //nums[i....j]的和是否为k的倍数
            boolean[][] dp = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = false;

            }

            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if ((k == 0 && subSum(presum, i, j, nums) == 0) || (k != 0 &&
                            subSum(presum, i, j, nums) % k == 0)) {
                        //dp[i][j] = true;
                        return true;
                    }
                    dp[i][j] = dp[i][j - 1] || dp[i][j];
                }
            }
            boolean result = false;
            for (int i = 0; i < len; i++) {
                result = result || dp[i][len - 1];
            }
            return result;
        }
    }

    private void init(int[] presum, int[] nums, int len) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            presum[i] = sum;
        }
    }

    /**
     * get the sub sum of nums from i to j
     *
     * @param presum
     * @param i
     * @param j
     * @param nums
     * @return
     */
    private int subSum(int[] presum, int i, int j, int[] nums) {
        return presum[j] - presum[i] + nums[i];
    }
}
