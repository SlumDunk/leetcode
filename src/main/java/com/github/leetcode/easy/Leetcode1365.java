package com.github.leetcode.easy;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 17:17
 * @Description: Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 * <p>
 * Return the answer in an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 * Example 2:
 * <p>
 * Input: nums = [6,5,4,8]
 * Output: [2,1,0,3]
 * Example 3:
 * <p>
 * Input: nums = [7,7,7,7]
 * Output: [0,0,0,0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
public class Leetcode1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counts = new int[101];
        for(int n: nums) {
            counts[n]++;
        }

        int[] lessThan = new int[101];
        int cumulative = 0;
        for(int i = 0 ; i < 101 ; i++) {
            lessThan[i] = cumulative;
            cumulative += counts[i];
        }

        int[] result = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++) {
            result[i] = lessThan[nums[i]];
        }
        return result;
    }
}
