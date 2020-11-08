package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/11/18 22:04
 * @Description: Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target frequency to search. If found in the array return its index, otherwise return -1.
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
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] < nums[mid]) {//左边有序
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {//右边有序
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }


    public int search__(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        int start = 0, end = n - 1;
        int mid = 0;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            //先判断当前mid位于哪一段
            if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
                if (nums[mid] >= target && nums[start] <= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < nums[start] && nums[mid] < nums[end]) {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                if (nums[mid] > target) {
                    end = mid;
                } else if (nums[mid] < target) {
                    start = mid;
                } else {
                    return mid;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
    }

    /**
     * O(lgN)
     * @param nums
     * @param target
     * @return
     */
    public int search___(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }

        int start = 0, end = n - 1;
        int mid = 0;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            //[start....end]是否有序
            if (nums[mid] > nums[start] && nums[mid] < nums[end]) {//有序数组二分查找
                if (nums[mid] > target) {
                    end = mid;
                } else if (nums[mid] < target) {
                    start = mid;
                } else {
                    return mid;
                }
            } else {//[start....end]部分有序
                //peak点左侧
                if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
                    //[start..mid] 有序
                    if (nums[mid] >= target && nums[start] <= target) {
                        end = mid;
                    } else {
                        start = mid;
                    }
                } else {//peak点右侧
                    if (nums[mid] <= target && nums[end] >= target) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                }
            }

        }

        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
}
