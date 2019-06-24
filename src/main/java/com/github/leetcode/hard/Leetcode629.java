package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/22/19 21:14
 * @Description: Given two integers n and k, find how many different arrays consist of numbers from 1 to n such that there are exactly k inverse pairs.
 * <p>
 * We define an inverse pair as following: For ith and jth element in the array, if i < j and a[i] > a[j] then it's an inverse pair; Otherwise, it's not.
 * <p>
 * Since the answer may be very large, the answer should be modulo 109 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3, k = 0
 * Output: 1
 * Explanation:
 * Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0 inverse pair.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: n = 3, k = 1
 * Output: 2
 * Explanation:
 * The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.
 * <p>
 * <p>
 * Note:
 * <p>
 * The integer n is in the range [1, 1000] and k is in the range [0, 1000].
 */
public class Leetcode629 {
    /**
     * https://www.youtube.com/watch?v=PBk2-aUP-nQ
     *
     * @param n
     * @param k
     * @return
     */
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int MOD = 1000000007;
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                //得经过一层数学推导
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (j >= i) {
                    dp[i][j] -= dp[i - 1][j - i];
                }
                dp[i][j] = dp[i][j] > 0 ? dp[i][j] % MOD : (dp[i][j] + MOD) % MOD;
            }
        }
        return dp[n][k];
    }
}
