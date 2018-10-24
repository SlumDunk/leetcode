package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 10/11/18 21:45
 * @Description: Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <p>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Leetcode31 {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            //寻找可以替换的最低位
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    //确保替换位的后续位的值最小
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }
            //若当前位不可替换，则自当前位开始排序，以保证下一位可以在不进行完整遍历的前提下找到最小的更大值
            Arrays.sort(nums, i, nums.length);
        }
    }
}
