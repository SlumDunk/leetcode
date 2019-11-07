package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/23/19 10:17
 * @Description:
 */
public class Lintcode404 {

    public int subarraySumII(int[] A, int start, int end) {
        if (A == null || A.length == 0 || end < start) {
            return 0;
        }

        int[] prefixSum = new int[A.length + 1];
        prefixSum[0] = 0;

        for (int i = 1; i <= A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i - 1];
        }

        int cnt = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j <= A.length; j++) {
                int diff = prefixSum[j] - prefixSum[i];

                if (diff >= start && diff <= end) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public int subarraySumII_(int[] A, int start, int end) {
        if (A == null || A.length == 0 || end < start) {
            return 0;
        }

        int totalSum = 0;

        for (int i = 0; i < A.length; i++) {
            totalSum += A[i];
        }

        int cnt = 0;

        //以A[i]结尾的子串
        for (int i = A.length - 1; i >= 0; i--) {
            int sum = totalSum;
            //
            for (int j = 0; j <= i; j++) {
                if (j > 0) {
                    sum -= A[j - 1];
                }

                if (sum >= start && sum <= end) {
                    cnt++;
                }
            }

            totalSum -= A[i];
        }

        return cnt;
    }
}
