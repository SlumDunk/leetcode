package com.github.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 5/9/19 21:31
 * @Description: Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
 * <p>
 * Example 1:
 * 11000
 * 11000
 * 00011
 * 00011
 * Given the above grid map, return 1.
 * Example 2:
 * 11011
 * 10000
 * 00001
 * 11011
 * Given the above grid map, return 3.
 * <p>
 * Notice that:
 * 11
 * 1
 * and
 * 1
 * 11
 * are considered different island shapes, because we do not consider reflection / rotation.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class Leetcode694 {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    StringBuilder buffer = new StringBuilder();
                    dfs(grid, i, j, buffer, "o");
                    grid[i][j] = 0;
                    set.add(buffer.toString());
                }
            }
        }
        return set.size();
    }

    /**
     * @param grid
     * @param i
     * @param j
     * @param buffer
     * @param dir
     */
    private void dfs(int[][] grid, int i, int j, StringBuilder buffer, String dir) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length||grid[i][j]==0) {
            return;
        }
        buffer.append(dir);
        grid[i][j] = 0;
        dfs(grid, i - 1, j, buffer, "u");
        dfs(grid, i + 1, j, buffer, "d");
        dfs(grid, i, j - 1, buffer, "l");
        dfs(grid, i, j + 1, buffer, "r");
        buffer.append("b");
    }
}
