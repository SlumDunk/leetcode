package com.github.leetcode.easy;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * @author liuzhongda
 */
public class Leetcode136 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int singleNumber(int[] nums) {
        //因为只有一个数字出现一次，其他都出现两次，所以进行异或运算
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

}
