package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 1/3/19 20:22
 * @Description: Given an integer matrix, find the length of the longest increasing path.
 * <p>
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * <p>
 * Example 1:
 * <p>
 * Input: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 * <p>
 * Input: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class Leetcode329 {
    public static void main(String[] args) {
        Leetcode329 leetcode329 = new Leetcode329();
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        leetcode329.longestIncreasingPath(matrix);
    }

    /**
     * 四个方向 上，右， 下，左
     */
    int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    /**
     * 最长路径
     */
    int max = 0;
    /**
     * 行长度
     */
    private int row;
    /**
     * 列长度
     */
    private int col;
    /**
     * 缓存
     */
    int[][] cache;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        row = matrix.length;
        col = matrix[0].length;
        if (row == 0 || col == 0) {
            return 0;
        }
        cache = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, dfs(matrix, i, j, matrix[i][j] - 1));
            }
        }
        return max;
    }

    /**
     * 深度优先遍历
     *
     * @param matrix
     * @param i      行坐标
     * @param j      列坐标
     * @param prev   上一元素的值
     * @return
     */
    private int dfs(int[][] matrix, int i, int j, int prev) {
        if (i >= row || i < 0 || j >= col || j < 0 || matrix[i][j] <= prev) {
            return 0;
        } else {
            if (cache[i][j] > 0) {
                return cache[i][j];
            }
            int longest = 0;
            for (int k = 0; k < direction.length; k++) {
                longest = Math.max(longest, dfs(matrix, i + direction[k][0], j + direction[k][1], matrix[i][j]));
            }
            cache[i][j] = longest + 1;
            return longest + 1;
        }
    }
}
