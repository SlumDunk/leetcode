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


    public int maxProfit__(int k, int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        } else {
            if (k > len / 2) {
                return allTimeProfit__(prices);
            }
            //第k次买之前 2*(k-1)，
            //第k次持有 2*(k-1)+1，
            //第k+1次买之前 2*(k)
            // int[][] dp=new int[len+1][2*k+1];
            int[][] dp = new int[2][2 * k + 1];
            dp[0][0] = 0;
            for (int i = 1; i <= 2 * k; i++) {
                dp[0][i] = Integer.MIN_VALUE;
            }

            for (int i = 1; i <= len; i++) {
                for (int j = 0; j < 2 * k + 1; j++) {
                    dp[i % 2][j] = 0;
                    if (j % 2 == 0) {//非持有
                        dp[i % 2][j] = Math.max(dp[i % 2][j], dp[(i - 1) % 2][j]);
                        if (j > 0 && i > 1) {
                            dp[i % 2][j] = Math.max(dp[i % 2][j], dp[(i - 1) % 2][j - 1] + prices[i - 1] - prices[i - 2]);
                        }
                    } else {//持有
                        dp[i % 2][j] = Math.max(dp[i % 2][j], dp[(i - 1) % 2][j - 1]);
                        if (i > 1) {
                            dp[i % 2][j] = Math.max(dp[i % 2][j], dp[(i - 1) % 2][j] + prices[i - 1] - prices[i - 2]);
                        }
                        if (j > 1 && i > 1) {
                            dp[i % 2][j] = Math.max(dp[i % 2][j], dp[(i - 1) % 2][j - 2] + prices[i - 1] - prices[i - 2]);
                        }
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < 2 * k + 1; i += 2) {
                max = Math.max(max, dp[len % 2][i]);
            }

            return max;
        }
    }

    private int allTimeProfit__(int[] prices) {
        int len = prices.length;
        //预计买入价
        int buy = prices[0];
        int sum = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > buy) {
                sum += prices[i] - buy;
                buy = prices[i];
            } else {
                buy = prices[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Leetcode188 leetcode188 = new Leetcode188();
        int k = 2;
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        leetcode188.maxProfit__(k, prices);
    }
}
