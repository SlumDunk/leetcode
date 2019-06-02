package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 2/25/19 10:55
 * @Description: You are installing a billboard and want it to have the largest idx.  The billboard will have two steel supports, one on each side.  Each steel support must be an equal idx.
 * <p>
 * You have a collection of rods which can be welded together.  For example, if you have rods of lengths 1, 2, and 3, you can weld them together to make a support of length 6.
 * <p>
 * Return the largest possible idx of your billboard installation.  If you cannot support the billboard, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,6]
 * Output: 6
 * Explanation: We have two disjoint subsets {1,2,3} and {6}, which have the same sum = 6.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5,6]
 * Output: 10
 * Explanation: We have two disjoint subsets {2,3,5} and {4,6}, which have the same sum = 10.
 * Example 3:
 * <p>
 * Input: [1,2]
 * Output: 0
 * Explanation: The billboard cannot be supported, so we return 0.
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= rods.length <= 20
 * 1 <= rods[i] <= 1000
 * The sum of rods is at most 5000.
 */
public class Leetcode956 {
    /**
     * dp[d] mean the maximum pair of sum we can get with pair difference d
     * For example, if have a pair of sum (a, b) with a > b, then dp[a - b] = b
     * If we have dp[diff] = a, it means we have a pair of sum (a, a + diff).
     * And this is the biggest pair with difference = a
     * <p>
     * dp is initializes with dp[0] = 0;
     * <p>
     * Assume we have an init state like this
     * ------- y ------|----- d -----|
     * ------- y ------|
     * <p>
     * case 1
     * If put x to tall side
     * ------- y ------|----- d -----|----- x -----|
     * ------- y ------|
     * <p>
     * We update dp[d + x] = max(dp[d + x], y )
     * <p>
     * case 2.1
     * Put x to low side and d >= x:
     * -------y------|----- d -----|
     * -------y------|--- x ---|
     * <p>
     * We update dp[d-x] = max( dp[d - x], y + x)
     * <p>
     * case 2.2
     * Put x to low side and d < x:
     * ------- y ------|----- d -----|
     * ------- y ------|------- x -------|
     * We update dp[x - d] = max(dp[x - d], y + d)
     * <p>
     * case 2.1 and case2.2 can merge into dp[abs(x - d)] = max(dp[abs(x - d)], y + min(d, x))
     * <p>
     * <p>
     * Time Complexity:
     * O(NM), where we have
     * N = rod.length <= 20
     * S = sum(rods) <= 5000
     * M = all possible sum = min(3^N, S)
     * <p>
     * There are 3 ways to arrange a number: in the first group, in the second, not used.
     * The number of difference will be less than 3^N.
     * The only case to reach 3^N is when rod = [1,3,9,27,81...]
     *
     * @param rods
     * @return
     */
    public int tallestBillboard(int[] rods) {
        if (rods == null || rods.length == 0) {
            return 0;
        } else {
            int len = rods.length;
            int[] dp = new int[5001];
            for (int i = 1; i < 50001; i++) {
                dp[i] = -10000;
            }
            for (int x :
                    rods) {
                int[] cur = dp.clone();
                for (int d = 0; d + x < 5001; d++) {
                    dp[d + x] = Math.max(dp[d + x], cur[d]);
                    dp[Math.abs(d - x)] = Math.max(dp[Math.abs(d - x)], cur[d] + Math.min(d, x));
                }
            }
            return dp[0];
        }
    }
}
