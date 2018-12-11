package com.github.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 20:38
 * @Description: Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * <p>
 * Example:
 * <p>
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 * <p>
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */
public class Leetcode264 {
    public static void main(String[] args) {
        Leetcode264 leetcode264 = new Leetcode264();
        System.out.println(leetcode264.heapNthUglyNumber(
                40));
    }

    public int nthUglyNumber(int n) {
        int u = 0;
        List<Integer> l1 = new LinkedList<Integer>();
        List<Integer> l2 = new LinkedList<Integer>();
        List<Integer> l3 = new LinkedList<Integer>();
        l1.add(1);
        l2.add(1);
        l3.add(1);

        for (int i = 0; i < n; i++) {
            u = Math.min(Math.min(l1.get(0), l2.get(0)), l3.get(0));

            if (l1.get(0) == u) l1.remove(0);
            if (l2.get(0) == u) l2.remove(0);
            if (l3.get(0) == u) l3.remove(0);

            l1.add(u * 2);
            l2.add(u * 3);
            l3.add(u * 5);
        }
        return u;
    }

    public int heapNthUglyNumber(int n) {
        if (n == 1) return 1;
        PriorityQueue<Long> heapQueue = new PriorityQueue<>();
        heapQueue.add(1l);

        while (n > 1) {
            Long tmp = heapQueue.poll();
            while (!heapQueue.isEmpty() && heapQueue.peek().longValue() == tmp.longValue()) {
                heapQueue.poll();
            }
            System.out.println(tmp);
            heapQueue.add(tmp * 2);
            heapQueue.add(tmp * 3);
            heapQueue.add(tmp * 5);
            n--;
        }
        return heapQueue.poll().intValue();
    }
}