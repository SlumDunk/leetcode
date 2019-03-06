package com.github.leetcode.easy;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 21:24
 * @Description: Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * <p>
 * Example:
 * <p>
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class Leetcode346 {
    class MovingAverage {
        int size;
        private double sum = 0;
        private Queue<Integer> queue;


        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
            queue = new LinkedList<Integer>();
        }

        public double next(int val) {
            if (queue.size() == size) {
                sum -= queue.remove();
            }
            sum += val;
            queue.offer(val);
            return sum / queue.size();
        }
    }
}
