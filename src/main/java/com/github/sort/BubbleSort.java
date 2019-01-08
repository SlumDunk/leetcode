package com.github.sort;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 11:18
 * @Description: 冒泡排序
 */
public class BubbleSort {
    /**
     * 两两比较相邻元素，大的元素往后移
     * 在未排序序列中找到最大元素，存放到排序序列的末尾位置
     * 再从剩余未排序元素中继续寻找最大元素
     *
     * @param nums
     */
    public static void sort(int[] nums) {
        int len = nums.length;
        //每次寻找第i大元素
        for (int i = 0; i < len - 1; i++) {
            //每次内层循环结束，数组末尾i+1个数字是有序的
            for (int j = 0; j < len - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * 交换两个位置元素
     *
     * @param indexOne
     * @param indexTwo
     */
    public static void swap(int[] nums, int indexOne, int indexTwo) {
        int temp = nums[indexOne];
        nums[indexOne] = nums[indexTwo];
        nums[indexTwo] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {57, 68, 59, 52};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
