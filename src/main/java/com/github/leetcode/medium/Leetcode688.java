package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 2/23/19 23:54
 * @Description: On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
 * <p>
 * A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal directs, then one square in an orthogonal directs.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
 * <p>
 * The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability that the knight remains on the board after it has stopped moving.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: 3, 2, 0, 0
 * Output: 0.0625
 * Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
 * From each of those positions, there are also two moves that will keep the knight on the board.
 * The total probability the knight stays on the board is 0.0625.
 * <p>
 * <p>
 * Note:
 * <p>
 * N will be between 1 and 25.
 * K will be between 0 and 100.
 * The knight always initially starts on the board.
 */
public class Leetcode688 {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] direction = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        double[][][] dp = new double[2][N][N];
        dp[0][r][c] = 1;
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    dp[i % 2][j][k] = 0;
                }
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    for (int l = 0; l < 8; l++) {
                        int x = j + direction[l][0];
                        int y = k + direction[l][1];
                        if (x < 0 || y < 0 || x >= N || y >= N) {
                            continue;
                        }
                        dp[i % 2][j][k] += dp[(i - 1) % 2][x][y];
                    }

                }
            }
        }
        double sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += dp[K % 2][i][j];
            }
        }
        return sum / Math.pow(8, K);
    }
}
