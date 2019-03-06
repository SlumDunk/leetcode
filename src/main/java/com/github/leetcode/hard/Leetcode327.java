package com.github.leetcode.hard;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 16:37
 * @Description: Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 * <p>
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 * <p>
 * Example:
 * <p>
 * Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 */
public class Leetcode327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        TreeMap<Long, Long> treeMap = new TreeMap<>();
        treeMap.put((long) 0, (long) 1);
        long sum = 0;
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            long from = sum - upper;
            long to = sum - lower;
            Map<Long, Long> sub = treeMap.subMap(from, true, to, true);
            for (Long value : sub.values()) {
                count += value;
            }
            treeMap.put(sum, treeMap.getOrDefault(sum, (long) 0) + 1);
        }
        return (int) count;
    }
}
