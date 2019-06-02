package com.github.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 11/23/18 11:22
 * @Description: Given an m x n matrix of non-negative integers representing the idx of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * <p>
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with idx equal or lower.
 * <p>
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * <p>
 * Note:
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * Example:
 * <p>
 * Given the following 5x5 matrix:
 * <p>
 * Pacific ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   * Atlantic
 * <p>
 * Return:
 * <p>
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class Leetcode417 {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        //结果集
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length, col = matrix[0].length;
        //记录能流入pacific的位置
        boolean[][] pacific = new boolean[row][col];
        //记录能流入atlantic的位置
        boolean[][] atlantic = new boolean[row][col];
        //解决左右列边界
        for (int i = 0; i < row; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, col - 1);
        }
        //解决上下行边界
        for (int i = 0; i < col; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, row - 1, i);
        }
        //找出能同时到达pacific和atlantic的位置
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i, j});
        return res;
    }

    //四大方向 右，下，左，上
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * @param matrix  水流数组
     * @param visited 访问数组
     * @param height  出流的高度
     * @param x       行位置
     * @param y       列位置
     */
    public void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int row = matrix.length, col = matrix[0].length;
        if (x < 0 || x >= row || y < 0 || y >= col || visited[x][y] || matrix[x][y] < height)
            return;
        //设置访问标记
        visited[x][y] = true;
        //分别沿四个方向深度遍历
        for (int[] d : dir) {
            dfs(matrix, visited, matrix[x][y], x + d[0], y + d[1]);
        }
    }


    public List<int[]> bfsPacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        //One visited map for each ocean
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        //列边界的元素入队
        for (int i = 0; i < n; i++) {
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, m - 1});
            pacific[i][0] = true;
            atlantic[i][m - 1] = true;
        }
        //行边界的元素入队
        for (int i = 0; i < m; i++) {
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{n - 1, i});
            pacific[0][i] = true;
            atlantic[n - 1][i] = true;
        }
        //广度优先搜索
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i, j});
            }
        }
        return res;
    }

    /**
     * 广度优先搜索
     *
     * @param matrix
     * @param queue
     * @param visited
     */
    public void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        int n = matrix.length, m = matrix[0].length;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]) {
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }

}
