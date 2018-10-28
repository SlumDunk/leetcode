package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/27/18 09:31
 * @Description: Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * <p>
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * <p>
 * Example:
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class Leetcode304 {
    class NumMatrix {

        int[][] sum;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) return;
            sum = new int[matrix.length][matrix[0].length];
            sum[0][0] = 0;
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[0].length; c++) {
                    if (r == 0 && c == 0) sum[r][c] = matrix[r][c];
                    else if (r == 0) sum[r][c] = matrix[r][c] + sum[r][c - 1];
                    else if (c == 0) sum[r][c] = matrix[r][c] + sum[r - 1][c];
                    else sum[r][c] = matrix[r][c] + sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 == 0 && col1 == 0) return sum[row2][col2];
            if (row1 == 0) return sum[row2][col2] - sum[row2][col1 - 1];
            if (col1 == 0) return sum[row2][col2] - sum[row1 - 1][col2];
            return sum[row1 - 1][col1 - 1] + sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1];
        }
    }

}
