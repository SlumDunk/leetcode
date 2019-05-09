package com.github.leetcode.hard;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: zerongliu
 * @Date: 5/8/19 15:04
 * @Description: Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
 * <p>
 * If there is no non-empty subarray with sum at least K, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1], K = 1
 * Output: 1
 * Example 2:
 * <p>
 * Input: A = [1,2], K = 4
 * Output: -1
 * Example 3:
 * <p>
 * Input: A = [2,-1,2], K = 3
 * Output: 3
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 */
public class Leetcode862 {
    public int shortestSubarray(int[] A, int K) {
        int len = A.length, res = len + 1;
        int[] B = new int[len + 1];
        for (int i = 0; i < len; i++) {
            B[i + 1] = B[i] + A[i];
        }
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < len + 1; i++) {
            while (d.size() > 0 && B[i] - B[d.getFirst()] >= K)
                res = Math.min(res, i - d.pollFirst());
            while (d.size() > 0 && B[i] <= B[d.getLast()])
                d.pollLast();
            d.addLast(i);
        }
        return res <= len ? res : -1;
    }
}
