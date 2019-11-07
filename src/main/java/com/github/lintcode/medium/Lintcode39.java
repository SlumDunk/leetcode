package com.github.lintcode.medium;

import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/9/19 15:30
 * @Description: Given a rotated sorted array, recover it to sorted array in-place.
 * <p>
 * Example
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 * <p>
 * Challenge
 * In-place, O(1) extra space and O(n) time.
 * <p>
 * Clarification
 * What is rotated array?
 * <p>
 * For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 */
public class Lintcode39 {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        //三步翻转法
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                //翻转前半部分
                reverse(nums, 0, i);
                //翻转后半部分
                reverse(nums, i + 1, nums.size() - 1);
                //翻转整个
                reverse(nums, 0, nums.size() - 1);
            }
        }
    }

    /**
     * @param nums
     * @param start
     * @param end
     */
    public void reverse(List<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(end);
            nums.set(end, nums.get(start));
            nums.set(start, temp);
            start++;
            end--;
        }
    }


    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray__(List<Integer> nums) {
        // write your code here
        int n = nums.size();
        int index = -1;
        //先找到rotate的位置
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                index = i;
            }
        }

        if (index == -1) {
            return;
        }

        //翻转左半部分
        int start = 0, end = index;
        Integer temp;
        while (start < end) {
            temp = nums.get(end);
            nums.set(end, nums.get(start));
            nums.set(start, temp);
            start++;
            end--;
        }

        //翻转右半部分
        start = index + 1;
        end = n - 1;
        while (start < end) {
            temp = nums.get(end);
            nums.set(end, nums.get(start));
            nums.set(start, temp);
            start++;
            end--;
        }


        //翻转整个串
        start = 0;
        end = n - 1;
        while (start < end) {
            temp = nums.get(end);
            nums.set(end, nums.get(start));
            nums.set(start, temp);
            start++;
            end--;
        }

    }
}
