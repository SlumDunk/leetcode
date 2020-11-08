package com.github.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 17:04
 * @Description: In an N by N square grid, each cell is either empty (0) or blocked (1).
 * <p>
 * A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
 * <p>
 * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
 * C_1 is at location (0, 0) (ie. has value grid[0][0])
 * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
 * Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[0,1],[1,0]]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length == grid[0].length <= 100
 * grid[r][c] is 0 or 1
 */
public class Leetcode1091 {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;

        grid[0][0] = -1; // mark as visited
        Queue<int[]> q = new LinkedList<>();
        //row, column, len
        q.add(new int[]{0, 0, 1});

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) return cur[2];

                for (int j = 0; j < 8; j++) {
                    int nx = cur[0] + dirs[j][0], ny = cur[1] + dirs[j][1];
                    //不越界且合法
                    if (nx < m && nx >= 0 && ny < n && ny >= 0 && grid[nx][ny] == 0) {
                        grid[nx][ny] = -1;
                        q.add(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }
        }
        return -1;
    }


    /**
     * bfs O(m*n)
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix_(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;

        grid[0][0] = -1; // mark as visited
        Queue<int[]> q = new LinkedList<>();
        //row, column, len
        q.add(new int[]{0, 0});
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) return level;

                for (int j = 0; j < 8; j++) {
                    int nx = cur[0] + dirs[j][0], ny = cur[1] + dirs[j][1];
                    //不越界且合法
                    if (nx < m && nx >= 0 && ny < n && ny >= 0 && grid[nx][ny] == 0) {
                        grid[nx][ny] = -1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
