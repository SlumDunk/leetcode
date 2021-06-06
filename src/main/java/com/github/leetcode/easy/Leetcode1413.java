package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 13:55
 * @Description: Given an array of integers nums, you start with an initial positive value startValue.
 * <p>
 * In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
 * <p>
 * Return the minimum positive value of startValue such that the step by step sum is never less than 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-3,2,-3,4,2]
 * Output: 5
 * Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
 * step by step sum
 * startValue = 4 | startValue = 5 | nums
 * (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
 * (1 +2 ) = 3  | (2 +2 ) = 4    |   2
 * (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
 * (0 +4 ) = 4  | (1 +4 ) = 5    |   4
 * (4 +2 ) = 6  | (5 +2 ) = 7    |   2
 * Example 2:
 * <p>
 * Input: nums = [1,2]
 * Output: 1
 * Explanation: Minimum start value should be positive.
 * Example 3:
 * <p>
 * Input: nums = [1,-2,-3]
 * Output: 5
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class Leetcode1413 {
    public int minStartValue(int[] nums) {
        int start = 1, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 1) {
                int diff = Math.abs(sum);
                start += diff;
                sum = 0;
            }
        }
        return start;
    }
}
