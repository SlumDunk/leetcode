package com.github.leetcode.hard;

import java.util.Arrays;

/**
 * You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colors: Red, Yellow, or Green while making sure that no two adjacent cells have the same color (i.e., no two cells that share vertical or horizontal sides have the same color).
 * <p>
 * Given n the number of rows of the grid, return the number of ways you can paint this grid. As the answer may grow large, the answer must be computed modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 1
 * Output: 12
 * Explanation: There are 12 possible way to paint the grid as shown.
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: 54
 * Example 3:
 * <p>
 * Input: n = 3
 * Output: 246
 * Example 4:
 * <p>
 * Input: n = 7
 * Output: 106494
 * Example 5:
 * <p>
 * Input: n = 5000
 * Output: 30228214
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == grid.length
 * grid[i].length == 3
 * 1 <= n <= 5000
 */
public class Leetcode1411 {
    /**
     * https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1411.Number-of-Ways-to-Paint-N%C3%973-Grid
     *
     * @param n
     * @return
     */
    public int numOfWays(int n) {
        int mod = 1000000007;
        long twoColor = 6;
        long threeColor = 6;
        while (n > 1) {
            long newTwoColor = twoColor * 3 + threeColor * 2;
            long newThreeColor = twoColor * 2 + threeColor * 2;

            twoColor = newTwoColor % mod;
            threeColor = newThreeColor % mod;
            n--;
        }
        return (int) ((twoColor + threeColor) % mod);
    }

    public int numOfWaysDP(int n) {
        int mod = 1000000007;
        int[] dp = new int[27];

        for (int i = 0; i < 27; i++) {
            if (selfOK(i)) {
                dp[i] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            int[] preDp = Arrays.copyOf(dp, dp.length);
            for (int j = 0; j < 27; j++) {
                dp[j] = 0;
                // 当前行组合有效
                if (!selfOK(j)) continue;
                // 检测上下行
                for (int k = 0; k < 27; k++) {
                    if (!selfOK(k)) continue;
                    if (crossOK(j, k)) {
                        dp[j] = (dp[j] + preDp[k]) % mod;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 27; i++) {
            if (selfOK(i)) {
                sum = (sum + dp[i]) % mod;
            }
        }

        return sum;
    }

    private boolean crossOK(int j, int k) {
        for (int i = 0; i < 3; i++) {
            int temp1 = j % 3;
            int temp2 = k % 3;
            if (temp1 == temp2) return false;

            j /= 3;
            k /= 3;
        }
        return true;
    }

    boolean selfOK(int p) {
        int[] temp = new int[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = p % 3;
            p /= 3;
        }
        return (temp[0] != temp[1] && temp[1] != temp[2]);
    }
}
