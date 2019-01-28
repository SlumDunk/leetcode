package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 14:16
 * @Description: Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * <p>
 * Example
 * Given an example [2,1,2,0,1], return 2
 */
public class Lintcode150 {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        //低买高卖
        if (prices == null || prices.length == 0) {
            return 0;
        } else {
            int profit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                int diff = prices[i + 1] - prices[i];
                if (diff > 0) {
                    profit += diff;
                }
            }
            return profit;
        }
    }
}
