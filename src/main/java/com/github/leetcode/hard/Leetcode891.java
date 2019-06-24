package com.github.leetcode.hard;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 6/20/19 14:20
 * @Description: Given an array of integers A, consider all non-empty subsequences of A.
 * <p>
 * For any sequence S, let the width of S be the difference between the maximum and minimum element of S.
 * <p>
 * Return the sum of the widths of all subsequences of A.
 * <p>
 * As the answer may be very large, return the answer modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,1,3]
 * Output: 6
 * Explanation:
 * Subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
 * The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
 * The sum of these widths is 6.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= 20000
 */
public class Leetcode891 {
    public static void main(String[] args) {
        Leetcode891 leetcode891 = new Leetcode891();
        int[] A = new int[]{2, 1, 3};
        leetcode891.sumSubseqWidths(A);
    }

    /**
     * https://zxi.mytechroad.com/blog/math/leetcode-891-sum-of-subsequence-widths/
     *
     * @param A
     * @return
     */
    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        long c = 1, res = 0, mod = (long) 1e9 + 7;
        for (int i = 0; i < A.length; ++i, c = (c << 1) % mod)
            res = (res + A[i] * c - A[A.length - i - 1] * c) % mod;
        return (int) ((res + mod) % mod);
    }
}
