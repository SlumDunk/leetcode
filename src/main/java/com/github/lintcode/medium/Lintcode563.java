package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/25/19 22:57
 * @Description:
 */
public class Lintcode563 {
    public int backPackV(int[] A, int T) {
        int i, j;
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] f = new int[T + 1];
        f[0] = 1;
        for (i = 1; i <= T; i++) {
            f[i] = 0;
        }
        for (i = 1; i <= n; i++) {
            for (j = T; j >= 0; j--) {
                if (j >= A[i - 1]) {
                    f[j] += f[j - A[i - 1]];
                }
            }
        }
        return f[T];
    }
}
