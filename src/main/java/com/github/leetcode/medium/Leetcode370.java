package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/6/19 09:47
 * @Description: Assume you have an array of length n initialized with all 0's and are given k update operations.
 * <p>
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 * <p>
 * Return the modified array after all k operations were executed.
 * <p>
 * Example:
 * <p>
 * Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * Output: [-2,0,3,5,3]
 * Explanation:
 * <p>
 * Initial state:
 * [0,0,0,0,0]
 * <p>
 * After applying operation [1,3,2]:
 * [0,2,2,2,0]
 * <p>
 * After applying operation [2,4,3]:
 * [0,2,5,5,3]
 * <p>
 * After applying operation [0,2,-2]:
 * [-2,0,3,5,3]
 */
public class Leetcode370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update :
                updates) {
            int value = update[2];
            int start = update[0];
            int end = update[1];
            res[start] += value;
            if (end + 1 < length) {
                res[end + 1] -= value;
            }
        }
        //累计前缀和
        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
