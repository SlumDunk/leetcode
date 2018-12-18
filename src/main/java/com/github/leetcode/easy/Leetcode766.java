package com.github.leetcode.easy;

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the
 * same element.
 * <p>
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: True Explanation:
 * 1234 5123 9512
 * <p>
 * In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2,
 * 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the
 * answer is True.
 * <p>
 * Example 2:
 * <p>
 * Input: matrix = [[1,2],[2,2]] Output: False Explanation: The diagonal "[1,
 * 2]" has different elements.
 *
 * @author liuzhongda
 */
public class Leetcode766 {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        //和下一行的对角线元素比较
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

}
