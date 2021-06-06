package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 12/25/20 19:58
 * @Description: Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * Output: [1,5]
 * Explanation: Only 1 and 5 appeared in the three arrays.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr1.length, arr2.length, arr3.length <= 1000
 * 1 <= arr1[i], arr2[i], arr3[i] <= 2000
 */
public class Leetcode1213 {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int idx1 = 0, idx2 = 0, idx3 = 0;

        while (idx1 < arr1.length && idx2 < arr2.length && idx3 < arr3.length) {
            if (arr1[idx1] == arr2[idx2] && arr1[idx1] == arr3[idx3]) {
                result.add(arr1[idx1]);
                idx1++;
                idx2++;
                idx3++;
            } else if (arr1[idx1] < arr2[idx2] || arr1[idx1] < arr3[idx3]) idx1++;
            else if (arr2[idx2] < arr1[idx1] || arr2[idx2] < arr3[idx3]) idx2++;
            else if (arr3[idx3] < arr1[idx1] || arr3[idx3] < arr2[idx2]) idx3++;
        }

        return result;
    }
}
