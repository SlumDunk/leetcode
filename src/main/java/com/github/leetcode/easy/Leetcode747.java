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
        int[] oldnum = new int[nums.length];
        System.arraycopy(nums, 0, oldnum, 0, nums.length);
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int len = nums.length;
        if (len >= 2) {
            if (nums[len - 1] >= 2 * nums[len - 2]) {
                for (int i = 0; i < oldnum.length; i++) {
                    if (oldnum[i] == nums[len - 1]) {
                        return i;
                    }
                }
            }
        } else {
            return 0;
        }
        return -1;
    }

}
