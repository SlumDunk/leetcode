package com.github.leetcode.easy;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 18:06
 * @Description: In a given grid, each cell can have one of three values:
 * <p>
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 * <p>
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 * <p>
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 */
public class Leetcode994 {
    int[][] dirs = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<Pos> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pos(i, j));
                }
            }
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pos cur = queue.remove();
                for (int[] dir :
                        dirs) {
                    int x = cur.x + dir[0];
                    int y = cur.y + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.add(new Pos(x, y));
                    }
                }
            }
            if (queue.size() == 0) break;
            level++;
        }

        for (int[] row :
                grid) {
            for (int v :
                    row) {
                if (v == 1) return -1;
            }
        }
        return level;
    }
}
