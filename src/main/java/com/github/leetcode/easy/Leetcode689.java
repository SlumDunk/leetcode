package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/17/18 18:18
 * @Description: Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * <p>
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 * <p>
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 * <p>
 * Example 1:
 * Input:
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 * Example 2:
 * Input:
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * Note:
 * <p>
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 */
public class Leetcode689 {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return -1;
        } else {
            int sum = 0, half = 0;
            for (int i = 0; i < len; i++) {
                sum += nums[i];
            }
            //利用分割点左右两部分相等的特性，所以half*2+nums[pivot]=sum
            for (int i = 0; i < len; i++) {
                if (half * 2 + nums[i] == sum) {
                    return i;
                } else {
                    half += nums[i];
                }
            }
            return -1;
        }
    }

}