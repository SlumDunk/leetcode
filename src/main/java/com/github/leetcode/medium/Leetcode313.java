package com.github.leetcode.medium;

import java.util.PriorityQueue;

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
        Leetcode313 leetcode313 = new Leetcode313();
        leetcode313.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        //利用最小堆来做
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        heap.add(1l);
        while (n > 1) {
            //取出当前最小丑数
            Long tmp = heap.poll();
            //去除和当前丑数相同的丑数
            while (!heap.isEmpty() && heap.peek().longValue() == tmp.longValue()) {
                heap.poll();
            }
            //产生新的丑数
            for (int prime : primes) {
                heap.add(prime * tmp);
            }
            n--;
        }
        //返回第n个丑数
        return heap.poll().intValue();
    }

}
