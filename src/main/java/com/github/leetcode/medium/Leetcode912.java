package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/24/19 21:25
 * @Description: Given an array of integers nums, sort the array in ascending order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [5,2,3,1]
 * Output: [1,2,3,5]
 * Example 2:
 * <p>
 * Input: [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 10000
 * -50000 <= A[i] <= 50000
 */
public class Leetcode912 {
    public int[] sortArray(int[] nums) {
        if (nums == null) return null;
        sortArray(nums, 0, nums.length);
        return nums;
    }

    private void sortArray(int[] nums, int start, int end) {
        if (end - start <= 1) return;
        int mid = start + (end - start) / 2;
        sortArray(nums, start, mid);
        sortArray(nums, mid, end);
        merge(nums, start, mid, end);
    }

    /**
     * 归并
     * @param nums
     * @param start
     * @param mid
     * @param end
     */
    private void merge(int[] nums, int start, int mid, int end) {
        int[] res = new int[end - start];
        // perform merge
        int idxLeft = start, idxRight = mid, idxRes = 0;
        while (idxLeft < mid && idxRight < end) {
            if (nums[idxLeft] < nums[idxRight]) {
                res[idxRes] = nums[idxLeft];
                idxLeft++;
            } else {
                res[idxRes] = nums[idxRight];
                idxRight++;
            }
            idxRes++;
        }
        if (idxLeft < mid) {
            System.arraycopy(nums, idxLeft, res, idxRes, mid - idxLeft);
        }
        if (idxRight < end) {
            System.arraycopy(nums, idxRight, res, idxRes, end - idxRight);
        }

        // copy back to nums
        for (int i = 0; i < end - start; i++) {
            nums[i + start] = res[i];
        }
    }
}
