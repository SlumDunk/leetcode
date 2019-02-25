package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 2/23/19 21:28
 * @Description: A chess knight can move as indicated in the chess diagram below:
 * <p>
 * .
 * <p>
 * <p>
 * <p>
 * This time, we place our chess knight on any numbered key of a phone pad (indicated above), and the knight makes N-1 hops.  Each hop must be from one key to another numbered key.
 * <p>
 * Each time it lands on a key (including the initial placement of the knight), it presses the number of that key, pressing N digits total.
 * <p>
 * How many distinct numbers can you dial in this manner?
 * <p>
 * Since the answer may be large, output the answer modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: 10
 * Example 2:
 * <p>
 * Input: 2
 * Output: 20
 * Example 3:
 * <p>
 * Input: 3
 * Output: 46
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 5000
 */
public class Leetcode935 {
    public int knightDialer(int N) {
        int MOD = (int) (1e9 + 7);
        //存储能跳到索引i位置的按键列表
        int[][] map = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 9, 3}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
        int[][] dp = new int[2][10];
        //第k-1次跳
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i % 2][j] = 0;
                for (int x :
                        map[j]) {
                    dp[i % 2][j] = (dp[i % 2][j] + dp[(i - 1) % 2][x]) % MOD;
                }
            }
        }
        int result = 0;
        for (int num :
                dp[N % 2]) {
            result = (result + num) % MOD;
        }
        return result;
    }
}
