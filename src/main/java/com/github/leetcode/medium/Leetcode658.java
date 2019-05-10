package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zerongliu
 * @Date: 5/9/19 12:09
 * @Description: Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
 * <p>
 * Example 1:
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 * Example 2:
 * Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 * Note:
 * The value k is positive and will always be smaller than the length of the sorted array.
 * Length of the given array is positive and will not exceed 104
 * Absolute value of elements in the array and x will not exceed 104
 * UPDATE (2017/9/19):
 * The arr parameter had been changed to an array of integers (instead of a list of integers). Please reload the code definition to get the latest changes.
 */
public class Leetcode658 {
    public List<Integer> findClosestElements(int[] A, int k, int x) {
        int left = 0, right = A.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - A[mid] > A[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return Arrays.stream(A,left,left+k).boxed().collect(Collectors.toList());
    }
}
