package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/11/18 20:33
 * @Description: Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 * <p>
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class Leetcode29 {
    public int divide(int dividend, int divisor) {
        boolean flag = (dividend > 0 && divisor > 0)
                || (dividend < 0 && divisor < 0);
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long quotient = dividePositive(absDividend, absDivisor);
        if (flag && quotient > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return flag ? (int) quotient : -(int) quotient;
    }

    private long dividePositive(long dividend, long divisor) {
        if (dividend < divisor)
            return 0;
        long quotient = 1;
        long originalDivisor = divisor;
        while (dividend >= (divisor << 1)) {
            quotient <<= 1;
            divisor <<= 1;
        }
        return quotient + dividePositive(dividend - divisor, originalDivisor);
    }
}