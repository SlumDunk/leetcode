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
        int len = nums.length;
        int closeTarget = 0;
        //最小差值
        int minReduce = 0;
        //三个数字和
        int total = 0;
        //对数字位置没有要求，先对数组进行排序
        Arrays.sort(nums);
        //给予初始值
        closeTarget = nums[0] + nums[1] + nums[2];
        minReduce = Math.abs(closeTarget - target);
        for (int i = 0; i < len; i++) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                total = nums[i] + nums[left] + nums[right];
                if (total > target) {
                    right--;
                } else if (total < target) {
                    left++;
                } else {
                    return target;
                }
                //每次求出最小差值
                if (minReduce > Math.abs(total - target)) {
                    minReduce = Math.abs(total - target);
                    closeTarget = total;
                }
            }
        }
        return closeTarget;

    }
}
