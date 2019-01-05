package com.github.leetcode.hard;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 1/4/19 21:08
 * @Description: Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space
 */
public class Leetcode41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        //候选缺失对象
        int positive = 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == positive) {
                positive = nums[i] + 1;
            }
        }
        return positive;
    }
}
