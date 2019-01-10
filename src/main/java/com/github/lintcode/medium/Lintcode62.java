package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/9/19 13:58
 * @Description: Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example
 * For [4, 5, 1, 2, 3] and target=1, return 2.
 * <p>
 * For [4, 5, 1, 2, 3] and target=0, return -1.
 * <p>
 * Challenge
 * O(logN) time
 */
public class Lintcode62 {
    /**
     * @param A:      an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A.length == 0) {
            return -1;
        }
        int left = 0, right = A.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] > A[left]) {
                if (A[mid] >= target && A[left] <= target) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (A[mid] <= target && A[right] >= target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (A[left] == target) {
            return left;
        } else if (A[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
}
