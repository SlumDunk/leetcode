package com.github.leetcode.easy;

import java.util.*;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * <p>
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 * <p>
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class Leetcode697 {

    public static void main(String[] args) {
        Leetcode697 leetcode697 = new Leetcode697();
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(leetcode697.findShortestSubArray(nums));
    }

    public int findShortestSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        else {
            //存储元素的开始位置
            Map<Integer, Integer> startMap = new HashMap<>();
            //存储元素的终止位置
            Map<Integer, Integer> endMap = new HashMap<>();
            //存储各个元素的次数
            Map<Integer, Integer> countMap = new HashMap<>();
            int degree = 0;

            for (int i = 0; i < len; i++) {
                if (!startMap.containsKey(nums[i])) {
                    startMap.put(nums[i], i);
                    endMap.put(nums[i], i);
                    countMap.put(nums[i], 1);
                } else {
                    endMap.put(nums[i], i);
                    countMap.put(nums[i], countMap.get(nums[i]) + 1);
                }
                degree = Math.max(degree, countMap.get(nums[i]));
            }
            int shortestLength = len;
            for (Integer key : countMap.keySet()) {
                if (countMap.get(key) == degree) {
                    shortestLength = Math.min(shortestLength, endMap.get(key) - startMap.get(key) + 1);
                }
            }
            return shortestLength;
        }
    }

}
