package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 3/17/19 16:12
 * @Description: Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: 2
 * Explanation: 5 = 5 = 2 + 3
 * Example 2:
 * <p>
 * Input: 9
 * Output: 3
 * Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * Example 3:
 * <p>
 * Input: 15
 * Output: 4
 * Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * Note: 1 <= N <= 10 ^ 9.
 */
public class Leetcode829 {
    /**
     * Assume k consecutive numbers:
     * x + (x+1) + (x+2)+...(x+k-1) = N,
     * => kx + k*(k-1)/2 = N
     * => k(k-1+2x) = 2N
     * As we know x is positive number, so x>=1
     * => 2N-k^2 = 2x-1>0
     * => 2N>k^2
     * so k is limited to k<sqrt(2*N).
     *
     * @param N
     * @return
     */
    public int consecutiveNumbersSum(int N) {
        int res = 1;
        double sqrt = Math.sqrt(2 * N);
        for (int i = 2; i < sqrt; i++) {
            if ((N - i * (i - 1) / 2) % i == 0) {
                res++;
            }
        }
        return res;
    }
}
