package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
 * <p>
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 * <p>
 * Example 1:
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 */
public class Leetcode594 {
    public static void main(String[] args) {
        Leetcode594 leetcode594 = new Leetcode594();
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        leetcode594.findLHS(nums);
    }

    public int findLHS(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>(128);
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], numMap.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0;
        for (Integer key : numMap.keySet()) {
            if (numMap.containsKey(key + 1)) {
                max = Math.max(max, numMap.get(key) + numMap.get(key + 1));
            }
        }
        return max;
    }
}
