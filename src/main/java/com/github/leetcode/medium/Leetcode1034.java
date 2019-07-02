package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 14:23
 * @Description: Given a 2-dimensional grid of integers, each value in the grid represents the color of the grid square at that location.
 * <p>
 * Two squares belong to the same connected component if and only if they have the same color and are next to each other in any of the 4 directions.
 * <p>
 * The border of a connected component is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).
 * <p>
 * Given a square at location (r0, c0) in the grid and a color, color the border of the connected component of that square with the given color, and return the final grid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
 * Output: [[3, 3], [3, 2]]
 * Example 2:
 * <p>
 * Input: grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
 * Output: [[1, 3, 3], [2, 3, 3]]
 * Example 3:
 * <p>
 * Input: grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
 * Output: [[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length <= 50
 * 1 <= grid[0].length <= 50
 * 1 <= grid[i][j] <= 1000
 * 0 <= r0 < grid.length
 * 0 <= c0 < grid[0].length
 * 1 <= color <= 1000
 */
public class Leetcode1034 {
    /**
     * 只染色连通分量边界上的点
     * @param grid
     * @param r0
     * @param c0
     * @param color
     * @return
     */
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {

        int val = grid[r0][c0];

        //1.Find out the connected components and mark them -1
        color(grid, r0, c0, val);

        //2.Among the connected components, find out "non-borders" and mark them -2
        for (int i = 1; i < grid.length - 1; i++)
            for (int j = 1; j < grid[0].length - 1; j++)
                //上下左右都被包住，non-border 从上到下，从左到右扫描 所以 上和左得考虑已经变化的情况
                if (grid[i][j] == -1 &&
                        (grid[i - 1][j] == -1 || grid[i - 1][j] == -2) &&
                        grid[i + 1][j] == -1 &&
                        (grid[i][j - 1] == -1 || grid[i][j - 1] == -2) &&
                        grid[i][j + 1] == -1)
                    grid[i][j] = -2;

        //3.Color the "borders" and turn "non-borders" back to initial value
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) grid[i][j] = color;
                if (grid[i][j] == -2) grid[i][j] = val;
            }
        }

        return grid;
    }

    /**
     * 寻找所有连通的格子并打上标签-1
     *
     * @param grid
     * @param r0
     * @param c0
     * @param val  格子的值
     */
    private void color(int[][] grid, int r0, int c0, int val) {
        if (r0 < 0 || c0 < 0 || r0 >= grid.length || c0 >= grid[0].length || grid[r0][c0] != val)
            return;
        grid[r0][c0] = -1;
        color(grid, r0 + 1, c0, val);
        color(grid, r0 - 1, c0, val);
        color(grid, r0, c0 + 1, val);
        color(grid, r0, c0 - 1, val);
    }
}
