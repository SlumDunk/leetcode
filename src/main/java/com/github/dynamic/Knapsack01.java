package com.github.dynamic;

/**
 * @Author: zerongliu
 * @Date: 1/5/19 20:24
 * @Description:
 */
public class Knapsack01 {
    public static void main(String args[]) {
        Knapsack01 k = new Knapsack01();
        int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        int r = k.bottomUpDP(val, wt, 30);
        System.out.println(r);
    }

    /**
     * @param val 物品的价值
     * @param wt  物品的重量
     * @param W   包的总重量
     * @return
     */
    public int bottomUpDP(int val[], int wt[], int W) {
        //有一个可容纳j重量的包裹，有i件物品，最大能带走多少价值的东西
        int[][] dp = new int[val.length + 1][W + 1];
        for (int i = 0; i < val.length; i++) {
            for (int j = 0; j <= W; j++) {
                //物品数量为0或者包裹可容纳重量为0
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (j >= wt[i]) {//能装下物品
                    dp[i][j] = Math.max(dp[i - 1][j], val[i] + dp[i - 1][j - wt[i]]);
                } else {//无法装下物品i
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[val.length][W];
    }
}
