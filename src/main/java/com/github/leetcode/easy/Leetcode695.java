package com.github.leetcode.easy;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * <p>
 * Example 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 */
public class Leetcode695 {
    public static void main(String[] args) {

    }

    public int maxAreaOfIsland(int[][] grid) {
        //深度优先遍历数组
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, findArea(grid, i, j, row, col));
                }
            }
        }
        return max;
    }

    /**
     * @param grid 数组
     * @param i    行位置
     * @param j    列位置
     * @param row  行数
     * @param col  列数
     * @return
     */
    public int findArea(int[][] grid, int i, int j, int row, int col) {
        if (i >= row || i < 0 || j < 0 || j >= col || grid[i][j] == 0) {
            return 0;
        } else {
            int area = 1;
            grid[i][j] = 0;//已经访问过了
            //顺时针 上，右，下，左
            return area + findArea(grid, i - 1, j, row, col) + findArea(grid, i, j + 1, row, col) + findArea(grid, i + 1, j, row, col) + findArea(grid, i, j - 1, row, col);
        }
    }
}
