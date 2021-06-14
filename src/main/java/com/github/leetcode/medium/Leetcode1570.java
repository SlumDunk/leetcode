package com.github.leetcode.medium;

public class Leetcode1570 {
    class SparseVector {
        private int[] nums;

        SparseVector(int[] nums) {
            this.nums = nums;
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            if (vec == null || this.nums == null || vec.nums == null ||
                    this.nums.length == 0 || vec.nums.length == 0) {
                return 0;
            }
            if (this.nums.length != vec.nums.length) {
                return 0;
            } else {
                int sum = 0;
                for (int i = 0; i < this.nums.length; i++) {
                    sum += (this.nums[i] * vec.nums[i]);
                }
                return sum;
            }
        }
    }
}
