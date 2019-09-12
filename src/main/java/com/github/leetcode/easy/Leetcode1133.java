package com.github.leetcode.easy;

import java.util.TreeMap;

/**
 * @Author: zerongliu
 * @Date: 9/9/19 10:05
 * @Description: Given an array of integers A, return the largest integer that only occurs once.
 * <p>
 * If no integer occurs once, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [5,7,3,9,4,9,8,3,1]
 * Output: 8
 * Explanation:
 * The maximum integer in the array is 9 but it is repeated. The number 8 occurs only once, so it's the answer.
 * Example 2:
 * <p>
 * Input: [9,9,8,8]
 * Output: -1
 * Explanation:
 * There is no number that occurs only once.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 2000
 * 0 <= A[i] <= 1000
 */
public class Leetcode1133 {
    public int largestUniqueNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Integer max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            max = Math.max(max, A[i]);
        }

        //寻找最大值
        while (map.get(max) != 1) {
            max = map.lowerKey(max);
            if (max == null) {
                return -1;
            }
        }
        return max;


    }
}
