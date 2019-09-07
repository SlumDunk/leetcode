package com.github.lintcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 7/26/19 09:00
 * @Description:
 */
public class Lintcode440 {
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
        int[][] f = new int[n + 1][m + 1];
        int i, j;
        for (i = 0; i <= n; i++) {
            Arrays.fill(f[i], -1);
        }
        f[0][0] = 0;
        for (i = 1; i <= n; i++) {
            for (j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (A[i - 1] <= j && f[i][j - A[i - 1]] != -1) {
                    f[i][j] = Math.max(f[i][j], f[i][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        int res = 0;
        for (i = 0; i <= m; i++) {
            res = Math.max(res, f[n][i]);
        }
        return res;
    }
}
