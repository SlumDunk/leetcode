package com.github.leetcode.easy;

import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class Leetcode268 {

    public int missingNumber(int[] nums) {
        //异或运算 注意数组长度和取值范围的关系
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
        //return getMissingNumber(nums);


    }

    private int getMissingNumber(int[] nums) {
        //等差数列求和公式
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int n = nums.length;
        return (n * (n + 1)) / 2 - sum;
    }
}
