package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 14:08
 * @Description: Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Example
 * Given array [3,2,3,1,2], return 1.
 */
public class Lintcode149 {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        //假设以第i天作为卖出点，求得获益数组，然后取其中最大值
        if (prices == null || prices.length == 0) {
            return 0;
        } else {
            int len = prices.length;
            int[] profits = new int[len];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                min = Math.min(min, prices[i]);
                profits[i] = Math.max(prices[i] - min, 0);
            }
            int maxProfit = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                maxProfit = Math.max(maxProfit, profits[i]);
            }
            return maxProfit;
        }
    }
}
