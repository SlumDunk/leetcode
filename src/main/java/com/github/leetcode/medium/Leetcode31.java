package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 10/11/18 21:45
 * @Description: Implement children permutation, which rearranges numbers into the lexicographically children greater permutation of numbers.
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
        //从倒数第二位开始，每次从当前位往后找，找一个比自己大的低位，然后置换位置，
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    //并把后面的数字按升序排列
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }
            //保证后面的数字是升序的3,2,1->1,2,3, 保证下次循环能找到大于当前位的最小值
            Arrays.sort(nums, i, nums.length);
        }
    }

    public static void main(String[] args) {
        Leetcode31 leetcode31 = new Leetcode31();
        int[] nums = new int[]{1, 3, 2};
        leetcode31.nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }


    /**
     * O(n^2)
     *
     * @param nums
     */
    public void nextPermutation__(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        //从低位扫到高位
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    Arrays.sort(nums, i + 1, len);
                    return;
                }
            }
            //保证后半部分是递增的
            Arrays.sort(nums, i, len);
        }

    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }


    /**
     * O(n)
     *
     * @param nums
     */
    public void nextPermutation___(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int n = nums.length;
        int i = n - 2;

        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
