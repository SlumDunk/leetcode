package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 08:19
 * @Description: We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape. These shapes may be rotated.
 * <p>
 * XX  <- domino
 * <p>
 * XX  <- "L" tromino
 * X
 * Given N, how many ways are there to tile a 2 x N board? Return your answer modulo 10^9 + 7.
 * <p>
 * (In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.)
 * <p>
 * Example:
 * Input: 3
 * Output: 5
 * Explanation:
 * The five different ways are listed below, different letters indicates different tiles:
 * XYZ XXZ XYY XXY XYY
 * XYZ YYZ XZZ XYY XXY
 * Note:
 * <p>
 * N  will be in range [1, 1000].
 */
public class Leetcode790 {
    public int numTilings(int N) {
        int kMod = 1000000007;
        long[][] dp = new long[N + 1][3];
        //完整覆盖0个column 和 1个column
        dp[0][0] = dp[1][0] = 1;
        for (int i = 2; i <= N; ++i) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] + dp[i - 1][1] + dp[i - 1][2]) % kMod;
            dp[i][1] = (dp[i - 2][0] + dp[i - 1][2]) % kMod;
            dp[i][2] = (dp[i - 2][0] + dp[i - 1][1]) % kMod;
        }

        return (int) dp[N][0];
    }
}
