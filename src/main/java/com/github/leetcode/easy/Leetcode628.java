
package com.github.leetcode.easy;

import java.util.Arrays;

/**
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * <p>
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 * Note:
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */
public class Leetcode628 {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            Arrays.sort(nums);
            int len = nums.length;
            if (nums[len - 1] < 0) {
                return nums[len - 1] * nums[len - 2] * nums[len - 3];
            } else {
                int a = nums[len - 1] * nums[len - 2] * nums[len - 3];
                int b = nums[len - 1] * nums[0] * nums[1];
                return a > b ? a : b;
            }

        }
    }
}
