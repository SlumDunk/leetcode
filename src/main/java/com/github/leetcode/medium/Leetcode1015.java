package com.github.leetcode.medium;

import java.util.HashSet;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 15:11
 * @Description: Given a positive integer K, you need find the smallest positive integer N such that N is divisible by K, and N only contains the digit 1.
 * <p>
 * Return the length of N.  If there is no such N, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: 1
 * Explanation: The smallest answer is N = 1, which has length 1.
 * Example 2:
 * <p>
 * Input: 2
 * Output: -1
 * Explanation: There is no such positive integer N divisible by 2.
 * Example 3:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: The smallest answer is N = 111, which has length 3.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= K <= 10^5
 */
public class Leetcode1015 {
    public static void main(String[] args) {
        Leetcode1015 leetcode1015=new Leetcode1015();
        leetcode1015.smallestRepunitDivByK(3);
    }

    /**
     * 1 11 111 1111
     * @param K
     * @return
     */
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0)
            return -1;

        int N = 1;
        int length = 1;
        //存储余数
        HashSet<Integer> remainders = new HashSet<Integer>();
        // 1 11 1011
        while (N % K != 0) {
            /**
             * returns false if this remainder is already calculated,
             * because now it essentially runs into a loop.
             **/
            if (remainders.contains(N % K))
                return -1;

            remainders.add(N % K);

            /**
             * Instead of using <N = 10 * N + 1> that could overflow, we use <N = 10 * ( N % K ) + 1>.
             **/
            N = 10 * (N % K) + 1;
            length++;
        }

        return length;
    }
}
