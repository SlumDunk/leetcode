package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 16:22
 * @Description: Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class Leetcode64 {
    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        for (int i = 1; i < m; i++) {
//            grid[i][0] += grid[i - 1][0];
//        }
//        for (int i = 1; i < n; i++) {
//            grid[0][i] += grid[0][i - 1];
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
//            }
//        }
//        return grid[m - 1][n - 1];
        int m = grid.length;
        int n = grid[0].length;
        //存储从(0,0)位置到(m,n)位置的最短路径
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //从上进来或者从左进来，取值小的
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

}
