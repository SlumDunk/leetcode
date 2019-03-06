package com.github.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 3/6/19 10:00
 * @Description: Design a Phone Directory which supports the following operations:
 * <p>
 * get: Provide a number which is not assigned to anyone.
 * check: Check if a number is available or not.
 * release: Recycle or release a number.
 * Example:
 * <p>
 * // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
 * PhoneDirectory directory = new PhoneDirectory(3);
 * <p>
 * // It can return any available phone number. Here we assume it returns 0.
 * directory.get();
 * <p>
 * // Assume it returns 1.
 * directory.get();
 * <p>
 * // The number 2 is available, so return true.
 * directory.check(2);
 * <p>
 * // It returns 2, the only number that is left.
 * directory.get();
 * <p>
 * // The number 2 is no longer available, so return false.
 * directory.check(2);
 * <p>
 * // Release number 2 back to the pool.
 * directory.release(2);
 * <p>
 * // Number 2 is available again, return true.
 * directory.check(2);
 */
public class Leetcode379 {
    class PhoneDirectory {
        Queue<Integer> queue;

        /**
         * Initialize your data structure here
         *
         * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
         */
        public PhoneDirectory(int maxNumbers) {
            queue = new LinkedList<>();
            for (int i = 0; i < maxNumbers; i++) {
                queue.offer(i);
            }
        }

        /**
         * Provide a number which is not assigned to anyone.
         *
         * @return - Return an available number. Return -1 if none is available.
         */
        public int get() {
            if (queue.isEmpty()) {
                return -1;
            }
            return queue.poll();
        }

        /**
         * Check if a number is available or not.
         */
        public boolean check(int number) {
            return queue.contains(number);
        }

        /**
         * Recycle or release a number.
         */
        public void release(int number) {
            if (!queue.contains(number)) {
                queue.offer(number);
            }
        }
    }
}
