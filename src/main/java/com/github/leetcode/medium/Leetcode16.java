package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 9/25/18 16:02
 * @Description: Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Leetcode16 {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length,
                closeTarget = 0,
                minReduce = 0,
                total = 0,
                i = 0;
        Arrays.sort(nums);
        closeTarget = nums[0] + nums[1] + nums[2];
        minReduce = Math.abs(closeTarget - target);
        for (; i < len; i++) {
            int j = i + 1, k = len - 1;
            while (j < k) {
                total = nums[i] + nums[j] + nums[k];
                if (total > target) {
                    k--;
                } else if (total < target) {
                    j++;
                } else {
                    return target;
                }

                if (minReduce > Math.abs(total - target)) {
                    minReduce = Math.abs(total - target);
                    closeTarget = total;
                }
            }
        }
        return closeTarget;

    }
}
