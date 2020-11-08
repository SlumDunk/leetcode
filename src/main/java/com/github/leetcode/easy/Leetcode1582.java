package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 17:09
 * @Description: Given a rows x cols matrix mat, where mat[i][j] is either 0 or 1, return the number of special positions in mat.
 * <p>
 * A position (i,j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: mat = [[1,0,0],
 * [0,0,1],
 * [1,0,0]]
 * Output: 1
 * Explanation: (1,2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
 * Example 2:
 * <p>
 * Input: mat = [[1,0,0],
 * [0,1,0],
 * [0,0,1]]
 * Output: 3
 * Explanation: (0,0), (1,1) and (2,2) are special positions.
 * Example 3:
 * <p>
 * Input: mat = [[0,0,0,1],
 * [1,0,0,0],
 * [0,1,1,0],
 * [0,0,0,0]]
 * Output: 2
 * Example 4:
 * <p>
 * Input: mat = [[0,0,0,0,0],
 * [1,0,0,0,0],
 * [0,1,0,0,0],
 * [0,0,1,0,0],
 * [0,0,0,1,1]]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] is 0 or 1.
 */
public class Leetcode1582 {
    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (mat[i][j] == 1 && rowOrColIsZero(mat, i, j, rows, columns))
                    count++;
            }
        }
        return count;
    }

    public boolean rowOrColIsZero(int[][] mat, int row, int col, int rows, int columns) {
        for (int j = 0; j < columns; j++) {
            if (j == col)
                continue;
            if (mat[row][j] != 0)
                return false;
        }
        for (int i = 0; i < rows; i++) {
            if (i == row)
                continue;
            if (mat[i][col] != 0)
                return false;
        }
        return true;
    }
}
