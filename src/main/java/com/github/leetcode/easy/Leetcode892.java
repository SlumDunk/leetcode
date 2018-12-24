package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/2/18 17:49
 * @Description: On a N * N grid, we place some 1 * 1 * 1 cubes.
 * <p>
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * <p>
 * Return the total surface area of the resulting shapes.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[2]]
 * Output: 10
 * Example 2:
 * <p>
 * Input: [[1,2],[3,4]]
 * Output: 34
 * Example 3:
 * <p>
 * Input: [[1,0],[0,2]]
 * Output: 16
 * Example 4:
 * <p>
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 * Example 5:
 * <p>
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 */
public class Leetcode892 {
    public int surfaceArea(int[][] grid) {
        //去掉相邻的接触面积
        //每个元素*4+底面和上表面，再顺时针减去 上，右，下，左
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        //存储中间结果
        int area = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    continue;
                } else {
                    area = 2 + grid[i][j] * 4;
                    //上
                    if (i - 1 >= 0) {
                        area -= Math.min(grid[i - 1][j], grid[i][j]);
                    }
                    //右
                    if (j + 1 < col) {
                        area -= Math.min(grid[i][j + 1], grid[i][j]);
                    }
                    //下
                    if (i + 1 < row) {
                        area -= Math.min(grid[i + 1][j], grid[i][j]);
                    }
                    //左
                    if (j - 1 >= 0) {
                        area -= Math.min(grid[i][j - 1], grid[i][j]);
                    }
                    result += area;
                }
            }
        }
        return result;
    }
}
