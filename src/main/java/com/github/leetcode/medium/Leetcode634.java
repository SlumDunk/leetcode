package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 06:54
 * @Description: In combinatorial mathematics, a derangement is a permutation of the elements of a set, such that no element appears in its original position.
 * <p>
 * There's originally an array consisting of n integers from 1 to n in ascending order, you need to find the number of derangement it can generate.
 * <p>
 * Also, since the answer may be very large, you should return the output mod 109 + 7.
 * <p>
 * Example 1:
 * Input: 3
 * Output: 2
 * Explanation: The original array is [1,2,3]. The two derangements are [2,3,1] and [3,1,2].
 * Note:
 * n is in the range of [1, 10^6].
 */
public class Leetcode634 {
    /**
     * 前n-1个完全无序+前n-2个完全无序，但又一个有序
     * 交换其中一个， 交换那个有序的
     * <p>
     * DP(n) = (n - 1) * (DP(n-1) + DP(n-2))
     *
     * @param n
     * @return
     */
    public int findDerangement(int n) {
        if (n == 0) return 0;
        if (n < 4) return n - 1;
        long previous = 1, current = 2;
        for (int i = 4; i <= n; ++i) {
            current %= 1000000007;
            long temp = current;
            current = (i - 1) * (current + previous);
            previous = temp;
        }
        return (int) (current % 1000000007);
    }


    /**
     * O(n)
     *
     * @param n
     * @return
     */
    public int findDerangement_(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = (int) (((i - 1L) * (dp[i - 1] + dp[i - 2])) % 1000000007);
        }

        return dp[n];
    }
}
