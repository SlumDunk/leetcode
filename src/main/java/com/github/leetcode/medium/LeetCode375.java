package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 11/4/18 19:19
 * @Description: We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * <p>
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 * <p>
 * Example:
 * <p>
 * n = 10, I pick 8.
 * <p>
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * <p>
 * Game over. 8 is the number I picked.
 * <p>
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */
public class LeetCode375 {
    public static void main(String[] args) {
        LeetCode375 leetCode375 = new LeetCode375();
//        leetCode375.getMoneyAmount(10);
        System.out.println(leetCode375.getMoneyAmount__(3));
    }


    public int getMoneyAmount(int n) {
        //存储保证能猜赢某个范围内的数字的最小金额
        int[][] minPay = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                if (i == j) {
                    minPay[j][i] = 0;
                } else {
                    //在j到i之间选择一个中间数，让赢得sub problem [j,i]成本最小
                    minPay[j][i] = Integer.MAX_VALUE;
                    for (int k = i; k >= j; k--) {
                        int cost = k + Math.max(k == j ? 0 : minPay[j][k - 1], k == i ? 0 : minPay[k + 1][i]);
                        minPay[j][i] = Math.min(minPay[j][i], cost);
                    }
                }
            }
        }

        for (int i = 0; i < minPay.length; i++) {
            for (int j = 0; j < minPay[0].length; j++) {
                System.out.printf(minPay[i][j] + " ");
            }
            System.out.println();
        }
        return minPay[1][n];
    }


    public int getMoneyAmount__(int n) {
        //保证能猜赢范围i到j的数字的最低成本
        int[][] dp = new int[n + 1][n + 1];
        int INF = (int) (1e9 + 7);
        for (int[] sub :
                dp) {
            Arrays.fill(sub, INF);
        }
        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n + 1 - l; i++) {
                int j = i + l - 1;
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    for (int k = i; k <= j; k++) {
                        //成本高的那半段
                        dp[i][j] = Math.min(dp[i][j], k + Math.max((k == i ? 0 : dp[i][k - 1]), (k == j ? 0 : dp[k + 1][j])));
                    }
                }
            }
        }

        return dp[1][n];
    }

}
