package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/5/19 09:28
 * @Description: On a 2-dimensional grid, there are 4 types of squares:
 * <p>
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Example 2:
 * <p>
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * Example 3:
 * <p>
 * Input: [[0,1],[2,0]]
 * Output: 0
 * Explanation:
 * There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length * grid[0].length <= 20
 */
public class Leetcode980 {
    public int uniquePathsIII(int[][] grid) {
        int sx = 0, sy = 0, total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 0) {
                    total++;
                }
            }
        }
        return dfs(grid, sx, sy, total);
    }

    /**
     * @param grid
     * @param x
     * @param y
     * @param total
     * @return
     */
    private int dfs(int[][] grid, int x, int y, int total) {
        int result = 0;
        int w = grid.length;
        int l = grid[0].length;
        if (x + 1 < w && grid[x + 1][y] == 0) {
            grid[x + 1][y] = 1;
            total--;
            result += dfs(grid, x + 1, y, total);
            grid[x + 1][y] = 0;
            total++;
        } else if (x + 1 < w && grid[x + 1][y] == 2) {
            if (total == 0) {
                result++;
            }
        }

        if (x - 1 >= 0 && grid[x - 1][y] == 0) {
            grid[x - 1][y] = 1;
            total--;
            result += dfs(grid, x - 1, y, total);
            grid[x - 1][y] = 0;
            total++;
        } else if (x - 1 >= 0 && grid[x - 1][y] == 2) {
            if (total == 0) {
                result++;
            }
        }


        if (y + 1 < l && grid[x][y + 1] == 0) {
            grid[x][y + 1] = 1;
            total--;
            result += dfs(grid, x, y + 1, total);
            grid[x][y + 1] = 0;
            total++;
        } else if (y + 1 < l && grid[x][y + 1] == 2) {
            if (total == 0) {
                result++;
            }
        }

        if (y - 1 >= 0 && grid[x][y - 1] == 0) {
            grid[x][y - 1] = 1;
            total--;
            result += dfs(grid, x, y - 1, total);
            grid[x][y - 1] = 0;
            total++;
        } else if (y - 1 >= 0 && grid[x][y - 1] == 2) {
            if (total == 0) {
                result++;
            }
        }

        return result;
    }
}
