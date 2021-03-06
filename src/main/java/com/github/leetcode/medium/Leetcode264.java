package com.github.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

    public int nthUglyNumber__(int n) {
        Queue<Long> pq = new PriorityQueue<Long>();
        pq.offer(1l);
        while (n > 1) {
            Long value = pq.poll();
            // System.out.println(value);
            if (!pq.contains(value * 2)) {
                pq.offer(value * 2);
            }
            if (!pq.contains(value * 3)) {
                pq.offer(value * 3);
            }
            if (!pq.contains(value * 5)) {
                pq.offer(value * 5);
            }
            n--;
        }
        Long value = pq.poll();
        return value.intValue();
    }

    public int nthUglyNumber___(int n) {
        Queue<Long> queue = new PriorityQueue<Long>();
        queue.add(1l);
        queue.add(2l);
        queue.add(3l);
        queue.add(5l);

        while (!queue.isEmpty()) {
            Long val = queue.poll();
            if (!queue.contains(val * 2)) {
                queue.add(val * 2);
            }
            if (!queue.contains(val * 3)) {
                queue.add(val * 3);
            }
            if (!queue.contains(val * 5)) {
                queue.add(val * 5);
            }
            if (n == 1) {
                return val.intValue();
            }
            n--;
        }
        return -1;
    }
}
