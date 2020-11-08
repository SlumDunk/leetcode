package com.github.lintcode.hard;

/**
 * @Author: zerongliu
 * @Date: 2/22/19 07:06
 * @Description: Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class Leetcode123 {
    public int maxProfit(int[] prices) {
        //切成左右两部分，分别取最大值，低买高卖
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int len = prices.length;
        //第i天卖出收益
        int[] left = new int[len];
        //第i天买入收益
        int[] right = new int[len];
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        right[len - 1] = 0;
        int max = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        int profit = 0;
        for (int i = 0; i < len; i++) {
            profit = Math.max(left[i] + right[i], profit);
        }
        return profit;
    }

    /**
     * O(n)
     *
     * @param prices
     * @return
     */
    public int maxProfit__(int[] prices) {

        //0 第一次买之前，1 第一次持有，2 第二次买之前，3 第二次持有，4 第二次卖
        int len = prices.length;
        int[][] dp = new int[len + 1][5];

        dp[0][0] = 0;
        dp[0][1] = dp[0][2] = dp[0][3] = dp[0][4] = Integer.MIN_VALUE;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < 5; j++) {
                if (j % 2 == 0) {//非持有状态 0 2 4 昨天就是非持有状态了
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                    if (j > 0 && i > 1) {// 昨天持有，今天卖了，赚差价
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2], dp[i][j]);
                    }
                } else {//持有状态 1 3
                    //昨天未持有，今天买入
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
                    if (i > 1) {//昨天就已经是持有状态了，赚差价
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + prices[i - 1] - prices[i - 2]);
                    }
                    if (j > 1 && i > 1) {//昨天持有上一次的股票，今天卖出并马上买入
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 2] + prices[i - 1] - prices[i - 2]);
                    }
                }
            }
        }
        //比较的是清仓状态的收益
        int max = 0;
        max = Math.max(max, dp[len][0]);
        max = Math.max(max, dp[len][2]);
        max = Math.max(max, dp[len][4]);
        return max;
    }

    public static void main(String[] args) {
        Leetcode123 leetcode123 = new Leetcode123();
        int[] prices = new int[]{2, 1, 4};
        leetcode123.maxProfit__(prices);
    }
}
