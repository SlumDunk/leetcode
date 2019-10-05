package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/10/18 09:27
 * @Description: Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class Leetcode121 {
    public int maxProfit(int[] prices) {
        //最多只能完成一个交易
        int len = prices.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    public int maxProfit__(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int max = 0;
        int buy = prices[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(prices[i] - buy, max);
            buy = Math.min(buy, prices[i]);
        }
        return max;
    }
}
