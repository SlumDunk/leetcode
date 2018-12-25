package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/15/18 20:47
 * @Description: Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        //把0放在连续的子串里头，并存储子串的长度，当做一个整体移动，滚雪球
        int lengthOfZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                lengthOfZero++;
            } else {//把非0的交换到0子串前面
                if (lengthOfZero > 0) {
                    int temp = nums[i];
                    nums[i] = 0;
                    nums[i - lengthOfZero] = temp;
                }
            }
        }
    }
}
