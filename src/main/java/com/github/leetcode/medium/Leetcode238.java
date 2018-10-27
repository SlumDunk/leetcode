package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 16:23
 * @Description: Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class Leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[res.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] = res[i + 1] * nums[i + 1];
        }

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] *= left;
            left *= nums[i];
        }
        return res;
    }

}
