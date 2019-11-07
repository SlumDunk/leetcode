package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 10/28/18 10:54
 * @Description: Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * Example 2:
 * <p>
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 * <p>
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class Leetcode324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] nums_copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums_copy[i] = nums[i];
        }
        //中间位置和末尾位置,数组分成前后两段，分别从各段末尾往前走
        int p = (nums.length - 1) / 2, q = nums.length - 1;

        for (int i = 0, j = 1; i < nums.length; i += 2, j += 2) {
            nums[i] = nums_copy[p--];
            if (j < nums.length) nums[j] = nums_copy[q--];
        }
    }

    public void wiggleSort__(int[] nums) {
        Arrays.sort(nums);
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);

        int p = (nums.length - 1) / 2, q = nums.length - 1;

        for (int i = 0, j = 1; i < nums.length; i += 2, j += 2) {
            nums[i] = copy[p--];
            if (j < nums.length) {
                nums[j] = copy[q--];
            }
        }
    }
}
