package com.github.dynamic;

/**
 * @Author: zerongliu
 * @Date: 1/5/19 22:15
 * @Description:
 */
public class MatrixMultiplicationCost {
    /**
     * 所有的矩阵都看作是n*n的矩阵
     *
     * @param arr
     * @return
     */
    public int findCost(int arr[]) {
        int dp[][] = new int[arr.length][arr.length];
        int q = 0;
        //从2个matrix相乘开始
        for (int l = 2; l < arr.length; l++) {
            for (int i = 0; i < arr.length - l; i++) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                //找中间组合矩阵
                for (int k = i + 1; k < j; k++) {
                    q = dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], q);
                }
            }
        }
        return dp[0][arr.length - 1];
    }
}
