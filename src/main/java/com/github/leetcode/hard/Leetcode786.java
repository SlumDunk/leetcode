package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/7/19 23:20
 * @Description: A sorted list A contains 1, plus some number of primes.  Then, for every p < q in the list, we consider the fraction p/q.
 * <p>
 * What is the K-th smallest fraction considered?  Return your answer as an array of ints, where answer[0] = p and answer[1] = q.
 * <p>
 * Examples:
 * Input: A = [1, 2, 3, 5], K = 3
 * Output: [2, 5]
 * Explanation:
 * The fractions to be considered in sorted order are:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
 * The third fraction is 2/5.
 * <p>
 * Input: A = [1, 7], K = 1
 * Output: [1, 7]
 * Note:
 * <p>
 * A will have length between 2 and 2000.
 * Each A[i] will be between 1 and 30000.
 * K will be between 1 and A.length * (A.length - 1) / 2.
 */
public class Leetcode786 {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length, min = A[0], max = A[n - 1], p = 0, q = 0;
        double lo = (double) min / (double) max, hi = 1.0;
        while (lo < hi) {
            double mid = (lo + hi) / 2.0;
            int[] count = countPairs(A, mid);
            if (count[0] == K) {
                p = count[1];
                q = count[2];
                break;
            }
            if (count[0] < K) lo = mid;
            else hi = mid;
        }
        return new int[]{p, q};
    }

    /**
     * @param A
     * @param x
     * @return
     */
    private int[] countPairs(int[] A, double x) {
        int count = 0, n = A.length, p = 0, q = 0;
        double max = 0.0;
        for (int i = 0, j = 0; i < n; i++) {
            //A[j]/A[i]<x
            while (j < i && A[j] < A[i] * x) j++;
            if (j > 0) {
                double fraction = (double) A[j - 1] / (double) A[i];
                if (max < fraction) {
                    max = fraction;
                    p = A[j - 1];
                    q = A[i];
                }
            }
            count += j;
        }
        return new int[]{count, p, q};
    }

}
