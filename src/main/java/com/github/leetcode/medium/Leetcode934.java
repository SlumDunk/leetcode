package com.github.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 5/26/19 20:11
 * @Description: In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
 * <p>
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 * <p>
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length = A[0].length <= 100
 * A[i][j] == 0 or A[i][j] == 1
 */
public class Leetcode934 {
    public static void main(String[] args) {
        Leetcode934 leetcode934 = new Leetcode934();
        int[][] A = new int[][]{{0, 1}, {1, 0}};
        leetcode934.shortestBridge(A);
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] A) {
        int n = A.length;
        Queue<int[]> queue = new LinkedList<>();
        out:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    markIslandAsTwo(A, i, j, n, queue);
                    break out;
                }

            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir :
                    dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (A[x][y] >= 2 || A[x][y] == -1) continue;
                    if (A[x][y] == 1) return A[cur[0]][cur[1]] - 2;
                    queue.offer(new int[]{x, y});
                    A[x][y] = A[cur[0]][cur[1]] + 1;
                }
            }
        }
        return -1;
    }

    /**
     * DFS找到第一个island
     *
     * @param a
     * @param i
     * @param j
     * @param n
     * @param queue
     */
    private void markIslandAsTwo(int[][] a, int i, int j, int n, Queue<int[]> queue) {
        if (i < 0 || j < 0 || i >= n || j >= n || a[i][j] != 1) return;
        a[i][j] = -1;
        if (valid(a, i, j, n)) {
            a[i][j] = 2;
            queue.offer(new int[]{i, j});
        }
        for (int[] dir :
                dirs) {
            markIslandAsTwo(a, i + dir[0], j + dir[1], n, queue);
        }
    }

    /**
     * 4个相邻方向有一个是0,表示能继续往外扩展
     *
     * @param a
     * @param i
     * @param j
     * @param n
     * @return
     */
    private boolean valid(int[][] a, int i, int j, int n) {
        return (i > 0 && a[i - 1][j] == 0) || (i < n - 1 && a[i + 1][j] == 0) || (j > 0 && a[i][j - 1] == 0) || (j < n - 1 && a[i][j + 1] == 0);
    }
}
