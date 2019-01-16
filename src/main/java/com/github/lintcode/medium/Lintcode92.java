package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/15/19 19:55
 * @Description: Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
 * <p>
 * Example
 * If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.
 * <p>
 * You function should return the max size we can fill in the given backpack.
 * <p>
 * Challenge
 * O(n x m) time and O(m) memory.
 * <p>
 * O(n x m) memory is also acceptable if you do not know how to optimize memory.
 * <p>
 * Notice
 * You can not divide any item into small pieces.
 */
public class Lintcode92 {
    public static void main(String[] args) {
        Lintcode92 lintcode92 = new Lintcode92();
        int[] nums = {3, 4, 8, 5};
        lintcode92.backPack(10, nums);
    }

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        } else {
            int n = A.length;
            //i容量的包装j个物品，最多装多少
            int[][] dp = new int[n + 1][m + 1];
            dp[0][0] = 0;
            for (int i = 1; i <= n; i++) {
                dp[i][0] = 0;
            }
            for (int i = 1; i <= m; i++) {
                dp[0][i] = 0;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (A[i - 1] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j - A[i - 1]] + A[i - 1], dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n][m];
        }
    }

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPackOptimize(int m, int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        } else {
            int n = A.length;
            //i容量的包装j个物品，最多装多少
            int[][] dp = new int[2][m + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    if (i == 0) {
                        dp[i][j] = 0;
                        continue;
                    }
                    if (j == 0) {
                        dp[i % 2][0] = 0;
                        continue;
                    }
                    if (A[i - 1] <= j) {
                        dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j - A[i - 1]] + A[i - 1], dp[(i - 1) % 2][j]);
                    } else {
                        dp[i % 2][j] = dp[(i - 1) % 2][j];
                    }
                }
            }
            return dp[n % 2][m];
        }
    }
}
