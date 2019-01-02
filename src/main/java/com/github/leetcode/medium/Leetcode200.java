package com.github.leetcode.medium;

import java.util.LinkedList;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 14:07
 * @Description: Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class Leetcode200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0
                || grid[0].length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        //遍历数组
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == '1') {
                    count++;
                    dfsSearch(grid, i, j, rows, cols);
                }
        return count++;
    }

    /**
     * @param grid 数组
     * @param i    当前行位置
     * @param j    当前列位置
     * @param rows 行数量
     * @param cols 列数量
     */
    private void dfsSearch(char[][] grid,
                           int i, int j, int rows, int cols) {
        //越界
        if (i < 0 || i >= rows || j < 0 || j >= cols)
            return;
        if (grid[i][j] != '1')
            return;
        //访问过的陆地置为0，避免重复访问
        grid[i][j] = '0';
        //沿着四个方向搜索， 顺时针 上 右 下 左
        dfsSearch(grid, i - 1, j, rows, cols);
        dfsSearch(grid, i, j + 1, rows, cols);
        dfsSearch(grid, i + 1, j, rows, cols);
        dfsSearch(grid, i, j - 1, rows, cols);
    }

    /**
     * 广度优先搜索
     *
     * @param grid 数组
     * @param x    当前行位置
     * @param y    当前列位置
     */
    private void bfsFill(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int row = grid.length;
        int col = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int code = x * col + y;
        queue.offer(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            int i = code / col;
            int j = code % col;
            //访问过的陆地置为0，避免重复访问
            if (i > 0 && grid[i - 1][j] == '1')//上
            {
                queue.offer((i - 1) * col + j);
                grid[i - 1][j] = '0';
            }
            if (i < row - 1 && grid[i + 1][j] == '1')  //下
            {
                queue.offer((i + 1) * col + j);
                grid[i + 1][j] = '0';
            }
            if (j > 0 && grid[i][j - 1] == '1')  //左
            {
                queue.offer(i * col + j - 1);
                grid[i][j - 1] = '0';
            }
            if (j < col - 1 && grid[i][j + 1] == '1')  //右
            {
                queue.offer(i * col + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }
}

