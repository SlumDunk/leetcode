package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 2/21/19 19:51
 * @Description: Your music player contains N different songs and she wants to listen to L (not necessarily different) songs during your trip.  You create a playlist so that:
 * <p>
 * Every song is played at least once
 * A song can only be played again only if K other songs have been played
 * Return the number of possible playlists.  As the answer can be very large, return it modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 3, L = 3, K = 1
 * Output: 6
 * Explanation: There are 6 possible playlists. [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1].
 * Example 2:
 * <p>
 * Input: N = 2, L = 3, K = 0
 * Output: 6
 * Explanation: There are 6 possible playlists. [1, 1, 2], [1, 2, 1], [2, 1, 1], [2, 2, 1], [2, 1, 2], [1, 2, 2]
 * Example 3:
 * <p>
 * Input: N = 2, L = 3, K = 1
 * Output: 2
 * Explanation: There are 2 possible playlists. [1, 2, 1], [2, 1, 2]
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= K < N <= L <= 100
 */
public class Leetcode920 {
    public int numMusicPlaylists(int N, int L, int K) {
        int MOD = 1000000007;
        //N首歌组成长度为L的playlist的方式
        long[][] dp = new long[L + 1][N + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= N; j++) {
                //j第一次用
                dp[i][j] += dp[i - 1][j - 1] * (N - j + 1);
                //j取得是之前使用过的
                dp[i][j] += dp[i - 1][j] * Math.max(j - K, 0);
                dp[i][j] %= MOD;
            }
        }

        return (int) dp[L][N];
    }
}
