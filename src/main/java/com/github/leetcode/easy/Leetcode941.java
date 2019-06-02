package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 18:32
 * @Description: Given an array A of integers, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that A is a mountain array if and only if:
 * <p>
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,1]
 * Output: false
 * Example 2:
 * <p>
 * Input: [3,5,5]
 * Output: false
 * Example 3:
 * <p>
 * Input: [0,3,2,1]
 * Output: true
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class Leetcode941 {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            if (A[start + 1] > A[start]) {
                start++;
            } else if (A[end - 1] > A[end]) {
                end--;
            } else {
                break;
            }
        }
        return start != 0 && end != A.length - 1 && start == end;
    }
}
