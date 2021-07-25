package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * Given an m x n matrix mat where every row is sorted in strictly increasing order, return the smallest common element in all rows.
 * <p>
 * If there is no common element, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
 * Output: 5
 * Example 2:
 * <p>
 * Input: mat = [[1,2,3],[2,3,4],[2,3,5]]
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 500
 * 1 <= mat[i][j] <= 104
 * mat[i] is sorted in strictly increasing order.
 */
public class Leetcode1198 {
    public int smallestCommonElement(int[][] mat) {
        int small = -1;
        for (int i = 0; i < mat[0].length; i++) {
            int num = mat[0][i];
            boolean valid = true;
            for (int j = 1; j < mat.length; j++) {
                int val = Arrays.binarySearch(mat[j], num);
                if (val < 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                small = num;
                break;
            }
        }
        return small;
    }
}
