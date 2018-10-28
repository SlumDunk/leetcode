package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/27/18 14:09
 * @Description: Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * <p>
 * Example:
 * <p>
 * Given nums = [1, 3, 5]
 * <p>
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * <p>
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class Leetcode307 {

    public static void main(String[] args) {
        Leetcode307.NumArray leetcode307 = new Leetcode307.NumArray(new int[]{1, 3, 5});
    }

    public static class NumArray {
        int[] processed;
        int[] nums;
        int length;

        public NumArray(int[] nums) {
            length = nums.length;
            processed = new int[length + 1];
            this.nums = nums;

            //init processed
            for (int i = 1; i <= length; i++) {
                int sum = 0;
                int count = 1;
                int counter = lowBit(i);

                while (count <= counter) {
                    sum += nums[i - count];
                    count++;
                }
                processed[i] = sum;
            }
        }

        void update(int i, int val) {
            //更新树状数组
            int gap = val - nums[i];
            nums[i] = val;

            int index = i + 1;
            while (index <= length) {
                processed[index] += gap;
                index += lowBit(index);
            }
        }

        public int sumRange(int i, int j) {
            return sum(j + 1) - sum(i);
        }

        private int sum(int index) {
            int sum = 0;
            while (index > 0) {
                sum += processed[index];
                index -= lowBit(index);
            }
            return sum;
        }

        private int lowBit(int index) {
            //return index & (-index);
            return ((index - 1) ^ index) & index;
        }
    }
}
