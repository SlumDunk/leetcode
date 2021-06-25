package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * You are given two identical eggs and you have access to a building with n floors labeled from 1 to n.
 * <p>
 * You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break, and any egg dropped at or below floor f will not break.
 * <p>
 * In each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). If the egg breaks, you can no longer use it. However, if the egg does not break, you may reuse it in future moves.
 * <p>
 * Return the minimum number of moves that you need to determine with certainty what the value of f is.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: We can drop the first egg from floor 1 and the second egg from floor 2.
 * If the first egg breaks, we know that f = 0.
 * If the second egg breaks but the first egg didn't, we know that f = 1.
 * Otherwise, if both eggs survive, we know that f = 2.
 * Example 2:
 * <p>
 * Input: n = 100
 * Output: 14
 * Explanation: One optimal strategy is:
 * - Drop the 1st egg at floor 9. If it breaks, we know f is between 0 and 8. Drop the 2nd egg starting
 * from floor 1 and going up one at a time to find f within 7 more drops. Total drops is 1 + 7 = 8.
 * - If the 1st egg does not break, drop the 1st egg again at floor 22. If it breaks, we know f is between 9
 * and 21. Drop the 2nd egg starting from floor 10 and going up one at a time to find f within 12 more
 * drops. Total drops is 2 + 12 = 14.
 * - If the 1st egg does not break again, follow a similar process dropping the 1st egg from floors 34, 45,
 * 55, 64, 72, 79, 85, 90, 94, 97, 99, and 100.
 * Regardless of the outcome, it takes at most 14 drops to determine f.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 */
public class Leetcode1884 {
    /**
     * https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/discuss/1250854/Key-idea-toward-egg-dropping-problems
     * @param n
     * @return
     */
    public int twoEggDrop(int n) {
        int[][] dp = new int[n + 1][3];
        for (int arr[] :
                dp) {
            Arrays.fill(arr, -1);
        }

        return helper(n, 2, dp);
    }

    private int helper(int n, int egg, int[][] dp) {
        if (egg == 1) {
            return n;
        }
        if (n == 0 || n == 1) return n;
        if (dp[n][egg] != -1) {
            return dp[n][egg];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int c = 1 + Math.max(helper(i - 1, egg - 1, dp), helper(n - i, egg, dp));
            min = Math.min(c, min);
        }
        return dp[n][egg] = min;
    }
}
