package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 6/22/19 14:45
 * @Description: A virus is spreading rapidly, and your task is to quarantine the infected area by installing walls.
 * <p>
 * The world is modeled as a 2-D array of cells, where 0 represents uninfected cells, and 1 represents cells contaminated with the virus. A wall (and only one wall) can be installed between any two 4-directionally adjacent cells, on the shared boundary.
 * <p>
 * Every night, the virus spreads to all neighboring cells in all four directions unless blocked by a wall. Resources are limited. Each day, you can install walls around only one region -- the affected area (continuous block of infected cells) that threatens the most uninfected cells the following night. There will never be a tie.
 * <p>
 * Can you save the day? If so, what is the number of walls required? If not, and the world becomes fully infected, return the number of walls used.
 * <p>
 * Example 1:
 * Input: grid =
 * [[0,1,0,0,0,0,0,1],
 * [0,1,0,0,0,0,0,1],
 * [0,0,0,0,0,0,0,1],
 * [0,0,0,0,0,0,0,0]]
 * Output: 10
 * Explanation:
 * There are 2 contaminated regions.
 * On the first day, add 5 walls to quarantine the viral region on the left. The board after the virus spreads is:
 * <p>
 * [[0,1,0,0,0,0,1,1],
 * [0,1,0,0,0,0,1,1],
 * [0,0,0,0,0,0,1,1],
 * [0,0,0,0,0,0,0,1]]
 * <p>
 * On the second day, add 5 walls to quarantine the viral region on the right. The virus is fully contained.
 * Example 2:
 * Input: grid =
 * [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * Output: 4
 * Explanation: Even though there is only one cell saved, there are 4 walls built.
 * Notice that walls are only built on the shared boundary of two different cells.
 * Example 3:
 * Input: grid =
 * [[1,1,1,0,0,0,0,0,0],
 * [1,0,1,0,1,1,1,1,1],
 * [1,1,1,0,0,0,0,0,0]]
 * Output: 13
 * Explanation: The region on the left only builds two new walls.
 * Note:
 * The number of rows and columns of grid will each be in the range [1, 50].
 * Each grid[i][j] will be either 0 or 1.
 * Throughout the described process, there is always a contiguous viral region that will infect strictly more uncontaminated squares in the next round.
 */
public class Leetcode749 {

    int m, n;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return p.x == this.x && p.y == this.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int containVirus(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        //key病毒位置，value为对外感染区域大小; key为病毒位置，value为需要建的墙的大小
        Map<Point, Integer> zeroCounts = new HashMap<>(), wallCounts = new HashMap<>();
        boolean[][] visitedOne = new boolean[m][n];
        int zeroTotal = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (!visitedOne[i][j]) {
                        visitedOne[i][j] = true;
                        int[] nums = countWalls(grid, i, j, visitedOne, new boolean[m][n]);
                        zeroCounts.put(new Point(i, j), nums[0]);
                        wallCounts.put(new Point(i, j), nums[1]);
                        zeroTotal += nums[0];
                    }
                }
            }
        }
        // System.out.println("zeroCounts: " + zeroCounts);
        // System.out.println("wallCounts: " + wallCounts);
        if (zeroTotal == 0) return 0;
        int max = 0;
        List<Point> candidates = new ArrayList<>();
        for (Map.Entry<Point, Integer> entry : zeroCounts.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                candidates = new ArrayList<>();
                candidates.add(entry.getKey());
            } else if (entry.getValue() == max) {
                candidates.add(entry.getKey());
            }
        }
        int min = Integer.MAX_VALUE;
        //多个区域感染大小一致
        for (Point candidate : candidates) {
            int[][] newGrid = new int[m][n];
            System.arraycopy(grid, 0, newGrid, 0, grid.length);
            toTwo(newGrid, candidate);
            toOne(newGrid, new boolean[m][n]);
            //递归调用，对新数组进行处理
            min = Math.min(min, containVirus(newGrid) + wallCounts.get(candidate));
            // System.out.println(min);
        }
        return min;
    }

    /**
     * DFS计算对外感染区域的大小和需要增加墙的数量
     *
     * @param grid
     * @param i           横坐标
     * @param j           纵坐标
     * @param visitedOne  存储被访问过的感染点
     * @param visitedZero 存储未被访问过的感染点数组
     * @return
     */
    private int[] countWalls(int[][] grid, int i, int j, boolean[][] visitedOne, boolean[][] visitedZero) {
        int zero = 0, wall = 0;
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 2) continue;
            if (grid[x][y] == 0) {//正常点
                if (!visitedZero[x][y]) {
                    visitedZero[x][y] = true;
                    zero++;
                }
                wall++;
            } else if (grid[x][y] == 1) {//病毒点
                if (!visitedOne[x][y]) {
                    visitedOne[x][y] = true;
                    int[] nums = countWalls(grid, x, y, visitedOne, visitedZero);
                    zero += nums[0];
                    wall += nums[1];
                }
            }
        }
        return new int[]{zero, wall};
    }

    /**
     * 对这块感染区域的点都打上标签2,说明已经被围堵了 helper
     *
     * @param grid
     * @param p
     */
    private void toTwo(int[][] grid, Point p) {
        for (int[] dir : dirs) {
            int x = dir[0] + p.x;
            int y = dir[1] + p.y;
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) continue;
            grid[x][y] = 2;
            toTwo(grid, new Point(x, y));
        }
    }

    /**
     * 算出新的感染矩阵
     * @param grid
     * @param visited
     */
    private void toOne(int[][] grid, boolean[][] visited) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        for (int[] dir : dirs) {
                            int x = dir[0] + i;
                            int y = dir[1] + j;
                            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 0) continue;
                            grid[x][y] = 1;
                            visited[x][y] = true;
                        }
                    }
                }
            }
        }
    }
}
