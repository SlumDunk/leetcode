package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/11/18 22:04
 * @Description: Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class Leetcode33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        //改进的二分查找
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        if (left == right) {
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }
        int mid = (left + right) / 2;
        if (nums[mid] > nums[left]) {//(left..mid)是完全有序的
            if (nums[left] <= target && nums[mid] >= target) {
                return binarySearch(nums, target, left, mid);
            } else {
                return search(nums, target, mid + 1, right);
            }
        } else {//(mid+1..right)是完全有序的
            if (nums[mid + 1] <= target && target <= nums[right]) {
                return binarySearch(nums, target, mid + 1, right);
            } else {
                return search(nums, target, left, mid);
            }
        }
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }
        int mid = (left + right) / 2;
        if (target < nums[mid]) {
            return binarySearch(nums, target, left, mid - 1);
        } else if (target == nums[mid]) {
            return mid;
        } else {
            return binarySearch(nums, target, mid + 1, right);
        }
    }

}
