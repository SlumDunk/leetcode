package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 12/15/18 16:02
 * @Description: Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class Leetcode169 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        //存储每个数字出现的次数
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int count = numMap.getOrDefault(nums[i], 0) + 1;
            if (count > len / 2) {
                return nums[i];
            } else {
                numMap.put(nums[i], count);
            }
        }
        return 0;
    }
}
