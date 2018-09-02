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
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        int area = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    continue;
                } else {
                    area = 2 + grid[i][j] * 4;
                    if (i - 1 >= 0) {
                        area -= Math.min(grid[i - 1][j], grid[i][j]);
                    }
                    if (j + 1 < col) {
                        area -= Math.min(grid[i][j], grid[i][j + 1]);
                    }
                    if (i + 1 < row) {
                        area -= Math.min(grid[i][j], grid[i + 1][j]);
                    }
                    if (j - 1 >= 0) {
                        area -= Math.min(grid[i][j], grid[i][j - 1]);
                    }
                    res += area;
                }
            }
        }
        return res;
    }
}
