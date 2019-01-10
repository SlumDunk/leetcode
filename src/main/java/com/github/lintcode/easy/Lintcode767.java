package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 1/9/19 21:08
 * @Description: Reverse the given array nums inplace.
 * <p>
 * Example
 * Given nums = [1,2,5]
 * return [5,2,1]
 * <p>
 * Notice
 * Inplace means you can't use extra space.
 */
public class Lintcode767 {
    /**
     * @param nums: a integer array
     * @return: nothing
     */
    public void reverseArray(int[] nums) {
        // write your code here
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
