package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/27/18 15:12
 * @Description: Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * <p>
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class Leetcode309 {
    public static void main(String[] args) {
        Leetcode309 leetcode309 = new Leetcode309();
        leetcode309.maxProfit(new int[]{1, 2, 3, 0, 2});
    }

    public int maxProfit(int[] prices) {
//        if (prices.length <= 1) {
//            return 0;
//        }
//        int day = prices.length;
//        int[] sells = new int[day];
//        int[] buys = new int[day];
//        buys[0] = -prices[0];
//        buys[1] = Math.max(-prices[0], -prices[1]);
//        sells[1] = Math.max(0, prices[1] - prices[0]);
//
//        int max = sells[1];
//        for (int i = 2; i < day; i++) {
//            buys[i] = Math.max(buys[i - 1], sells[i - 2] - prices[i]);
//            sells[i] = Math.max(sells[i - 1], buys[i - 1] + prices[i]);
//            max = max > sells[i] ? max : sells[i];
//        }
//        return max;
        if (prices.length <= 1) {
            return 0;
        }
        int len = prices.length;
        //dp[][0]存储在当天买入的累积收益，dp[][1]存储在当天卖出的累积收益
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];//第一天买入的累积收益
        dp[0][1] = 0;//第一天卖出的累积收益,没得卖
        dp[1][0] = Math.max(dp[0][0], -prices[1]);//第二天买入的累积收益，只能第一天和第二天二选一，选收益大的
        dp[1][1] = Math.max(dp[0][1], dp[0][0] + prices[1]);//第二天卖出的累积收益，要么第一天买入，第二天卖出，要么第二天买入，不卖
        int max = dp[1][1];
        for (int i = 2; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);//第i天买入的累积收益，要么不买入，要么前天卖出股票，今天买入新的
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);//第i天卖出的收益,要么不卖，要么把昨天买入的卖出去
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.printf(dp[i][j] + " ");
            }
            System.out.println();
        }
        return max;

    }
}
