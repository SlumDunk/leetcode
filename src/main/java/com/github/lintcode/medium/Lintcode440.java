package com.github.lintcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 7/26/19 09:00
 * @Description: Given n kind of items with size Ai and value Vi(each item has an infinite number available) and a backpack with size m. What's the maximum value can you put into the backpack?
 * <p>
 *  Notice
 * You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.
 * <p>
 * Example
 * Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size10. The maximum value is 15.
 */
public class Lintcode440 {
    public static void main(String[] args) {
        Lintcode440 lintcode440 = new Lintcode440();
        int m = 10;
        int[] A = new int[]{2, 3, 5, 7};
        int[] V = new int[]{1, 5, 2, 4};
        System.out.println(lintcode440.backPackII__(m, A, V));

    }

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[m + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= A[j] && dp[i - A[j]] != -1) {
                    dp[i] = Math.max(dp[i], dp[i - A[j]] + V[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII__(int m, int[] A, int[] V) {
        // write your code here
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][m + 1];
        int res = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = -1;
                } else {
//                    for (int k = 1; k * A[i - 1] <= j; k++) {
//                        if(dp[i-1][j-k*A[i-1]]!=-1) {
//                            dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - k*A[i - 1]] + k*V[i - 1]);
//                        }
//                    }
                    if (j > A[i - 1] && dp[i][j - A[i - 1]] != -1) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - A[i - 1]] + V[i - 1]);
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}
