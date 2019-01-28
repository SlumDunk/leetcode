package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 16:57
 * @Description: Given an array with integers.
 * <p>
 * Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.
 * <p>
 * Return the largest difference.
 * <p>
 * Example
 * For [1, 2, -3, 1], return 6.
 * <p>
 * Challenge
 * O(n) time and O(n) space.
 * <p>
 * Notice
 * The subarray should contain at least one number
 */
public class Lintcode45 {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int len = nums.length;
            int[] left_max = new int[len];
            int[] left_min = new int[len];
            int[] right_max = new int[len];
            int[] right_min = new int[len];
            int[] copy = new int[len];

            for (int i = 0; i < len; i++) {
                copy[i] = -1 * nums[i];
            }
            int max = Integer.MIN_VALUE;
            int sum = 0;
            int minSum = 0;
            for (int i = 0; i < len; i++) {
                sum += nums[i];
                max = Math.max(max, sum - minSum);
                minSum = Math.min(sum, minSum);
                left_max[i] = max;
            }

            sum = 0;
            max = Integer.MIN_VALUE;
            minSum = 0;
            for (int i = len - 1; i >= 0; i--) {
                sum += nums[i];
                max = Math.max(max, sum - minSum);
                minSum = Math.min(sum, minSum);
                right_max[i] = max;
            }


            sum = 0;
            max = Integer.MIN_VALUE;
            minSum = 0;
            for (int i = 0; i < len; i++) {
                sum += copy[i];
                max = Math.max(max, sum - minSum);
                minSum = Math.min(sum, minSum);
                left_min[i] = -1 * max;
            }

            sum = 0;
            max = Integer.MIN_VALUE;
            minSum = 0;
            for (int i = len - 1; i >= 0; i--) {
                sum += copy[i];
                max = Math.max(max, sum - minSum);
                minSum = Math.min(sum, minSum);
                right_min[i] = -1 * max;
            }
            int diff = 0;
            for (int i = 0; i < len - 1; i++) {
                diff = Math.max(diff, Math.abs(left_max[i] - right_min[i + 1]));
                diff = Math.max(diff, Math.abs(right_max[i + 1] - left_min[i]));
            }
            return diff;
        }
    }
}
