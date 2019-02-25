package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 2/24/19 19:31
 * @Description: Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 * <p>
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class Leetcode188 {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        if (k >= prices.length) {
            return allTimeProfit(prices);
        } else {
            int len = prices.length;
            int[][] dp = new int[2][len];
            for (int i = 1; i <= k; i++) {
                int maxDiff = -prices[0];
                for (int j = 1; j < len; j++) {
                    dp[i % 2][j] = Math.max(dp[i % 2][j - 1], maxDiff + prices[j]);
                    maxDiff = Math.max(maxDiff, dp[(i - 1) % 2][j] - prices[j]);
                }
            }
            return dp[k % 2][len - 1];
        }
    }

    private int allTimeProfit(int[] prices) {
        int profit = 0;
        int localMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] >= prices[i]) {
                localMin = prices[i];
            } else {
                profit += prices[i] - localMin;
                localMin = prices[i];
            }
        }
        return profit;
    }
}
