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
        int pivot = partition(nums, left, right);
        sortInternal(nums, left, pivot - 1);
        sortInternal(nums, pivot + 1, right);
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
     * <p>
     * 45 46 47 50 49 47 51 48
     * * #
     * 47 49 50 51 48
     * *
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        //pivot目标位置的前一位置
        // Index of smaller element
        int i = left - 1;
        for (int j = left; j < right; j++) {
            //交换到前面 只track小于等于pivot值的，统一提到前面，大的就位置无所谓
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }


    public void sort(int[] nums, int left, int right) {
        if (left < right) {
            int pi = partition_(nums, left, right);
            sort(nums, left, pi - 1);
            sort(nums, pi + 1, right);
        }
    }

    private int partition_(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {45, 46, 47, 50, 49, 47, 51, 48};
        new QuickSort().sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
