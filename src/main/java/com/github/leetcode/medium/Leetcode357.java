package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/2/18 14:15
 * @Description: Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * <p>
 * Example:
 * <p>
 * Input: 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
 * excluding 11,22,33,44,55,66,77,88,99
 */
public class Leetcode357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        //<10的时候有10个数，>=10第一位有9个选择，每多一位少1选择
        int val = 9, ans = 10;
        for (int i = 2; i <= n; i++) {
            val *= (9 - i + 2);
            ans += val;
        }
        return ans;
    }
}
