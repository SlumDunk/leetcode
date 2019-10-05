package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 9/14/19 10:48
 * @Description: Alex and Lee continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones.
 * <p>
 * Alex and Lee take turns, with Alex starting first.  Initially, M = 1.
 * <p>
 * On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).
 * <p>
 * The game continues until all the stones have been taken.
 * <p>
 * Assuming Alex and Lee play optimally, return the maximum number of stones Alex can get.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: piles = [2,7,9,4,4]
 * Output: 10
 * Explanation:  If Alex takes one pile at the beginning, Lee takes two piles, then Alex takes 2 piles again. Alex can get 2 + 4 + 4 = 10 piles in total. If Alex takes two piles at the beginning, then Lee can take all three piles left. In this case, Alex get 2 + 7 = 9 piles in total. So we return 10 since it's larger.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 10 ^ 4
 */
public class Leetcode1140 {
    /**
     * O(N^3)
     * @param piles
     * @return
     */
    public int stoneGameII(int[] piles) {
        //X=1 or 2
        //M=2 or 4
        if (piles == null || piles.length == 0) {
            return 0;
        }
        int len = piles.length;
        int[][] mem = new int[len][len];

        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        int diff = helper(piles, 0, 1, mem);
        int sum = 0;
        for (int pile : piles) {
            sum += pile;
        }
        return (sum + diff) / 2;


    }

    /**
     * @param piles
     * @param left
     * @param M
     * @param mem
     * @return
     */
    int helper(int[] piles, int left, int M, int[][] mem) {
        if (left >= piles.length) return 0;
        if (mem[left][M - 1] > -1) return mem[left][M - 1];
        int diff = Integer.MIN_VALUE;
        int score = 0;
        for (int x = 0; x < 2 * M && left + x < piles.length; x++) {
            score += piles[left + x];
            diff = Math.max(diff, score - helper(piles, left + x + 1, Math.max(x + 1, M), mem));
        }
        mem[left][M - 1] = diff;
        return diff;
    }
}
