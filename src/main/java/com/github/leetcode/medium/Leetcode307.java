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
        /**
         * 树状数组
         */
        int[] bitArr;
        /**
         * 数组元素
         */
        int[] nums;
        /**
         * 数组长度
         */
        int length;

        public NumArray(int[] nums) {
            length = nums.length;
            bitArr = new int[length + 1];
            this.nums = nums;

            //初始化树状数组
            //填坑法，填充每个空，长度是2的幂次
            for (int i = 1; i <= length; i++) {
                int sum = 0;
                int count = 1;
                //0001 0010 0011 0100 0101 0110 0111 1000
                //1,2,1,4,1,2,1,8
                int counter = lowBit(i);

                while (count <= counter) {
                    sum += nums[i - count];
                    count++;
                }
                //存储数组范围[i-counter,i-1]的数的和
                bitArr[i] = sum;
            }
        }

        /**
         * 更新数组某个位置元素的值
         *
         * @param index 元素位置
         * @param val   元素值
         */
        void update(int index, int val) {
            //更新树状数组
            int gap = val - nums[index];
            //先更新数组
            nums[index] = val;
            index++;
            //从前往后走
            while (index <= length) {
                bitArr[index] += gap;
                index += lowBit(index);
            }
        }

        /**
         * 返回[i,j]范围内的元素的和
         *
         * @param lower 下边界
         * @param upper 上边界
         * @return
         */
        public int sumRange(int lower, int upper) {
            return sum(upper + 1) - sum(lower);
        }

        /**
         * 返回[0,index-1]元素的和
         *
         * @param index
         * @return
         */
        private int sum(int index) {
            int sum = 0;
            //从后往前走
            while (index > 0) {
                sum += bitArr[index];
                index -= lowBit(index);
            }
            return sum;
        }

        /**
         * 返回最低位的1
         *
         * @param index
         * @return
         */
        private int lowBit(int index) {
            //负数的二进制表示方法是符号位不变，正数按位取反加1
            return index & (-index);
        }
    }
}
