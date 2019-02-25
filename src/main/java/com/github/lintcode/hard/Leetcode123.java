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
}
