package com.github.leetcode.hard;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 5/26/19 22:30
 * @Description: There are N piles of stones arranged in a row.  The i-th pile has stones[i] stones.
 * <p>
 * A move consists of merging exactly K consecutive piles into one pile, and the cost of this move is equal to the total number of stones in these K piles.
 * <p>
 * Find the minimum cost to merge all piles of stones into one pile.  If it is impossible, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: stones = [3,2,4,1], K = 2
 * Output: 20
 * Explanation:
 * We start with [3, 2, 4, 1].
 * We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
 * We merge [4, 1] for a cost of 5, and we are left with [5, 5].
 * We merge [5, 5] for a cost of 10, and we are left with [10].
 * The total cost was 20, and this is the minimum possible.
 * Example 2:
 * <p>
 * Input: stones = [3,2,4,1], K = 3
 * Output: -1
 * Explanation: After any merge operation, there are 2 piles left, and we can't merge anymore.  So the task is impossible.
 * Example 3:
 * <p>
 * Input: stones = [3,5,1,2,6], K = 3
 * Output: 25
 * Explanation:
 * We start with [3, 5, 1, 2, 6].
 * We merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6].
 * We merge [3, 8, 6] for a cost of 17, and we are left with [17].
 * The total cost was 25, and this is the minimum possible.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= stones.length <= 30
 * 2 <= K <= 30
 * 1 <= stones[i] <= 100
 */
public class Leetcode1000 {
    public static void main(String[] args) {
        Leetcode1000 leetcode1000 = new Leetcode1000();
        int[] stones = new int[]{3, 5, 1, 2, 6};
        leetcode1000.mergeStones__(stones, 3);
    }

    /**
     * https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1000-minimum-cost-to-merge-stones/
     *
     * @param stones
     * @param K
     * @return
     */
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        //前n-1个数得构成K-1个堆
        if ((n - 1) % (K - 1) > 0) return -1;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + stones[i];

        int[][] dp = new int[n][n];
        for (int m = K; m <= n; ++m) {//子问题大小
            for (int i = 0; i <= n - m; ++i) {//开始
                int j = i + m - 1;//结束
                dp[i][j] = Integer.MAX_VALUE;
                for (int mid = i; mid < j; mid += K - 1) {//切割点
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);
                }
                if ((j - i) % (K - 1) == 0)
                    dp[i][j] += prefix[j + 1] - prefix[i];
            }
        }
        return dp[0][n - 1];
    }


    /**
     *
     * @param stones
     * @param K
     * @return
     */
    public int mergeStones__(int[] stones, int K) {
        int INF = (int) 1e9 + 7;
        int n = stones.length;
        if ((n - 1) % (K - 1) > 0) {
            return -1;
        }

        //i到j切成k堆的最小成本
        int[][][] dp = new int[n][n][K + 1];
        //求前缀和
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][i][1] = 0;
        }
        //长度
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                for (int k = 2; k <= K; k++) {
                    for (int m = i; m < j; m++) {
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][m][1] + dp[m + 1][j][k - 1]);
                    }
                }
                //刚好能切成K堆，所以能够合并，切成K堆的成本和合并的成本
                if (dp[i][j][K] != INF)
                    dp[i][j][1] = dp[i][j][K] + prefix[j + 1] - prefix[i];
            }
        }

        return dp[0][n - 1][1];
    }
}
