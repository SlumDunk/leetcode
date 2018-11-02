package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 11/2/18 15:36
 * @Description: Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 * <p>
 * Si % Sj = 0 or Sj % Si = 0.
 * <p>
 * If there are multiple solutions, return any subset is fine.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 * <p>
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 */
public class Leetcode368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        int[] countRecord = new int[size];
        int maxCount = 0;
        int index = -1;
        for (int i = 0; i < size; i++) {
            int cur = nums[i];
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (cur % nums[j] == 0) {
                    max = Math.max(max, countRecord[j] + 1);
                }
            }
            countRecord[i] = max;
            if (max > maxCount) {
                maxCount = max;
                index = i;
            }
        }
        int count = 0;
        List<Integer> result = new ArrayList<Integer>();
        for (int i = index; i >= 0 && count < maxCount; i--) {
            if (nums[index] % nums[i] == 0) {
                result.add(nums[i]);
                count++;
            }
        }
        return result;
    }
}
