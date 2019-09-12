package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/11/19 11:19
 * @Description: Given an array nums sorted in non-decreasing order, and a number target, return True if and only if target is a majority element.
 * <p>
 * A majority element is an element that appears more than N/2 times in an array of length N.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
 * Output: true
 * Explanation:
 * The value 5 appears 5 times and the length of the array is 9.
 * Thus, 5 is a majority element because 5 > 9/2 is true.
 * Example 2:
 * <p>
 * Input: nums = [10,100,101,101], target = 101
 * Output: false
 * Explanation:
 * The value 101 appears 2 times and the length of the array is 4.
 * Thus, 101 is not a majority element because 2 > 4/2 is false.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^9
 * 1 <= target <= 10^9
 */
public class Leetcode1150 {
    public boolean isMajorityElement(int[] nums, int target) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                count++;
            }
            if (count > len / 2) {
                return true;
            }
        }
        return false;
    }
}
