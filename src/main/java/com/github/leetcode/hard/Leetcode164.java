package com.github.leetcode.hard;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 3/4/19 09:47
 * @Description: Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * <p>
 * Return 0 if the array contains less than 2 elements.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either
 * (3,6) or (6,9) has the maximum difference 3.
 * Example 2:
 * <p>
 * Input: [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 * Note:
 * <p>
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * Try to solve it in linear time/space.
 */
public class Leetcode164 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        } else {
            Arrays.sort(nums);
            int len = nums.length;
            int maxGap = 0;
            for (int i = 1; i < len; i++) {
                maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
            }

            return maxGap;
        }
    }
}
