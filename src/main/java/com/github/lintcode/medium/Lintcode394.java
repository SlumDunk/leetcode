package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/25/19 21:46
 * @Description: There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more coins left. The player who take the last coin wins.
 * <p>
 * Could you please decide the first player will win or lose?
 * <p>
 * If the first player wins, return true, otherwise return false.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: 1
 * Output: true
 * Example 2:
 * <p>
 * Input: 4
 * Output: true
 * Explanation:
 * The first player takes 1 coin at first. Then there are 3 coins left.
 * Whether the second player takes 1 coin or two, then the first player can take all coin(s) left.
 * Challenge
 * O(n) time and O(1) memory
 */
public class Lintcode394 {
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        if (n == 0) {
            return false;
        }
        if (n <= 2) {
            return true;
        }
        boolean[] f = new boolean[n + 1];
        f[0] = false;
        f[1] = f[2] = true;
        int i;
        for (i = 3; i <= n; i++) {
            f[i] = (f[i - 1] == false) || (f[i - 2] == false);
        }
        return f[n];
    }

    public boolean firstWillWin__(int n) {
        // write your code here
        if (n == 0) {
            return false;
        } else if (n <= 2) {
            return true;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;

        for (int i = 3; i <= n; i++) {
            if (dp[i - 1] == false || dp[i - 2] == false) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }

        return dp[n];
    }
}
