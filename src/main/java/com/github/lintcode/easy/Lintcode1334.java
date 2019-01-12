package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 1/10/19 09:50
 * @Description: Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Challenge
 * 1.Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * 2.Could you do it in-place with O(1) extra space?
 */
public class Lintcode1334 {
    /**
     * @param nums: an array
     * @param k:    an integer
     * @return: rotate the array to the right by k steps
     */
    public int[] rotate(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - 1 - k);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
        return nums;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
