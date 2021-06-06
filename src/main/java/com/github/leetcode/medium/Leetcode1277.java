package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/12/21 21:14
 * @Description: Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: matrix =
 * [
 * [0,1,1,1],
 * [1,1,1,1],
 * [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 * Example 2:
 * <p>
 * Input: matrix =
 * [
 * [1,0,1],
 * [1,1,0],
 * [1,1,0]
 * ]
 * Output: 7
 * Explanation:
 * There are 6 squares of side 1.
 * There is 1 square of side 2.
 * Total number of squares = 6 + 1 = 7.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 */
public class Leetcode1277 {

    /**
     * O(m*n)
     *
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int[] xMove = {-1, 0, -1};
        int[] yMove = {0, -1, -1};

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    Integer min = Integer.MAX_VALUE;
                    for (int k = 0; k < xMove.length; k++) {
                        int x = i + xMove[k];
                        int y = j + yMove[k];
                        if (isValid(x, y, m, n)) {
                            min = Math.min(dp[x][y], min);
                        } else {
                            min = 0;
                            break;
                        }
                    }
                    dp[i][j] = min + 1;
                }
                res += dp[i][j];
            }
        }

        return res;
    }

    private boolean isValid(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

}
