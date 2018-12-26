package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/24/18 17:48
 * @Description: Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class Leetcode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //创建一个暂存数组
        int[] nums = new int[nums1.length];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] <= nums2[index2]) {
                nums[index] = nums1[index1];
                index1++;
            } else {
                nums[index] = nums2[index2];
                index2++;
            }
            index++;
        }
        //第一个数组没走完
        while (index1 < m) {
            nums[index++] = nums1[index1++];
        }
        //第二个数组没走完
        while (index2 < n) {
            nums[index++] = nums2[index2++];
        }
        //将暂存数组中的数字复制到nums1数组
        System.arraycopy(nums, 0, nums1, 0, nums.length);
    }
}
