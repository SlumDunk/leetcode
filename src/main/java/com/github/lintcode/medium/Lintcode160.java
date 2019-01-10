package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/9/19 13:45
 * @Description: Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * Example
 * Given [4,4,5,6,7,0,1,2] return 0.
 * <p>
 * Notice
 * The array may contain duplicates.
 */
public class Lintcode160 {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
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
}
