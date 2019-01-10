package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/9/19 11:22
 * @Description: There is an integer array which has the following features:
 * <p>
 * The numbers in adjacent positions are different.
 * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 * We define a position P is a peak if:
 * <p>
 * A[P] > A[P-1] && A[P] > A[P+1]
 * Find a peak element in this array. Return the index of the peak.
 * <p>
 * Example
 * Given [1, 2, 1, 3, 4, 5, 7, 6]
 * <p>
 * Return index 1 (which is number 2) or 6 (which is number 7)
 * <p>
 * Challenge
 * Time complexity O(logN)
 * <p>
 * Notice
 * It's guaranteed the array has at least one peak.
 * The array may contain multiple peeks, find any of them.
 * The array has at least 3 numbers in it.
 */
public class Lintcode75 {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A.length < 3) {
            return 0;
        }
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (A[mid] < A[mid + 1]) {
                left = mid;
            } else if (A[mid] < A[mid - 1]) {
                right = mid;
            } else {
                right = mid;
            }
        }
        if (A[left] < A[right]) {
            return right;
        } else {
            return left;
        }
    }
}
