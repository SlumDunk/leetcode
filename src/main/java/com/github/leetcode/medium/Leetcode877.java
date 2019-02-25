package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 2/4/19 21:45
 * @Description: Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 * <p>
 * The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
 * <p>
 * Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.
 * <p>
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [5,3,4,5]
 * Output: true
 * Explanation:
 * Alex starts first, and can only take the first 5 or the last 5.
 * Say he takes the first 5, so that the row becomes [3, 4, 5].
 * If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
 * If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
 * This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
 * <p>
 * <p>
 * Note:
 * <p>
 * 2 <= piles.length <= 500
 * piles.length is even.
 * 1 <= piles[i] <= 500
 * sum(piles) is odd.
 */
public class Leetcode877 {
    public boolean stoneGame(int[] piles) {
        if (piles == null || piles.length == 0) {
            return true;
        } else {
            int len = piles.length;
            //存储在子问题中的相对优势
            int[][] dp = new int[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = piles[i];
            }
            for (int l = 2; l <= len; l++) {
                for (int i = 0; i < len - l + 1; i++) {
                    int j = i + l - 1;
                    dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
                }
            }
            return dp[0][len - 1] > 0;
        }
    }
}
