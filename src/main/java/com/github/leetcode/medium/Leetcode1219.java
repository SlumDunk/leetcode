package com.github.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.
 * <p>
 * Return the maximum amount of gold you can collect under the conditions:
 * <p>
 * Every time you are located in a cell you will collect all the gold in that cell.
 * From your position, you can walk one step to the left, right, up, or down.
 * You can't visit the same cell more than once.
 * Never visit a cell with 0 gold.
 * You can start and stop collecting gold from any position in the grid that has some gold.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
 * Output: 24
 * Explanation:
 * [[0,6,0],
 * [5,8,7],
 * [0,9,0]]
 * Path to get the maximum gold, 9 -> 8 -> 7.
 * Example 2:
 * <p>
 * Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * Output: 28
 * Explanation:
 * [[1,0,7],
 * [2,0,6],
 * [3,4,5],
 * [0,3,0],
 * [9,0,20]]
 * Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 15
 * 0 <= grid[i][j] <= 100
 * There are at most 25 cells containing gold.
 */
public class Leetcode1219 {

    int max = 0;
    int m, n;
    int[][] direction = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public int getMaximumGold(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        } else {
            this.m = grid.length;
            this.n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 0) {
                        Set<Integer> visited = new HashSet<>();
                        helper(grid, i, j, visited, 0);
                    }
                }
            }
            return max;
        }
    }

    private void helper(int[][] grid, int x, int y, Set<Integer> visited, int temp) {
        if (grid[x][y] != 0) {
            temp += grid[x][y];
            visited.add(x * n + y);
            boolean flag = false;
            for (int i = 0; i < direction.length; i++) {
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited.contains((newX) * n + newY) && grid[newX][newY] > 0) {
                    helper(grid, newX, newY, visited, temp);
                    flag = true;
                }
            }
            if (!flag) {
                max = Math.max(temp, max);
            }
            visited.remove(x * n + y);
        } else {
            return;
        }
    }


}
