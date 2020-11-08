package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 9/20/20 11:32
 * @Description:
 */
public class Leetcode1510 {
    public static void main(String[] args) {
        Leetcode1510 leetcode1510=new Leetcode1510();
        System.out.println(leetcode1510.winnerSquareGame(31250));
    }
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int k=1; k*k<=i; k++) {
                dp[i] = dp[i] || dp[i - k*k]==false;
                if (dp[i] == true) {
                    break;
                }
            }
        }
        return dp[n];

    }
}
