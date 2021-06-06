package com.github.leetcode.medium;

/**
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 * <p>
 * Return the number of closed islands.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water (group of 1s).
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 * Example 3:
 * <p>
 * Input: grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 */
public class Leetcode1254 {

    int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int closedIsland(int[][] grid) {
        //先处理边界上的 0
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                fillWater(grid, i, 0);
            }
            if (grid[i][n - 1] == 0) {
                fillWater(grid, i, n - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 0) {
                fillWater(grid, 0, i);
            }
            if (grid[m - 1][i] == 0) {
                fillWater(grid, m - 1, i);
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    fillWater(grid, i, j);
                }
            }
        }

        return count;
    }

    private void fillWater(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 1) {
            return;
        }

        grid[row][col] = 1;

        for (int i = 0; i < direction.length; i++) {
            fillWater(grid, row + direction[i][0], col + direction[i][1]);
        }
    }
}
