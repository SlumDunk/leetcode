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
        leetcode309.maxProfit(new int[]{1, 2});
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int day = prices.length;
        int[] sells = new int[day];
        int[] buys = new int[day];
        buys[0] = -prices[0];
        buys[1] = Math.max(-prices[0], -prices[1]);
        sells[1] = Math.max(0, prices[1] - prices[0]);

        int max = sells[1];
        ;
        for (int i = 2; i < day; i++) {
            buys[i] = Math.max(buys[i - 1], sells[i - 2] - prices[i]);
            sells[i] = Math.max(sells[i - 1], buys[i - 1] + prices[i]);
            max = max > sells[i] ? max : sells[i];
        }
        return max;

    }
}
