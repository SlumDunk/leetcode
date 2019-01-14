package com.github.lintcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 1/13/19 16:57
 * @Description: Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * Example
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * <p>
 * Clarification
 * Your algorithm should run in O(n) complexity.
 */
public class Lintcode124 {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return 0;
        } else {
            Arrays.sort(num);
            int max = 1;
            int count = 1;
            for (int i = 1; i < num.length; i++) {
                if (num[i] == num[i - 1]) {
                    continue;
                }
                if (num[i] - num[i - 1] == 1) {
                    count++;
                } else {
                    max = Math.max(count, max);
                    count = 1;
                }
            }
            max = Math.max(count, max);
            return max;
        }
    }
}
