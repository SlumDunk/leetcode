package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 10:40
 * @Description: Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 * <p>
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class Leetcode50 {
    public double myPow(double x, int n) {
        //指数为0
        if (n == 0) return 1;
        //指数为1
        if (n == 1) return x;
        //分治和递归
        int t = n / 2;
        //指数为负，底数转为分数，指数转为正
        if (n < 0) {
            t = -t;
            x = 1 / x;
        }
        //递归调用
        double res = myPow(x, t);
        //如果指数为偶数
        if (n % 2 == 0) return res * res;
        //如果指数为奇数
        return res * res * x;
    }
}
