package com.github.sort;

/**
 * @Author: zerongliu
 * @Date: 1/6/19 20:18
 * @Description: 希尔排序
 */
public class ShellSort {
    public static void sort(int[] nums) {
        //跳跃因子
        int h = 1;
        while (h * 3 < nums.length) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            //改进的插入排序
            for (int i = h; i < nums.length; i++) {
                for (int j = i; j >= h && nums[j - h] > nums[j]; j -= h) {
                    int temp = nums[j];
                    nums[j] = nums[j - h];
                    nums[j - h] = temp;
                }
            }
            h /= 3;
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
