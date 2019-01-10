package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/9/19 14:54
 * @Description: There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 * <p>
 * Example
 * Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.
 * <p>
 * Given A=[1,2,3] and B=[4,5], the median is 3.
 * <p>
 * Challenge
 * The overall run time complexity should be O(log (m+n)).
 */
public class Lintcode65 {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int n = A.length + B.length;
        if (n % 2 == 0) {
            return (findKth(A, 0, B, 0, n / 2) + findKth(A, 0, B, 0, n / 2 + 1)) / 2.0;
        }
        return findKth(A, 0, B, 0, n / 2 + 1);
    }

    /**
     * @param A
     * @param startA
     * @param B
     * @param startB
     * @param k
     * @return
     */
    public int findKth(int[] A, int startA, int[] B, int startB, int k) {
        if (startA >= A.length) {
            return B[startB + k - 1];
        }
        if (startB >= B.length) {
            return A[startA + k - 1];
        }

        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }
        int halfA = startA + k / 2 - 1 < A.length ? A[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int halfB = startB + k / 2 - 1 < B.length ? B[startB + k / 2 - 1] : Integer.MAX_VALUE;

        if (halfA < halfB) {
            return findKth(A, startA + k / 2, B, startB, k - k / 2);
        } else {
            return findKth(A, startA, B, startB + k / 2, k - k / 2);
        }

    }
}
