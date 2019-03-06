package com.github.leetcode.hard;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 15:27
 * @Description: You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * <p>
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * Example:
 * <p>
 * Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * <p>
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * <p>
 * Output: 7
 * <p>
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 * the point (1,2) is an ideal empty land to build a house, as the total
 * travel distance of 3+3+1=7 is minimal. So return 7.
 * Note:
 * There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 */
public class Leetcode317 {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        //每个位置到所有建筑物的距离
        int[][] dist = new int[m][n];
        //每个位置能访问的建筑物的数量
        int[][] nums = new int[m][n];
        //所有的建筑物数量
        int buildingNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    bfs(grid, i, j, dist, nums);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dist[i][j] != 0 && nums[i][j] == buildingNum) {
                    res = Math.min(res, dist[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * @param grid
     * @param row
     * @param col
     * @param dist
     * @param nums
     */
    private void bfs(int[][] grid, int row, int col, int[][] dist, int[][] nums) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        int distance = 0;

        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int k = 0; k < dirs.length; k++) {
                    int x = cur[0] + dirs[k][0];
                    int y = cur[1] + dirs[k][1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 0) {
                        visited[x][y] = true;
                        dist[x][y] += distance;
                        nums[x][y]++;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
