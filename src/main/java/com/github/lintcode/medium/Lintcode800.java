package com.github.lintcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/1/19 19:21
 * @Description:
 */
public class Lintcode800 {
    public static void main(String[] args) {
        Lintcode800 lintcode800 = new Lintcode800();

        int n = 8;
        int[] prices = new int[]{4, 4, 5};
        double[] probality = new double[]{1, 0.2, 0.3};
        System.out.println(lintcode800.backpackIX(n, prices, probality));
    }

    /**
     * @param n:           Your money
     * @param prices:      Cost of each university application
     * @param probability: Probability of getting the University's offer
     * @return: the  highest probability
     */
    public double backpackIX(int n, int[] prices, double[] probability) {
        // write your code here
        int m = prices.length;
        //前m所学校，n元，获取0个offer的最小概率
        double[][] dp = new double[2][n + 1];
        for (int i = 0; i < probability.length; i++) {
            probability[i] = 1 - probability[i];
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 1);
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i % 2][j] = 1;
                } else if (i == 0) {
                    dp[i % 2][j] = 1;
                } else if (j == 0) {
                    dp[i % 2][j] = 1;
                } else {
                    dp[i % 2][j] = dp[(i - 1) % 2][j];
                    if (j > prices[i - 1]) {
                        dp[i % 2][j] = Math.min(dp[i % 2][j], dp[(i - 1) % 2][j - prices[i - 1]] * probability[i - 1]);
                    }
                }
            }
        }

        return 1 - dp[m % 2][n];

    }

    /**
     * @param n:           Your money
     * @param prices:      Cost of each university application
     * @param probability: Probability of getting the University's offer
     * @return: the  highest probability
     */
    public double backpackIX__(int n, int[] prices, double[] probability) {
        // write your code here
        int m = prices.length;
        //前m所学校，n元，获取0个offer的最小概率
        double[] dp = new double[10010];
        for (int i = 0; i < probability.length; i++) {
            probability[i] = 1 - probability[i];
        }

        Arrays.fill(dp, 1);

        for (int i = 0; i < m; i++) {
            for (int j = n; j >= prices[i]; j--) {//压缩空间
                dp[j] = Math.min(dp[j], dp[j - prices[i]] * probability[i]);
            }
        }

        return 1 - dp[n];

    }

}
