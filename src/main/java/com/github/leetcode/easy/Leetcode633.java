package com.github.leetcode.easy;

/**
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 * <p>
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 * Input: 3
 * Output: False
 */
public class Leetcode633 {
    public boolean judgeSquareSum(int c) {
        for (int i = (int) Math.sqrt(c); i >= 0; i--) {
            if (i * i == c) return Boolean.TRUE;
            int d = c - i * i, t = (int) Math.sqrt(d);
            if (t * t == d) return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public boolean judgeSquareSum2(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            if (a * a + b * b == c) return Boolean.TRUE;
            else if (a * a + b * b < c) ++a;
            else --b;
        }
        return Boolean.FALSE;
    }
}
