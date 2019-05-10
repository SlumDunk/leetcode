package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 5/9/19 23:49
 * @Description: Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 * <p>
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
public class Leetcode977 {
    public int[] sortedSquares(int[] A) {
        int i = 0, j = A.length - 1, k = j;
        int[] B = new int[A.length];
        while (k >= 0) {
            int x = A[i] * A[i], y = A[j] * A[j];
            if (x >= y) {
                B[k] = x;
                i++;
                k--;
            } else {
                B[k] = y;
                j--;
                k--;
            }
        }
        return B;
    }
}
