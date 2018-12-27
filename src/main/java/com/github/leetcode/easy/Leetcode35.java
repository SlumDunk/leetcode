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
        int len = nums.length;
        int index = findPosition(nums, 0, len - 1, target);
        return index;
    }

    public int findPosition(int[] nums, int left, int right, int target) {
        //不取=号，保证mid+1不会越界
        if (left < right) {//开始二分查找
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] < target) {
                    return findPosition(nums, mid + 1, right, target);
                } else {
                    return findPosition(nums, left, mid - 1, target);
                }
            }
        } else {//left==right时候，考虑左边界
            if (nums[left] < target) {//target 大于nums[left]
                return left + 1;
            } else {//target小于等于nums[left]
                return left;
            }
        }
    }
}
