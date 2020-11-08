package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 20:43
 * @Description: Given an array of integers nums.
 * <p>
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 * <p>
 * Return the number of good pairs.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * Example 2:
 * <p>
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * Example 3:
 * <p>
 * Input: nums = [1,2,3]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Leetcode1512 {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int goodPairs = 0;
        List<Integer> valuesCount = new ArrayList<>(counts.values());

        for (int value : valuesCount) {
            if (value > 1) {
                goodPairs += (value) * (value - 1) / 2;
            }
        }

        return goodPairs;
    }
}
