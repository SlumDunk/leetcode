package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 1/9/19 13:36
 * @Description: Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * The array may contain duplicates.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [2,2,2,0,1]
 * Output: 0
 * Note:
 * <p>
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 */
public class Leetcode154 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == nums[right]) {
                right--;
            } else if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] <= nums[right]) {
            return nums[left];
        } else {
            return nums[right];
        }
    }


    /**                 /|
     *                 / |
     *                /  |
     * --------------    |   --------------------
     *                   |  /
     *                   | /
     *                   |/
     * @param nums
     * @return
     */
    public int findMin__(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == nums[end]) {
                end--;
            } else if (nums[mid] >= nums[start] && nums[mid] > nums[end]) {
                start = mid;
            } else if (nums[mid] < nums[start] && nums[mid] < nums[end]) {
                end = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] <= nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}
