package com.github.leetcode.easy;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class Leetcode35 {
    public int searchInsert(int[] nums, int target) {
        int index = findPosition(0, nums.length - 1, nums, target);
        return index;
    }

    private int findPosition(int left, int right, int[] nums, int target) {
        if (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return findPosition(mid + 1, right, nums, target);
            } else {
                return findPosition(left, mid - 1, nums, target);
            }
        } else {
            if (left == right) {
                if (nums[left] < target) {
                    return left + 1;
                } else {
                    return left;
                }
            } else {
                return left;
            }
        }
    }
}
