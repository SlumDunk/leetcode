package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/25/19 19:39
 * @Description: By val, you are given a secret signature consisting of character 'D' and 'I'. 'D' represents a decreasing relationship between two numbers, 'I' represents an increasing relationship between two numbers. And our secret signature was constructed by a special integer array, which contains uniquely all the different number from 1 to n (n is the length of the secret signature plus 1). For example, the secret signature "DI" can be constructed by array [2,1,3] or [3,1,2], but won't be constructed by array [3,2,4] or [2,1,3,4], which are both illegal constructing special string that can't represent the "DI" secret signature.
 * <p>
 * On the other hand, val your job is to find the lexicographically smallest permutation of [1, 2, ... n] could refer to the given secret signature in the input.
 * <p>
 * Example 1:
 * Input: "I"
 * Output: [1,2]
 * Explanation: [1,2] is the only legal initial spectial string can construct secret signature "I", where the number 1 and 2 construct an increasing relationship.
 * Example 2:
 * Input: "DI"
 * Output: [2,1,3]
 * Explanation: Both [2,1,3] and [3,1,2] can construct the secret signature "DI",
 * but since we want to find the one with the smallest lexicographical permutation, you need to output [2,1,3]
 * Note:
 * <p>
 * The input string will only contain the character 'D' and 'I'.
 * The length of input string is a positive integer and will not exceed 10,000
 */
public class Leetcode484 {
    /**
     * 优先处理高位，优先分配大值
     * @param s
     * @return
     */
    public int[] findPermutation(String s) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        int[] res = new int[n + 1];

        int right = n;
        //最大的值
        int cur = n + 1;
        //从后往前扫
        while (right >= 1) {
            int left = right - 1;
            while (left >= 0 && charArray[left] == 'D') {
                left--;
            }
            //先把大数用了
            for (int i = left + 1; i <= right; i++) {
                res[i] = cur--;
            }
            //更新right
            right = left;
        }
        if (cur != 0) {
            res[0] = cur;
        }
        return res;
    }
}
