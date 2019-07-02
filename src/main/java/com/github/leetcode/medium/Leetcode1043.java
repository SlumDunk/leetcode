package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 22:01
 * @Description: Given an integer array A, you partition the array into (contiguous) subarrays of length at most K.  After partitioning, each subarray has their values changed to become the maximum value of that subarray.
 * <p>
 * Return the largest sum of the given array after partitioning.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,15,7,9,2,5,10], K = 3
 * Output: 84
 * Explanation: A becomes [15,15,15,9,10,10,10]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= K <= A.length <= 500
 * 0 <= A[i] <= 10^6
 */
public class Leetcode1043 {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int m = Integer.MIN_VALUE;
            //归并进去的子串长度
            for (int j = 1; j <= Math.min(i, K); j++) {
                m = Math.max(m, A[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j] + m * j);
            }
        }
        return dp[n];
    }
}
