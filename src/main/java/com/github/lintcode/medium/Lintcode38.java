package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/9/19 11:00
 * @Description: Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
 * <p>
 * This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * Integers in each column are sorted from up to bottom.
 * No duplicate integers in each row or column.
 * Example
 * Consider the following matrix:
 * <p>
 * [
 * [1, 3, 5, 7],
 * [2, 4, 7, 8],
 * [3, 5, 9, 10]
 * ]
 * Given target = 3, return 2.
 * <p>
 * Challenge
 * O(m+n) time and O(1) extra space
 */
public class Lintcode38 {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0, col = cols - 1;
        int count = 0;
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                count++;
                row++;
                col--;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return count;
    }
}
