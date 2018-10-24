package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 09:24
 * @Description: Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 * <p>
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class Leetcode81 {
    public static void main(String[] args) {
        Leetcode81 leetcode81 = new Leetcode81();
        System.out.println(leetcode81.search(new int[]{3, 1, 1}, 3));
    }

    public boolean search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == target) return true;
            if (nums[m] == nums[i]) i++;   //"duplicate", jump
            else if (nums[m] > nums[i]) {
                if (nums[m] > target && nums[i] <= target) j = m - 1;
                else i = m + 1;
            } else {
                if (nums[m] < target && nums[j] >= target) i = m + 1;
                else j = m - 1;
            }
        }
        return false;
    }
}
