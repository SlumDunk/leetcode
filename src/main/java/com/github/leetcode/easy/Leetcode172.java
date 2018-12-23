package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/22/18 21:05
 * @Description: Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 * <p>
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 */
public class Leetcode172 {
    public int trailingZeroes(int n) {
        if (n < 1) return 0;
        int c = 0;
        //每增加5，多一个0
        while (n / 5 != 0) {
            n /= 5;
            c += n;
        }

        return c;
    }
}
