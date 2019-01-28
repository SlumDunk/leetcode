package com.github.lintcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 15:37
 * @Description: Given an array of integers, find two non-overlapping subarrays which have the largest sum.
 * The number in each subarray should be contiguous.
 * Return the largest sum.
 * <p>
 * Example
 * For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.
 * <p>
 * Challenge
 * Can you do it in time complexity O(n) ?
 * <p>
 * Notice
 * The subarray should contain at least one number
 */
public class Lintcode42 {
    public static void main(String[] args) {
        Lintcode42 lintcode42 = new Lintcode42();
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(-1);
        nums.add(2);
        nums.add(-1);
        nums.add(2);
        lintcode42.maxTwoSubArrays(nums);
    }

    /*
       * @param nums: A list of integers
       * @return: An integer denotes the sum of max two non-overlapping subarrays
       */
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return 0;
        } else {
            //将数组切成两部分，每部分各自求最大子序列
            int len = nums.size();
            int[] left = new int[len];
            int[] right = new int[len];
            int sum = 0;
            int minSum = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                sum += nums.get(i);
                max = Math.max(max, sum - minSum);
                minSum = Math.min(sum, minSum);
                left[i] = max;
            }

            sum = 0;
            minSum = 0;
            max = Integer.MIN_VALUE;
            for (int i = len - 1; i >= 0; i--) {
                sum += nums.get(i);
                max = Math.max(max, sum - minSum);
                minSum = Math.min(sum, minSum);
                right[i] = max;
            }

            max = Integer.MIN_VALUE;
            for (int i = 0; i < len - 1; i++) {
                max = Math.max(max, left[i] + right[i + 1]);
            }
            return max;

        }
    }
}
