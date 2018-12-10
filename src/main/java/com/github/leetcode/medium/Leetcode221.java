package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 13:30
 * @Description: Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * Output: 4
 * 找最大正方形的边长
 * 元素值为0， 则包含它的正方形边长是0
 * 元素值为1，则包含它的正方形边长为左上、正上、左边最小值+1
 */
public class Leetcode221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] d = new int[n][m];
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == '1') {
                d[i][0] = 1;
                max = 1;
            }
        }

        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == '1') {
                d[0][j] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '0') d[i][j] = 0;
                else {
                    d[i][j] = Math.min(Math.min(d[i - 1][j], d[i][j - 1]), d[i - 1][j - 1]) + 1;
                    max = Math.max(max, d[i][j]);
                }
            }
        }
        return max * max;
    }

}
