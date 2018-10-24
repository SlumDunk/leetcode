package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 16:05
 * @Description: A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <p>
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 * <p>
 * Input: m = 7, n = 3
 * Output: 28
 */
public class Leetcode62 {
    public int uniquePaths(int m, int n) {
        int[][] grids = new int[m][n];
        for(int i = 0; i < n; i++){
            grids[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            grids[i][0] = 1;
        }
        for(int i = 1; i < m ; i++){
            for(int j = 1; j < n; j++){
                grids[i][j] = grids[i-1][j] + grids[i][j-1];
            }
        }
        return grids[m-1][n-1];
    }

}
