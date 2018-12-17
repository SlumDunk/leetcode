package com.github.leetcode.easy;

/**
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 * <p>
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * Note:
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 */
public class Leetcode643 {
    public double findMaxAverage(int[] nums, int k) {
        //使用滑动窗口
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < k; i++) {//先填充大小为k的窗口
            sum += nums[i];
        }
        double max = sum;
        for (int i = k; i < len; i++) {
            sum += nums[i] - nums[i - k];//向前滑动,新窗口
            max = Math.max(max, sum);
        }
        return max / k;
    }
}
