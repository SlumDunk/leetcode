package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 08:34
 * @Description: We partition a row of numbers A into at most K adjacent (non-empty) groups, then our score is the sum of the average of each group. What is the largest score we can achieve?
 * <p>
 * Note that our partition must use every number in A, and that scores are not necessarily integers.
 * <p>
 * Example:
 * Input:
 * A = [9,1,2,3,9]
 * K = 3
 * Output: 20
 * Explanation:
 * The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * We could have also partitioned A into [9, 1], [2], [3, 9], for example.
 * That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 100.
 * 1 <= A[i] <= 10000.
 * 1 <= K <= A.length.
 * Answers within 10^-6 of the correct answer will be accepted as correct.
 */
public class Leetcode813 {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        //前i个数的和
        double[] sums = new double[n + 1];
        double[][] dp = new double[K + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            sums[i] = sums[i - 1] + A[i - 1];
            dp[1][i] = sums[i] / i;
        }
        //多少个分组
        for (int i = 2; i <= K; ++i) {
            //i 到 n
            for (int j = i; j <= n; ++j) {
                //寻找分割点
                for (int k = i - 1; k < j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + (double) (sums[j] - sums[k]) / (j - k));
                }
            }
        }
        return dp[K][n];
    }
}
