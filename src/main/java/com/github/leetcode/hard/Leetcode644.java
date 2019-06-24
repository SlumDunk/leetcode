package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/7/19 22:52
 * @Description: Given an array consisting of n integers, find the contiguous subarray whose length is greater than or equal to k that has the maximum average value. And you need to output the maximum average value.
 * <p>
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation:
 * when length is 5, maximum average value is 10.8,
 * when length is 6, maximum average value is 9.16667.
 * Thus return 12.75.
 * Note:
 * 1 <= k <= n <= 10,000.
 * Elements of the given array will be in range [-10,000, 10,000].
 * The answer with the calculation error less than 10-5 will be accepted.
 */
public class Leetcode644 {

    public double findMaxAverage(int[] nums, int k) {
        double l = -10001, r = 100001;
        while (l + 0.00001 < r) {
            double m = l + (r - l) / 2;
            if (canFindLargerAverage(nums, k, m)) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }

    /**
     * @param nums
     * @param k
     * @param x    预测平均值
     * @return
     */
    private boolean canFindLargerAverage(int[] nums, int k, double x) {
        int n = nums.length;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i] - x;
        }
        double cur = 0, prev = 0;
        for (int i = 0; i < k; i++) {
            cur += a[i];
        }
        if (cur >= 0) {
            return true;
        }
        for (int i = k; i < n; i++) {
            cur += a[i];
            prev += a[i - k];
            if (prev < 0) {
                cur -= prev;
                prev = 0;
            }
            if (cur >= 0) {
                return true;
            }
        }
        return false;
    }
}
