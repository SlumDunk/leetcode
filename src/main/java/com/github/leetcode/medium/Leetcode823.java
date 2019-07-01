package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 14:37
 * @Description: Given an array of unique integers, each integer is strictly greater than 1.
 * <p>
 * We make a binary tree using these integers and each number may be used for any number of times.
 * <p>
 * Each non-leaf node's value should be equal to the product of the values of it's children.
 * <p>
 * How many binary trees can we make?  Return the answer modulo 10 ** 9 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: A = [2, 4]
 * Output: 3
 * Explanation: We can make these trees: [2], [4], [4, 2, 2]
 * Example 2:
 * <p>
 * Input: A = [2, 4, 5, 10]
 * Output: 7
 * Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 1000.
 * 2 <= A[i] <= 10 ^ 9.
 */
public class Leetcode823 {
    public int numFactoredBinaryTrees(int[] A) {
        if (A.length < 2) {
            return A.length;
        }
        //先排序，小的构成大的
        Arrays.sort(A);
        Map<Integer, Integer> counts = new HashMap<>();
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            int cur = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] % A[j] != 0) continue;
                int v = A[i] / A[j];
                if (counts.containsKey(v)) {
                    cur += ((long) counts.get(A[j]) * counts.get(v)) % 1000000007;
                    cur %= 1000000007;
                }
            }
            counts.put(A[i], cur);
            total += cur;
            total %= 1000000007;
        }

        return total;
    }
}
