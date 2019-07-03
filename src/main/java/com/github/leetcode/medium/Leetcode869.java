package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 20:13
 * @Description: Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
 * <p>
 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: true
 * Example 2:
 * <p>
 * Input: 10
 * Output: false
 * Example 3:
 * <p>
 * Input: 16
 * Output: true
 * Example 4:
 * <p>
 * Input: 24
 * Output: false
 * Example 5:
 * <p>
 * Input: 46
 * Output: true
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^9
 */
public class Leetcode869 {
    public boolean reorderedPowerOf2(int N) {
        int[] ncount = count(N);
        for (int i = 0; i <= 30; i++) {
            if (Arrays.equals(ncount, count(1 << i))) return true;
        }
        return false;
    }

    /**
     * 计算每个元素出现的次数
     * <p>
     * 10^9
     *
     * @param N
     * @return
     */
    private int[] count(int N) {
        int[] ans = new int[10];
        while (N > 0) {
            ans[N % 10]++;
            N /= 10;
        }
        return ans;
    }
}
