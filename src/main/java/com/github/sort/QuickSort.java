package com.github.sort;

/**
 * @Author: zerongliu
 * @Date: 1/7/19 21:46
 * @Description: 快速排序
 */
public class QuickSort {
    public void sort(int[] nums) {
        sortInternal(nums, 0, nums.length - 1);
    }

    /**
     * @param nums
     * @param left
     * @param right
     */
    private void sortInternal(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        //中间作为pivot
        //int pivot = (right - left) / 2 + left;
        //寻找出划分的位置
        //pivot = partition(nums, left, right, nums[pivot]);
        int pivot = partition(nums, left, right);
        sortInternal(nums, left, pivot - 1);
        sortInternal(nums, pivot + 1, right);
    }

    /**
     * @param nums
     * @param left
     * @param right
     * @param pivot 关键元素
     * @return
     */
    private int partition(int[] nums, int left, int right, int pivot) {
        while (left <= right) {
            while (nums[left] < pivot) {
                left++;
            }
            while (nums[right] > pivot) {
                right--;
            }
            //不存在指针越界的情况
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    /**
     * 交换两个位置元素
     *
     * @param nums
     * @param left
     * @param right
     */
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /**
     * 固定以最右边元素为关键元素
     * 45 46 47 50 48
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        //pivot目标位置的前一位置
        int i = left - 1;
        for (int j = left; j < right; j++) {
            //交换到前面
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {57, 68, 59, 52};
        new QuickSort().sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
