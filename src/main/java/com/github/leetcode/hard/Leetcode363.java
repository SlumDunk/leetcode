package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 3/2/19 20:18
 * @Description: Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.
 * <p>
 * Example:
 * <p>
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2
 * Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
 * and 2 is the max number no larger than k (k = 2).
 * Note:
 * <p>
 * The rectangle inside the matrix must have an area > 0.
 * What if the number of rows is much larger than the number of columns?
 */
public class Leetcode363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        } else {
            int m = matrix.length;
            int n = matrix[0].length;
            int result = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int[] sum = new int[m];
                for (int j = i; j < n; j++) {
                    for (int l = 0; l < m; l++) {
                        sum[l] += matrix[l][j];
                    }
                    int curSum = 0, curMax = Integer.MIN_VALUE;
                    TreeSet<Integer> set = new TreeSet<Integer>();
                    set.add(0);
                    for (int item :
                            sum) {
                        curSum += item;
                        Integer ceiling = set.ceiling(curSum - k);
                        if (ceiling != null) {
                            curMax = Math.max(curMax, curSum - ceiling);
                        }
                        set.add(curSum);

                    }
                    result = Math.max(result, curMax);
                }
            }
            return result;
        }
    }
}
