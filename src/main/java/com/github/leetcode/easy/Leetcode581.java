package com.github.leetcode.easy;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 8/31/18 15:47
 * @Description: Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */
public class Leetcode581 {
    public static void main(String[] args) {
        Leetcode581 leetcode581 = new Leetcode581();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        leetcode581.findUnsortedSubarray(nums);
    }

    public int findUnsortedSubarray(int[] nums) {
//        int[] sortNums = new int[nums.length];
//        System.arraycopy(nums, 0, sortNums, 0, nums.length);
//        Arrays.sort(sortNums);
//        int startIndex = 0, endIndex = 0;
//        Boolean isFirstFound = Boolean.FALSE;
//        Boolean isLastFound = Boolean.FALSE;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != sortNums[i]) {
//                if (!isFirstFound) {
//                    startIndex = i;
//                    isFirstFound = Boolean.TRUE;
//                }
//                endIndex = i;
//            }
//        }
//        return endIndex - startIndex + 1;
        int len = nums.length;
        //双向指针
        int left = -1, right = -2;
        //从左往右扫描，找小于左边最大值的数
        int max = nums[0];
        //从右往左扫描，找大于右边最小值的数
        int min = nums[len - 1];
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - 1 - i]);
            if (nums[i] < max) {
                right = i;
            }
            if (nums[len - 1 - i] > min) {
                left = len - 1 - i;
            }
        }
        return right - left + 1;
    }
}
