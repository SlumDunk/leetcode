package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 21:53
 * @Description: Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */
public class Leetcode137 {
    public static void main(String[] args) {
        Leetcode137 leetcode137 = new Leetcode137();
        leetcode137.singleNumber(new int[]{2, 2, 3, 2});
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int number = 0;
        boolean flag = true;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
                i += 2;
            } else {
                if (nums[i] == nums[i + 1]) {
                    number = i + 2;
                } else {
                    number = i;
                }
                flag = false;
                break;
            }
        }
        if(flag){
            number = nums.length-1;
        }
        return nums[number];

    }
}
