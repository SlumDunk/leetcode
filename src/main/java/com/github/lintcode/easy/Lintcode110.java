package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 1/11/19 21:17
 * @Description: Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Example
 * Input:
 * [[1,3,1],[1,5,1],[4,2,1]]
 * <p>
 * Output:
 * 7
 * Notice
 * You can only move either down or right at any point in time.
 */
public class Lintcode110 {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        int rows = grid.length;
        int cols = grid[0].length;
        //从(0,0)到(i,j)的最短路径长度
        int[][] dp = new int[rows][cols];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
