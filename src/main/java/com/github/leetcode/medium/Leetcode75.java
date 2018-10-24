package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 20:48
 * @Description: Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class Leetcode75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        // 0的个数
        int i = 0;
        // 1的个数
        int j = 0;
        // 2的个数
        int k = 0;
        for (int p = 0; p < n; p++) {
            if (nums[p] == 0) {
                i++;
            } else if (nums[p] == 1) {
                j++;
            } else
                k++;
        }

        for (int p = 0; p < n; p++) {
            if (p < i)
                nums[p] = 0;
            else if (p >= i && p < i + j)
                nums[p] = 1;
            else
                nums[p] = 2;
        }

    }
}
