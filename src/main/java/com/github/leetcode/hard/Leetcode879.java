package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/6/19 17:30
 * @Description: There are G people in a gang, and a list of various crimes they could commit.
 * <p>
 * The i-th crime generates a profit[i] and requires group[i] gang members to participate.
 * <p>
 * If a gang member participates in one crime, that member can't participate in another crime.
 * <p>
 * Let's call a profitable scheme any subset of these crimes that generates at least P profit, and the total number of
 * gang members participating in that subset of crimes is at most G.
 * <p>
 * How many schemes can be chosen?  Since the answer may be very large, return it modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: G = 5, P = 3, group = [2,2], profit = [2,3]
 * Output: 2
 * Explanation:
 * To make a profit of at least 3, the gang could either commit crimes 0 and 1, or just crime 1.
 * In total, there are 2 schemes.
 * Example 2:
 * <p>
 * Input: G = 10, P = 5, group = [2,3,5], profit = [6,7,8]
 * Output: 7
 * Explanation:
 * To make a profit of at least 5, the gang could commit any crimes, as long as they commit one.
 * There are 7 possible schemes: (0), (1), (2), (0,1), (0,2), (1,2), and (0,1,2).
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= G <= 100
 * 0 <= P <= 100
 * 1 <= group[i] <= 100
 * 0 <= profit[i] <= 100
 * 1 <= group.length = profit.length <= 100
 */
public class Leetcode879 {
    public static void main(String[] args) {
        Leetcode879 leetcode879 = new Leetcode879();
        leetcode879.profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3});
    }

    /*
     * @param G
     * @param P
     * @param group
     * @param profit
     * @return
     */
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int K = group.length;
        int MOD = (int) 1e9 + 7;

        int[][][] dp = new int[K + 1][P + 1][G + 1];
        dp[0][0][0] = 1;
        for (int k = 1; k <= K; ++k) {
            int g = group[k - 1];
            int p = profit[k - 1];
            for (int i = 0; i <= P; ++i) {
                for (int j = 0; j <= G; ++j) {
                    dp[k][i][j] = (dp[k - 1][i][j] + (j < g ? 0 : dp[k - 1][Math.max(0, i - p)][j - g])) % MOD;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i <= G; i++) {
            sum = (sum + dp[K][P][i]) % MOD;
        }
        return sum;
    }
}
