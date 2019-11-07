package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 10/11/19 22:34
 * @Description: For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
 * <p>
 * If the target number does not exist in the array, return -1.
 * <p>
 * Example
 * Example 1:
 * Input:  [1,4,4,5,7,7,8,9,9,10]，1
 * Output: 0
 * <p>
 * Explanation:
 * the first index of  1 is 0.
 * <p>
 * Example 2:
 * Input: [1, 2, 3, 3, 4, 5, 10]，3
 * Output: 2
 * <p>
 * Explanation:
 * the first index of 3 is 2.
 * <p>
 * Example 3:
 * Input: [1, 2, 3, 3, 4, 5, 10]，6
 * Output: -1
 * <p>
 * Explanation:
 * Not exist 6 in array.
 * <p>
 * Challenge
 * If the count of numbers is bigger than 2^32, can your code work properly?
 */
public class Lintcode14 {
    /**
     * @param nums:   The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        int n = nums.length;
        int start = 0, end = n - 1;
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
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
