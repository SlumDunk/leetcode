package com.github.leetcode.easy;

import java.util.Arrays;

/**
 * In a given integer array nums, there is always exactly one largest element.
 * <p>
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 * <p>
 * If it is, return the index of the largest element, otherwise return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 */
public class Leetcode747 {
    public static void main(String[] args) {
        Leetcode747 leetcode747 = new Leetcode747();
        int[] nums = {1, 0};
        leetcode747.dominantIndex(nums);
    }

    public int dominantIndex(int[] nums) {
        int len = nums.length;
        int max = 0;
        int index = -1;
        if (len < 2) {
            return 0;
        }
        //找出最大值的位置
        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        //排序数组
        Arrays.sort(nums);
        //只要最大的元素大于二倍的次大元素就行
        if (nums[len - 1] >= 2 * nums[len - 2]) {
            return index;
        } else {
            return -1;
        }
    }

}
