package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 1/9/19 10:39
 * @Description: Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume NO duplicates in the array.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * [1,3,5,6], 5 → 2
 * <p>
 * [1,3,5,6], 2 → 1
 * <p>
 * [1,3,5,6], 7 → 4
 * <p>
 * [1,3,5,6], 0 → 0
 * <p>
 * Challenge
 * O(log(n)) time
 */
public class Lintcode60 {
    /**
     * @param A:      an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if (A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (A[left] >= target) {
            return left;
        } else if (A[right] >= target) {
            return right;
        } else {
            return right + 1;
        }
    }
}
