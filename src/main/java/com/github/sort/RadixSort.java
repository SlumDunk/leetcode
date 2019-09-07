package com.github.sort;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 11:53
 * @Description: 基数排序=执行多次的计数排序
 */
public class RadixSort {


    /**
     * 基数排序
     *
     * @param nums
     * @param exp  10的幂次
     */
    static void countSort(int[] nums, int exp) {
        //计数数组
        int[] count = new int[10];

        for (int i = 0; i < nums.length; i++) {
            count[(nums[i] / exp) % 10]++;
        }

        for (int i = 1; i < count.length; i++) {
            //包含了本身
            count[i] += count[i - 1];
        }
        //创建辅助数组
        int[] aux = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            //因为count存储的是<=nums[i]的数量，所以求索引位置得-1
            aux[count[(nums[i] / exp) % 10] - 1] = nums[i];
            count[(nums[i] / exp) % 10]--;
        }

        //拷贝回原数组
        System.arraycopy(aux, 0, nums, 0, aux.length);
    }


    public static void sort(int[] nums) {
        int max = Integer.MIN_VALUE;
        //找出数组中的最大值
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        //每次按位进行计数排序，从低位到高位
        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(nums, exp);
    }

    public static void main(String[] args) {
        int[] nums = {170, 45, 75, 90, 802, 24, 2, 66};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
