package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 21:56
 * @Description: Using O(1) time to check whether an integer n is a power of 2.
 * <p>
 * Example
 * For n=4, return true;
 * <p>
 * For n=5, return false;
 * <p>
 * Challenge
 * O(1) time
 */
public class Lintcode142 {
    /**
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if (n <= 0) {
            return false;
        }
        //相当于去掉倒数第一个1
        return (n & (n - 1)) == 0;
    }
}
