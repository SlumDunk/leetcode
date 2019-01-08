package com.github.sort;

/**
 * @Author: zerongliu
 * @Date: 1/6/19 19:52
 * @Description: 选择排序
 */
public class SelectionSort {
    /**
     * 选择排序
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素
     *
     * @param nums
     */
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //当前候选第i小元素
            int min = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[min] > nums[j]) {//最小元素的位置需要更新
                    min = j;
                }
                //把第i小元素交换到位置
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {57, 68, 59, 52};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}
