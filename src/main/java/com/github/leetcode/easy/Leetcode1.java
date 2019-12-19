package com.github.leetcode.easy;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 12/10/18 17:55
 * @Description: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    if (nums[j] == target - nums[i]) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    public int[] twoSum_(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] ans = new int[2];
        int i = 0;
        for (int num : nums) {
            if (map.containsKey(target - num)) {
                ans[0] = map.get(target - num);
                ans[1] = i;
            }
            map.put(num, i);
            i++;
        }

        return ans;
    }
}
