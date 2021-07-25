package com.github.leetcode.easy;

/**
 * There is a function signFunc(x) that returns:
 * <p>
 * 1 if x is positive.
 * -1 if x is negative.
 * 0 if x is equal to 0.
 * You are given an integer array nums. Let product be the product of all values in the array nums.
 * <p>
 * Return signFunc(product).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,-2,-3,-4,3,2,1]
 * Output: 1
 * Explanation: The product of all values in the array is 144, and signFunc(144) = 1
 * Example 2:
 * <p>
 * Input: nums = [1,5,0,2,-3]
 * Output: 0
 * Explanation: The product of all values in the array is 0, and signFunc(0) = 0
 * Example 3:
 * <p>
 * Input: nums = [-1,1,-1,1,-1]
 * Output: -1
 * Explanation: The product of all values in the array is -1, and signFunc(-1) = -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * -100 <= nums[i] <= 100
 */
public class Leetcode1822 {
    public int arraySign(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int negativeCnt = 0;
            for (int num :
                    nums) {
                if (num == 0) {
                    return 0;
                } else if (num < 0) {
                    negativeCnt++;
                }
            }

            return negativeCnt % 2 == 0 ? 1 : -1;
        }
    }
}
