package com.github.sort;

/**
 * @Author: zerongliu
 * @Date: 1/7/19 09:30
 * @Description: 归并排序
 */
public class MergeSort {

    /**
     * 辅助数组
     */
    private int[] aux;

    /**
     * @param nums
     */
    public void sort(int[] nums) {
        aux = new int[nums.length];
        sortInternal(nums, 0, nums.length - 1);
        //释放内存
        aux = null;
    }

    /**
     * @param nums
     * @param left
     * @param right
     */
    public void sortInternal(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        sortInternal(nums, left, mid);
        sortInternal(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    /**
     * 合并[left,mid],[mid+1,right]
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     */
    public void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            aux[k] = nums[k];
        }

        for (int k = left; k <= right; k++) {
            if (i > mid) {//右半部分是有剩余元素
                nums[k] = aux[j++];
            } else if (j > right) {//左半部分是否有剩余元素
                nums[k] = aux[i++];
            } else if (aux[j] < aux[i]) {//正常情况 比较大小
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {57, 68, 59, 52};
        new MergeSort().sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}
