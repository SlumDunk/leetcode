package com.github.leetcode.hard;

import java.util.Arrays;

/**
 * There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).
 * <p>
 * There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 * <p>
 * Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
 * <p>
 * Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 5, ranges = [3,4,1,1,0,0]
 * Output: 1
 * Explanation: The tap at point 0 can cover the interval [-3,3]
 * The tap at point 1 can cover the interval [-3,5]
 * The tap at point 2 can cover the interval [1,3]
 * The tap at point 3 can cover the interval [2,4]
 * The tap at point 4 can cover the interval [4,4]
 * The tap at point 5 can cover the interval [5,5]
 * Opening Only the second tap will water the whole garden [0,5]
 * Example 2:
 * <p>
 * Input: n = 3, ranges = [0,0,0,0]
 * Output: -1
 * Explanation: Even if you activate all the four taps you cannot water the whole garden.
 * Example 3:
 * <p>
 * Input: n = 7, ranges = [1,2,1,0,2,1,0,1]
 * Output: 3
 * Example 4:
 * <p>
 * Input: n = 8, ranges = [4,0,0,0,0,0,0,0,4]
 * Output: 2
 * Example 5:
 * <p>
 * Input: n = 8, ranges = [4,0,0,0,4,0,0,0,4]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^4
 * ranges.length == n + 1
 * 0 <= ranges[i] <= 100
 */
public class Leetcode1326 {
    public int minTaps(int n, int[] ranges) {
        // 覆盖 [0,i] 需要开多少水阀
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 2);
        dp[0] = 0; // [0,0]
        // 第 i 号水阀
        for (int i = 0; i <= n; i++) {
            for (int j = Math.max(0, i - ranges[i]); j <= Math.min(i + ranges[i], n); j++) {
                dp[j] = Math.min(dp[j], dp[Math.max(0, i - ranges[i])] + 1);
            }
        }
        return dp[n] < n + 2 ? dp[n] : -1;
    }
}
