package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/4/18 19:19
 * @Description: We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * <p>
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 * <p>
 * Example:
 * <p>
 * n = 10, I pick 8.
 * <p>
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * <p>
 * Game over. 8 is the number I picked.
 * <p>
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */
public class LeetCode375 {
    public int getMoneyAmount(int n) {
        //since when we want to get dp[i][j], we need all dp[i][k] - dp[k][j], so we fix j, traversal i from i to 1.
        // dp[i][j] minimum number to guarantee a win for subproblem [i, j], target dp[1][n]
        // base case dp[i][i] = 0
        // for a i <= k <= j, pay k and chose worse dp[k + 1][j] or dp[i][k - 1]
        int[][] minPay = new int[n + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            for (int i = j; i >= 1; i--) {
                if (i == j) {
                    minPay[i][j] = 0;
                } else {
                    minPay[i][j] = Integer.MAX_VALUE;
                    for (int k = j ; k >= i; k --) {
                        minPay[i][j] = Math.min(minPay[i][j], k + Math.max(k == i ? 0 : minPay[i][k - 1],
                                k == j ? 0 : minPay[k + 1][j]));
                    }
                }
            }
        }
        return minPay[1][n];
    }
}
