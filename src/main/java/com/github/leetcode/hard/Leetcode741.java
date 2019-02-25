package com.github.leetcode.hard;

import com.github.leetcode.medium.LeetCode375;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 2/23/19 09:49
 * @Description: In a N x N grid representing a field of cherries, each cell is one of three possible integers.
 * <p>
 * <p>
 * <p>
 * 0 means the cell is empty, so you can pass through;
 * 1 means the cell contains a cherry, that you can pick up and pass through;
 * -1 means the cell contains a thorn that blocks your way.
 * <p>
 * <p>
 * Your task is to collect maximum number of cherries possible by following the rules below:
 * <p>
 * <p>
 * <p>
 * Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or down through valid path cells (cells with value 0 or 1);
 * After reaching (N-1, N-1), returning to (0, 0) by moving left or up through valid path cells;
 * When passing through a path cell containing a cherry, you pick it up and the cell becomes an empty cell (0);
 * If there is no valid path between (0, 0) and (N-1, N-1), then no cherries can be collected.
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid =
 * [[0, 1, -1],
 * [1, 0, -1],
 * [1, 1,  1]]
 * Output: 5
 * Explanation:
 * The player started at (0, 0) and went down, down, right right to reach (2, 2).
 * 4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
 * Then, the player went left, up, up, left to return home, picking up one more cherry.
 * The total number of cherries picked up is 5, and this is the maximum possible.
 * <p>
 * <p>
 * Note:
 * <p>
 * grid is an N by N 2D array, with 1 <= N <= 50.
 * Each grid[i][j] is an integer in the set {-1, 0, 1}.
 * It is guaranteed that grid[0][0] and grid[N-1][N-1] are not -1.
 */
public class Leetcode741 {
    public static void main(String[] args) {
        Leetcode741 leetCode741 = new Leetcode741();
        int[][] grid = {{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
        leetCode741.cherryPickup(grid);
    }

    /**
     * Assupmtion:
     * Go from (0, 0) -> (n-1, n-1) -> (0, 0) can be opt to two men go from (0, 0) -> (n-1, n-1) together, but when they go into
     * the same cell, the cur state can only be added 1 (use once)
     * Using DP to solve the problem:
     * 1.  dp[x1][y1][x2] to represent the largest ans we can get when first guy (marked as A) at(x1, y2) and second guy(marked as B) at (x2, x1 + y1 - x2)
     * because we can only go right and down, so we have x1 + y1 = x2 + y2
     * 2.  Induction: every time we calculate the maximum of :
     * dp[x1 - 1][y1][x2] : A down, B right
     * dp[x1][y1 - 1][x2] : A right, B right
     * dp[x1 - 1][y1][x2 - 1]: A down, B down
     * dp[x1][y1 - 1][x2 - 1]: A right, B down
     * if the Max of these values is negative, then we don't have a path to this point
     * else we have: dp[x1][y1][x2] = Max + grid[x1 - 1][y1 - 1] + grid[x2 - 1][y2 - 1](if x1 != x2 && y1 != y2) else we
     * only add once.
     * 3.  Base case;
     * we use dp[][][]from 1 - n, so we have:
     * dp[1][1][1] = 1 and all other values are MIN_VALUE
     * 4.  Ans:
     * dp[n][n][n]
     * 5.  Direction:
     * from top left -> bottom right
     * 6.  Time:
     * O(n^3)
     * Space:
     * O(n^3)
     *
     * @param grid
     * @return
     */
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n + 1][n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        dp[1][1][1] = grid[0][0];
        for (int x1 = 1; x1 <= n; x1++) {
            for (int y1 = 1; y1 <= n; y1++) {
                for (int x2 = 1; x2 <= n; x2++) {
                    int y2 = x1 + y1 - x2;
                    //have already detected||out of boundary||could not access
                    if (dp[x1][y1][x2] > 0 || y2 < 1 || y2 > n || grid[x1 - 1][y1 - 1] == -1 || grid[x2 - 1][y2 - 1] == -1) {
                        continue;
                    }
                    //A down, B right; A right, B right; A down,B down; A right, B down;
                    int cur = Math.max(Math.max(dp[x1 - 1][y1][x2], dp[x1][y1 - 1][x2]), Math.max(dp[x1 - 1][y1][x2 - 1], dp[x1][y1 - 1][x2 - 1]));
                    if (cur < 0) {
                        continue;
                    }
                    dp[x1][y1][x2] = cur + grid[x1 - 1][y1 - 1];
                    if (x1 != x2) {
                        dp[x1][y1][x2] += grid[x2 - 1][y2 - 1];
                    }
                }
            }
        }

        return dp[n][n][n] < 0 ? 0 : dp[n][n][n];
    }


}
