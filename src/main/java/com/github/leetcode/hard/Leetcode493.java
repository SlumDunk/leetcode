package com.github.leetcode.hard;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 5/10/19 22:57
 * @Description: Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 * <p>
 * You need to return the number of important reverse pairs in the given array.
 * <p>
 * Example1:
 * <p>
 * Input: [1,3,2,3,1]
 * Output: 2
 * Example2:
 * <p>
 * Input: [2,4,3,5,1]
 * Output: 3
 * Note:
 * The length of the given array will not exceed 50,000.
 * All the numbers in the input array are in the range of 32-bit integer.
 */
public class Leetcode493 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int s, int e) {
        if (s >= e) return 0;
        int mid = s + (e - s) / 2;
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e);
        for (int i = s, j = mid + 1; i <= mid; i++) {
            while (j <= e && nums[i] / 2.0 > nums[j]) j++;
            cnt += j - (mid + 1);
        }
        Arrays.sort(nums, s, e + 1);
        return cnt;
    }
}
