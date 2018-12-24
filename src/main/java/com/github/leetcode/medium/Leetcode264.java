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
        System.out.println(leetcode264.nthUglyNumber(
                40));
    }

    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        //从小到大，所以需要用最小堆来存储丑数，每次取出最小值参与新丑数的生成
        PriorityQueue<Long> heapQueue = new PriorityQueue<>();
        heapQueue.add(1l);

        while (n > 1) {
            //取出当前最小的丑数
            Long tmp = heapQueue.poll();
            //去除重复的最小丑数
            while (!heapQueue.isEmpty() && heapQueue.peek().longValue() == tmp.longValue()) {
                heapQueue.poll();
            }
            //产生新的丑数
            heapQueue.add(tmp * 2);
            heapQueue.add(tmp * 3);
            heapQueue.add(tmp * 5);
            //n减1
            n--;
        }
        return heapQueue.poll().intValue();
    }
}
