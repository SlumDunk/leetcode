package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/13/18 11:13
 * @Description: Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class Leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        int mid = binarySearch(nums, target, 0, nums.length - 1);
        int left = mid;
        int left_temp = binarySearch(nums, target, 0, mid - 1);
        while (left_temp != -1) {
            left = left_temp;
            left_temp = binarySearch(nums, target, 0, left_temp - 1);
        }
        int right = mid;
        int right_temp = binarySearch(nums, target, mid + 1, nums.length - 1);
        while (right_temp != -1) {
            right = right_temp;
            right_temp = binarySearch(nums, target, right_temp + 1, nums.length - 1);
        }

        int[] result = {left, right};
        return result;
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        // TODO Auto-generated method stub
        if (left > right)
            return -1;
        if (left == right) {
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }
        int mid = (left + right) / 2;
        if (target < nums[mid]) {
            return binarySearch(nums, target, left, mid);
        } else if (target == nums[mid]) {
            return mid;
        } else {
            return binarySearch(nums, target, mid + 1, right);
        }
    }
}
