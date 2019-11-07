package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 09:38
 * @Description: Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class Leetcode153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        //画出图形 找左边第一个比target小的
        int target = nums[nums.length - 1];
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] <= target) {
            return nums[left];
        } else {
            return nums[right];
        }
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public int binarySearch(int[] nums, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            //最小值只可能出现在3个位置，中间点，中间点左侧，中间点右侧
            return Math.min(nums[mid], Math.min(binarySearch(nums, start, mid - 1), binarySearch(nums, mid + 1, end)));
        } else {
            return Integer.MAX_VALUE;
        }
    }


    public int findMin__(int[] nums) {
        //分割点的左右两部分各自递增
        int n = nums.length;
        int start = 0, end = n - 1;
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
                start = mid;
            } else if (nums[mid] < nums[start] && nums[mid] < nums[end]) {
                end = mid;
            } else {//正常顺序
                end = mid;
            }
        }

        if (nums[start] < nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}
