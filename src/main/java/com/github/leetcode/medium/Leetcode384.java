package com.github.leetcode.medium;

import java.util.Random;

/**
 * @Author: zerongliu
 * @Date: 11/15/18 19:47
 * @Description: Shuffle a set of numbers without duplicates.
 * <p>
 * Example:
 * <p>
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * <p>
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * <p>
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 * 解题思路：
 * <p>
 * 每次往后读取数组的时候，当读到第i个的时候以1/i的概率随机替换1～i中的任何一个数，这样保证最后每个数字出现在每个位置上的概率都是相等的。
 * <p>
 * 证明：
 * <p>
 * 设x元素在第m次的时候出现在位置i的概率是1/m,那么在第m+1次的时候，x仍然待在位置i的概率是 1/m * m/(m+1) = 1/(m+1)
 */
public class Leetcode384 {
    class Solution {
        private int[] nums = null;
        private Random random = null;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            if (nums == null) return null;
            int[] a = (int[]) nums.clone();
            for (int i = 1; i < nums.length; i++) {
                int j = random.nextInt(i + 1);
                swap(a, i, j);
            }
            return a;
        }

        private void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

    }

}
