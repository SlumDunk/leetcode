package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 08:27
 * @Description: There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right). However, you can at most move N times. Find out the number of paths to move the ball out of grid boundary. The answer may be very large, return it after mod 109 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: m = 2, n = 2, N = 2, i = 0, j = 0
 * Output: 6
 * Explanation:
 * <p>
 * Example 2:
 * <p>
 * Input: m = 1, n = 3, N = 3, i = 0, j = 1
 * Output: 12
 * Explanation:
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * Once you move the ball out of boundary, you cannot move it back.
 * The length and height of the grid is in range [1,50].
 * N is in range [0,50].
 */
public class Leetcode576 {
    public int findPaths(int m, int n, int N, int i, int j) {
        int MOD = 1000000007;
        //第k步从i行j列位置能走出去的路径数
        int[][][] dp = new int[N + 1][m][n];
        for (int k = 1; k <= N; k++) {
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    int move = 0;
                    // up
                    if (r == 0) {
                        move++;
                    } else {
                        move += dp[k - 1][r - 1][c];
                    }
                    move %= MOD;

                    // down
                    if (r == m - 1) {
                        move++;
                    } else {
                        move += dp[k - 1][r + 1][c];
                    }
                    move %= MOD;

                    // left
                    if (c == 0) {
                        move++;
                    } else {
                        move += dp[k - 1][r][c - 1];
                    }
                    move %= MOD;

                    // right
                    if (c == n - 1) {
                        move++;
                    } else {
                        move += dp[k - 1][r][c + 1];
                    }
                    move %= MOD;

                    dp[k][r][c] = move;
                }
            }
        }
        return dp[N][i][j];
    }
}
