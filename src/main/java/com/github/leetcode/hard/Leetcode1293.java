package com.github.leetcode.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle). In one step, you can move up, down, left or right from and to an empty cell.
 * <p>
 * Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m-1, n-1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * grid =
 * [[0,0,0],
 * [1,1,0],
 * [0,0,0],
 * [0,1,1],
 * [0,0,0]],
 * k = 1
 * Output: 6
 * Explanation:
 * The shortest path without eliminating any obstacle is 10.
 * The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * grid =
 * [[0,1,1],
 * [1,1,1],
 * [1,0,0]],
 * k = 1
 * Output: -1
 * Explanation:
 * We need to eliminate at least two obstacles to find such a walk.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * grid.length == m
 * grid[0].length == n
 * 1 <= m, n <= 40
 * 1 <= k <= m*n
 * grid[i][j] == 0 or 1
 * grid[0][0] == grid[m-1][n-1] == 0
 */
public class Leetcode1293 {
    public int shortestPath(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;

        int[][][] visited = new int[r][c][k + 1];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 0});
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int usedK = cur[2];

                if (x == r - 1 && y == c - 1) return step;

                for (int i = 0; i < 4; i++) {
                    int nx = x + directions[i][0];
                    int ny = y + directions[i][1];

                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;

                    if (grid[nx][ny] == 1) {
                        if (usedK == k) continue;
                        if (visited[nx][ny][usedK + 1] == 1) continue;
                        visited[nx][ny][usedK + 1] = 1;
                        queue.add(new int[]{nx, ny, usedK + 1});
                    } else {
                        if (visited[nx][ny][usedK] == 1) continue;
                        visited[nx][ny][usedK] = 1;
                        queue.add(new int[]{nx, ny, usedK});
                    }

                }
            }
            step++;
        }

        return -1;
    }
}
