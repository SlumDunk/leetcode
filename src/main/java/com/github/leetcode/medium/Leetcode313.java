package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/28/18 09:55
 * @Description: Write a program to find the nth super ugly number.
 * <p>
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 * <p>
 * Example:
 * <p>
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 * super ugly numbers given primes = [2,7,13,19] of size 4.
 * Note:
 * <p>
 * 1 is a super ugly number for any given primes.
 * The given numbers in primes are in ascending order.
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 */
public class Leetcode313 {
    public static void main(String[] args) {
        Leetcode313 leetcode313=new Leetcode313();
        leetcode313.nthSuperUglyNumber(12, new int[]{2,7,13,19});
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] idxPrimes = new int[primes.length];
        int counter = 1;
        while (counter < n) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < primes.length; i++) {
                int temp = dp[idxPrimes[i]] * primes[i];
                min = min < temp ? min : temp;
            }
            for (int i = 0; i < primes.length; i++) {
                if (min == dp[idxPrimes[i]] * primes[i]) {
                    idxPrimes[i]++;
                }
            }
            dp[counter] = min;
            counter++;
        }
        return dp[n - 1];
    }

}
