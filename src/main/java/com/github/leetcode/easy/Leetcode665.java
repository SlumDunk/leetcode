package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/1/18 17:36
 * @Description: Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 * <p>
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 * <p>
 * Example 1:
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 */
public class Leetcode665 {
    public static void main(String[] args) {
        int[] nums = {4, 2, 1};
        Leetcode665 leetcode665 = new Leetcode665();
        System.out.println(leetcode665.checkPossibility(nums));
    }

    public boolean checkPossibility(int[] nums) {
        Boolean modified = Boolean.FALSE;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] > nums[i + 1]) {
                if (modified) {
                    return false;
                } else {
                    if (i - 1 < 0 || nums[i + 1] > nums[i - 1]) {
                        nums[i] = nums[i + 1];
                    } else {
                        nums[i + 1] = nums[i];
                    }
                    modified=Boolean.TRUE;
                }
            }
        }

        return true;
    }
}
