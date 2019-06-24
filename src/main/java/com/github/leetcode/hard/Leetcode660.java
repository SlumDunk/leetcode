package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/22/19 19:57
 * @Description: Start from integer 1, remove any integer that contains 9 such as 9, 19, 29...
 * <p>
 * So now, you will have a new integer sequence: 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ...
 * <p>
 * Given a positive integer n, you need to return the n-th integer after removing. Note that 1 will be the first integer.
 * <p>
 * Example 1:
 * Input: 9
 * Output: 10
 * Hint: n will not exceed 9 x 10^8.
 */
public class Leetcode660 {

    public int newInteger(int n) {
        if (n < 9) {
            return n;
        }
        if (n == 9) {
            return 10;
        }
        return newInteger(n / 9) * newInteger(9) + newInteger(n % 9);
    }
}
