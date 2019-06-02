package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/27/19 09:24
 * @Description: Given a sorted array consisting of only integers where every element appears exactly twice except for one element which appears exactly once. Find this single element that appears only once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * <p>
 * <p>
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class Leetcode540 {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1, result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == 0 || mid == nums.length - 1) {
                result = nums[mid];
                break;
            }
            if (nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0) {//在左边
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {//在右边
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else {
                result = nums[mid];
                break;
            }
        }
        return result;
    }
}
