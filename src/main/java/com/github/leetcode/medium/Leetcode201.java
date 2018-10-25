package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 14:31
 * @Description: Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * <p>
 * Example 1:
 * <p>
 * 101
 * 110
 * 111
 * Input: [5,7]
 * Output: 4
 * Example 2:
 * <p>
 * Input: [0,1]
 * Output: 0
 */
public class Leetcode201 {
    public static void main(String[] args) {
        Leetcode201 leetcode201 = new Leetcode201();
        System.out.println(leetcode201.rangeBitwiseAnd(5, 7));
    }

    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            n >>>= 1;
            m >>>= 1;
            count++;
        }
        return m << count;
    }
}
