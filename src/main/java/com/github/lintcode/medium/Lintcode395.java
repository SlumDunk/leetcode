package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 9/27/19 09:55
 * @Description: There are n coins with different value in a line. Two players take turns to take one or two coins from left side until there are no more coins left. The player who take the coins with the most value wins.
 * <p>
 * Could you please decide the first player will win or lose?
 * <p>
 * If the first player wins, return true, otherwise return false.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: [1, 2, 2]
 * Output: true
 * Explanation: The first player takes 2 coins.
 * Example 2:
 * <p>
 * Input: [1, 2, 4]
 * Output: false
 * Explanation: Whether the first player takes 1 coin or 2, the second player will gain more value.
 */
public class Lintcode395 {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        if (n == 0) {
            return false;
        } else if (n <= 2) {
            return true;
        } else {
            //剩下n个棋子的最大获益
            int[] dp = new int[n + 1];
            dp[n] = 0;
            for (int i = n - 1; i >= 0; i--) {
                dp[i] = values[i] - dp[i + 1];
                if (i < n - 1) {
                    dp[i] = Math.max(dp[i], values[i] + values[i + 1] - dp[i + 2]);
                }
            }
            System.out.println(dp[0]);
            return dp[0] > 0;
        }
    }

    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin__(int[] values) {
        // write your code here
        int n = values.length;
        if (n <= 2) {
            return true;
        }
        //当前执棋者在n-i个棋子的情况下的最大净收益
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = values[i] - dp[i + 1];
            if (i < n - 1) {
                dp[i] = Math.max(dp[i], values[i] + values[i + 1] - dp[i + 2]);
            }
        }

        return dp[0] > 0;
    }


    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin___(int[] values) {
        // write your code here
        int n = values.length;
        if (n <= 2) {
            return true;
        }
        //当前执棋者在面对剩i个棋子的情况下的最大净收益
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            //剩下的coin的位置 因为是从左到右拿
            int j = n - i;
            dp[i] = values[j] - dp[i - 1];
            if (i >= 2) {
                dp[i] = Math.max(dp[i], values[j] + values[j + 1] - dp[i - 2]);
            }
        }

        return dp[n] > 0;
    }
}
