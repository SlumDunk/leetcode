package com.github.leetcode.hard;

/**
 * You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the left, 1 position to the right in the array, or stay in the same place (The pointer should not be placed outside the array at any time).
 * <p>
 * Given two integers steps and arrLen, return the number of ways such that your pointer still at index 0 after exactly steps steps. Since the answer may be too large, return it modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: steps = 3, arrLen = 2
 * Output: 4
 * Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
 * Right, Left, Stay
 * Stay, Right, Left
 * Right, Stay, Left
 * Stay, Stay, Stay
 * Example 2:
 * <p>
 * Input: steps = 2, arrLen = 4
 * Output: 2
 * Explanation: There are 2 differents ways to stay at index 0 after 2 steps
 * Right, Left
 * Stay, Stay
 * Example 3:
 * <p>
 * Input: steps = 4, arrLen = 2
 * Output: 8
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= steps <= 500
 * 1 <= arrLen <= 106
 */
public class Leetcode1269 {
    public int numWays(int steps, int arrLen) {
        int mod = (int) 1e9 + 7;
        int sz = Math.min(steps / 2 + 1, arrLen);
        // 走到第几个位置的方式
        int prevDp[] = new int[arrLen + 2];
        prevDp[1] = 1;
        for (int step = 1; step <= steps; step++) {
            int[] curDp = new int[arrLen + 2];
            for (int i = 1; i <= Math.min(sz, step + 1); i++) {
                curDp[i] = (int) ((1L * prevDp[i] + 1L * prevDp[i + 1] + 1L * prevDp[i - 1]) % mod);
            }
            prevDp = curDp;
        }
        return prevDp[1];
    }
}
