package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 6/8/19 13:20
 * @Description: In a 2D grid of 0s and 1s, we change at most one 0 to a 1.
 * <p>
 * After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).
 * <p>
 * Example 1:
 * <p>
 * Input: [[1, 0], [0, 1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * Example 2:
 * <p>
 * Input: [[1, 1], [1, 0]]
 * Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
 * Example 3:
 * <p>
 * Input: [[1, 1], [1, 1]]
 * Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 * <p>
 * <p>
 * Notes:
 * <p>
 * 1 <= grid.length = grid[0].length <= 50.
 * 0 <= grid[i][j] <= 1.
 */
public class Leetcode827 {
    int count = 0;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int[][] grid) {
        int id = 2, m = grid.length, n = grid[0].length, max = 0;
        //key为岛屿类别，value为岛屿大小
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fillIsland(grid, i, j, id, m, n);
                    map.put(id, count);
                    max = Math.max(max, count);
                    count = 0;
                    id++;
                }
            }
        }
        if (max == m * n) return max;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int cur = 0;
                    Set<Integer> visited = new HashSet<>();
                    for (int[] d : dirs) {
                        int x = i + d[0];
                        int y = j + d[1];
                        //越界
                        if (x < 0 || x >= m || y < 0 || y >= n) continue;
                        //未被归类到其他连通分量
                        if (visited.add(grid[x][y])) cur += map.get(grid[x][y]);
                    }
                    max = Math.max(max, cur + 1);
                }
            }
        }
        return max;
    }

    /**
     * @param grid
     * @param i    行
     * @param j    列
     * @param id   标志属于哪个连通分量
     * @param m    行数
     * @param n    列数
     */
    private void fillIsland(int[][] grid, int i, int j, int id, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return;
        grid[i][j] = id;
        count++;
        fillIsland(grid, i + 1, j, id, m, n);
        fillIsland(grid, i - 1, j, id, m, n);
        fillIsland(grid, i, j + 1, id, m, n);
        fillIsland(grid, i, j - 1, id, m, n);
    }
}
