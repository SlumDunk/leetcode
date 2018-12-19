package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/18/18 13:54
 * @Description: Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * <p>
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class Leetcode204 {
    public static void main(String[] args) {
        Leetcode204 leetcode204 = new Leetcode204();
        leetcode204.countPrimes(499949);
    }

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        //标志是否为合数
        boolean[] oddPrime = new boolean[n];
        int count = 1;
        //求质数，能让1和本身整除的数,偶数不用校验
        for (int i = 3; i < n; i += 2) {
            if (!oddPrime[i]) {
                count++;
                for (int j = 3; i * j < n; j += 2) {
                    if (!oddPrime[i * j]) {
                        oddPrime[i * j] = true;
                    }
                }
            }
        }
        return count;
    }
}
