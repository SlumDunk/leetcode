package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 10/13/18 11:13
 * @Description: Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target frequency.
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
        int left = mid - 1, right = mid + 1;
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        while (right >= 0 && right < nums.length && nums[right] == target) {
            right++;
        }

        int[] result = {++left, --right};
        return result;
    }

    /**
     * 二分查找
     *
     * @param nums   集合
     * @param target 查找对象
     * @param left   左边界
     * @param right  右边界
     * @return
     */
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
            return binarySearch(nums, target, left, mid - 1);
        } else if (target == nums[mid]) {
            return mid;
        } else {
            return binarySearch(nums, target, mid + 1, right);
        }
    }


    public int[] searchRange__(int[] nums, int target) {
        int n = nums.length;

        int[] ans = new int[2];
        Arrays.fill(ans, -1);

        if (n == 0) {
            return ans;
        }
        int start = 0, end = n - 1;
        int mid = 0;

        //寻找第一个出现的位置
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] == target) {
            ans[0] = start;
        } else if (nums[end] == target) {
            ans[0] = end;
        }

        //寻找最后一次出现的位置
        start = 0;
        end = n - 1;
        mid = 0;

        //寻找最后一个出现的位置
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[end] == target) {
            ans[1] = end;
        } else if (nums[start] == target) {
            ans[1] = start;
        }
        return ans;
    }
}
