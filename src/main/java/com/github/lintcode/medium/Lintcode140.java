package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 21:43
 * @Description: Calculate the an % b where a, b and n are all 32bit positive integers.
 * <p>
 * Example
 * For 231 % 3 = 2
 * <p>
 * For 1001000 % 1000 = 0
 * <p>
 * Challenge
 * O(logn)
 */
public class Lintcode140 {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        //(p*q)%m=(p%m*q%m)%m
        if (n == 1) {
            return a % b;
        }
        if (n == 0) {
            return 1 % b;
        }
        long product = fastPower(a, b, n / 2);
        product = (product * product) % b;
        if (n % 2 == 1) {
            product = (product * a) % b;
        }
        return (int) product;
    }
}
