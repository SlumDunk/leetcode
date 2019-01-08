package com.github.sort;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 09:46
 * @Description: 计数排序
 */
public class CountSort {
    /**
     * 计数排序是稳定排序，因为排序后重复数字相对位置不变
     *
     * @param nums 要排序的数组
     * @param k    数组中元素的取值范围
     */
    public static int[] sort(int[] nums, int k) {
        //创建一个辅助数组
        int[] count = new int[k + 1];
        for (int i = 0; i < nums.length; i++) {
            //存储数组中各个元素的个数
            count[nums[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        //辅助数组
        int[] aux = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            //将原数组元素放置在排序后数组元素的位置 注意需要-1，因为数组的位置是从0开始的
            aux[count[nums[i]] - 1] = nums[i];
            //下一个相同元素要放置的位置
            count[nums[i]]--;
        }
        return aux;
    }

    public static void main(String[] args) {
        int[] nums = {57, 68, 59, 52};
        int[] result = sort(nums, 100);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
