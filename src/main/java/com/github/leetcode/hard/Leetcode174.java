package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 2/25/19 14:34
 * @Description: The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 * <p>
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 * <p>
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0'word) or contain magic orbs that increase the knight'word health (positive integers).
 * <p>
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 * <p>
 * <p>
 * <p>
 * Write a function to determine the knight'word minimum initial health so that he is able to rescue the princess.
 * <p>
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * <p>
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 * <p>
 * <p>
 * Note:
 * <p>
 * The knight'word health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class Leetcode174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        } else {
            int m = dungeon.length;
            int n = dungeon[0].length;
            //到达i,j必须拥有的生命值
            int[][] dp = new int[m][n];
            dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

            for (int j = n - 2; j >= 0; j--) {
                dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
            }

            for (int i = m - 2; i >= 0; i--) {
                dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
            }

            for (int i = m - 2; i >= 0; i--) {
                for (int j = n - 2; j >= 0; j--) {
                    int curr = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.max(curr - dungeon[i][j], 1);
                }
            }
            return dp[0][0];
        }
    }
}
