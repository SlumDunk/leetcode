package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 22:38
 * @Description: We are given an array A of positive integers, and two positive integers L and R (L <= R).
 * <p>
 * Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least L and at most R.
 * <p>
 * Example :
 * Input:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * Output: 3
 * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
 * Note:
 * <p>
 * L, R  and A[i] will be an integer in the range [0, 10^9].
 * The length of A will be in the range of [1, 50000].
 */
public class Leetcode795 {
    /**
     * 2 3 2 4 3
     * 1+2+3
     * @param A
     * @param L
     * @param R
     * @return
     */
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        //虚拟个prevHigh
        int prevHigh = -1, sum = 0, prev = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= L && A[i] <= R) {
                prev = i - prevHigh;
            } else if (A[i] > R) {//越界的置位状态
                prev = 0;
                prevHigh = i;
            }
            sum += prev;
        }
        return sum;
    }
}
