package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/23/18 10:41
 * @Description: Given an integer, write a function to determine if it is a power of two.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 * <p>
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 * <p>
 * Input: 218
 * Output: false
 */
public class Leetcode231 {
    public boolean isPowerOfTwo(int n) {
        //
        if (n < 1) {
            return false;
        } else {
            //如果是2的指数幂，那么n和n-1的二进制只差一个位，按位与的结果是0
            return (n & (n - 1)) == 0;
        }
    }
}
