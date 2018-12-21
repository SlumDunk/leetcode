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
        //存储每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //存储两个最长连续数字的长度
        int max = 0;
        for (Integer key : map.keySet()) {
            //存在连续数字的话，看看长度
            max = Math.max(max, (map.get(key + 1) == null ? 0 : map.get(key + 1) + map.get(key)));
        }
        return max;
    }
}
