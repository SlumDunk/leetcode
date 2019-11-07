package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 08:18
 * @Description: Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * <p>
 * Example:
 * <p>
 * Input: nums = [3,5,2,1,6,4]
 * Output: One possible answer is [3,5,1,6,2,4]
 */
public class Leetcode280 {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1 && nums[i] < nums[i - 1] || i % 2 == 0 && nums[i] > nums[i - 1]) {
                int temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public void wiggleSort__(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1) {//偶数位置
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            } else {//奇数位置
                if (nums[i] > nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx2];
        nums[idx2] = nums[idx1];
        nums[idx1] = temp;
    }
}
