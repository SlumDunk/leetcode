package com.github.sort;

/**
 * @Author: zerongliu
 * @Date: 1/6/19 20:06
 * @Description: 插入排序
 */
public class InsertionSort {
    /**
     * 找到合适的位置，然后插入当前处理的元素
     *
     * @param nums
     */
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //每次走完循环都保证nums[0...i]是有序的 从后往前扫
            for (int j = i; j >= 1 && nums[j] < nums[j - 1]; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
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
