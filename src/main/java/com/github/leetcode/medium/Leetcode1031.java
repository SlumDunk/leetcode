package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 22:49
 * @Description: Given an array A of non-negative integers, return the maximum sum of elements in two non-overlapping (contiguous) subarrays, which have lengths L and M.  (For clarification, the L-length subarray could occur before or after the M-length subarray.)
 * <p>
 * Formally, return the largest V for which V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) and either:
 * <p>
 * 0 <= i < i + L - 1 < j < j + M - 1 < A.length, or
 * 0 <= j < j + M - 1 < i < i + L - 1 < A.length.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
 * Output: 20
 * Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
 * Example 2:
 * <p>
 * Input: A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
 * Output: 29
 * Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.
 * Example 3:
 * <p>
 * Input: A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
 * Output: 31
 * Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [3,8] with length 3.
 * <p>
 * <p>
 * Note:
 * <p>
 * L >= 1
 * M >= 1
 * L + M <= A.length <= 1000
 * 0 <= A[i] <= 1000
 */
public class Leetcode1031 {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        if (A == null || A.length < L + M) return 0;
        //前缀和数组
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] = sum[i - 1] + A[i];
        }
        int maxL = sum[L - 1]; // initial value
        int maxM = sum[M - 1]; // initial value
        int res = sum[L + M - 1];  // initial value
        for (int i = L + M; i < sum.length; i++) {
            //max L位置有可能发生更新
            maxL = Math.max(maxL, sum[i - M] - sum[i - (M + L)]); // maxL at i-M position
            //max M 位置有可能发生更新
            maxM = Math.max(maxM, sum[i - L] - sum[i - (M + L)]); //maxM at i-L position

            res = Math.max(res, Math.max(maxL + sum[i] - sum[i - M],
                    maxM + sum[i] - sum[i - L]));
        }
        return res;
    }
}
