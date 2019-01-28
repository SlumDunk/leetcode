package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 14:30
 * @Description: Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p>
 * Example
 * Given an example [4,4,6,1,1,4,2,5], return 6.
 * <p>
 * Notice
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Lintcode151 {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //从某个点做切割，切成左右各一次交易，然后求最大值
        int len = prices.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            min = Math.min(prices[i], min);
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
