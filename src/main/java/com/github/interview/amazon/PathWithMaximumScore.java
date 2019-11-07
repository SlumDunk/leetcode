package com.github.interview.amazon;

/**
 * @Author: zerongliu
 * @Date: 11/6/19 10:58
 * @Description:
 */
public class PathWithMaximumScore {
    // Define: dp[i][j] is the max score from [0][0] to [i][j]
    // Recurence Formula: dp[i][j] = max( min(dp[i-1][j], grid[i][j]), min(dp[i][j-1]), grid[i][j] )
    // Note: Init the first entry as Integer.MAX_VALUE

    // DP (2D)
    // Time: O(rc) Space: O(rc)
    private static int maxScore2D(int[][] grid) {
        // Assume there is at least one element
        int r = grid.length, c = grid[0].length;
        int[][] dp = new int[r][c];
        // Init
        dp[0][0] = Integer.MAX_VALUE; // first entry is not considered
        for (int i = 1; i < r; ++i) dp[i][0] = Math.min(dp[i - 1][0], grid[i][0]);
        for (int j = 1; j < c; ++j) dp[0][j] = Math.min(dp[0][j - 1], grid[0][j]);
        // DP
        for (int i = 1; i < r; ++i) { // row by row
            for (int j = 1; j < c; ++j) {
                if (i == r - 1 && j == c - 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // last entry is not considered
                } else {
                    int score1 = Math.min(dp[i][j - 1], grid[i][j]); // left
                    int score2 = Math.min(dp[i - 1][j], grid[i][j]); // up
                    dp[i][j] = Math.max(score1, score2);
                }
            }
        }
        return dp[r - 1][c - 1];
    }
}
