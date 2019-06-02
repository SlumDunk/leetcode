package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/2/19 09:22
 * @Description: Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
 * <p>
 * After this process, we have some array B.
 * <p>
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1], K = 0
 * Output: 0
 * Explanation: B = [1]
 * Example 2:
 * <p>
 * Input: A = [0,10], K = 2
 * Output: 6
 * Explanation: B = [2,8]
 * Example 3:
 * <p>
 * Input: A = [1,3,6], K = 3
 * Output: 0
 * Explanation: B = [3,3,3] or B = [4,4,4]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 */
public class Leetcode908 {
    public int smallestRangeI(int[] A, int K) {
        int min = 10000;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < min) min = A[i];
            if (A[i] > max) max = A[i];
        }
        int mid = (max + min) / 2;
        int difference = Math.max(max - K, mid) - Math.min(min + K, mid);
        return difference;
    }
}
