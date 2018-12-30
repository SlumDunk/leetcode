package com.github.leetcode.easy;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 * <p>
 * Example: Given a = 1 and b = 2, return 3.
 *
 * @author liuzhongda
 */
public class Leetcode371 {

    public int getSum(int a, int b) {
        //拆成两部分的和值，异或运算和与运算，一个解决非进位问题，一个解决进位问题
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
