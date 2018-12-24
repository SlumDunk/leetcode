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
        //0 到 sqrt(c)
        for (int i = (int) Math.sqrt(c); i >= 0; i--) {
            //0*0+i*i=c
            if (Math.pow(i, 2) == c) return true;
            else {
                //i*i+t*t=c
                int d = (int) (c - Math.pow(i, 2));
                int t = (int) Math.sqrt(d);
                if (Math.pow(t, 2) == d) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 利用二分搜索来做
     *
     * @param c
     * @return
     */
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
