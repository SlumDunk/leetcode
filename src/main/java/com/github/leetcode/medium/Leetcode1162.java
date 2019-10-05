package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 9/14/19 20:18
 * @Description:
 */
public class Leetcode1162 {

    public static void main(String[] args) {
        Leetcode1162 leetcode1162 = new Leetcode1162();
        int[][] grid = new int[][]{
                {1, 0, 0}, {0, 0, 0}, {0, 0, 0}
        };
        System.out.println(leetcode1162.maxDistance(grid));
    }

    class Pair {
        int row;
        int col;

        public Pair(int i, int j) {
            this.row = i;
            this.col = j;
        }
    }

    int[][] direction = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public int maxDistance(int[][] grid) {
        //0 water 1 land
        //Max(找0到最近的1的距离)
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int ans = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Pair item = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newRow = item.row + direction[i][0];
                    int newCol = item.col + direction[i][1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && visited[newRow][newCol] == false) {
                        grid[newRow][newCol] = grid[item.row][item.col] + 1;
                        queue.offer(new Pair(newRow, newCol));
                        visited[newRow][newCol] = true;
                    }
                }
                if (grid[item.row][item.col] != 1) {
                    ans = Math.max(grid[item.row][item.col] - 1, ans);
                }
                size--;
            }
        }
        return ans;
    }

}
