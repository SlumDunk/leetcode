package com.github.leetcode.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Design your implementation of the circular double-ended queue (deque).
 * Your implementation should support following operations:
 * <p>
 * MyCircularDeque(k): Constructor, set the size of the deque to be k.
 * insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
 * insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
 * deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
 * deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
 * getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
 * getRear(): Gets the last item from Deque. If the deque is empty, return -1.
 * isEmpty(): Checks whether Deque is empty or not.
 * isFull(): Checks whether Deque is full or not.
 * Example:
 * <p>
 * MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
 * circularDeque.insertLast(1);			// return true
 * circularDeque.insertLast(2);			// return true
 * circularDeque.insertFront(3);			// return true
 * circularDeque.insertFront(4);			// return false, the queue is full
 * circularDeque.getRear();  				// return 32
 * circularDeque.isFull();				// return true
 * circularDeque.deleteLast();			// return true
 * circularDeque.insertFront(4);			// return true
 * circularDeque.getFront();				// return 4
 * <p>
 * <p>
 * Note:
 * <p>
 * All values will be in the range of [1, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in Deque library.
 */
public class Leetcode641 {

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // set the size to be 3
        System.out.println(circularDeque.insertLast(1));            // return true
        System.out.println(circularDeque.insertLast(2));            // return true
        System.out.println(circularDeque.insertFront(3));            // return true
        System.out.println(circularDeque.insertFront(4));            // return false, the queue is full
        System.out.println(circularDeque.getRear());                // return 32
        System.out.println(circularDeque.isFull());                // return true
        System.out.println(circularDeque.deleteLast());            // return true
        System.out.println(circularDeque.insertFront(4));            // return true
        System.out.println(circularDeque.getFront());                // return 4

    }

    private static class MyCircularDeque {
        private int size;
        private List<Integer> lastDataList = new LinkedList<Integer>();
        private List<Integer> currentDataList = new LinkedList<Integer>();

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            size = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (currentDataList.size() >= size) {
                return false;
            } else {
                currentDataList.clear();
                currentDataList.add(value);
                currentDataList.addAll(lastDataList);
                lastDataList.clear();
                lastDataList.addAll(currentDataList);
                return true;
            }
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (currentDataList.size() >= size) {
                return false;
            } else {
                currentDataList.clear();
                currentDataList.addAll(lastDataList);
                currentDataList.add(value);
                lastDataList.clear();
                lastDataList.addAll(currentDataList);
                return true;
            }
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (currentDataList.size() > 0) {
                currentDataList.remove(0);
                lastDataList.clear();
                lastDataList.addAll(currentDataList);
                return true;
            } else {
                return false;
            }
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (currentDataList.size() > 0) {
                currentDataList.remove(currentDataList.size() - 1);
                lastDataList.clear();
                lastDataList.addAll(currentDataList);
                return true;
            } else {
                return false;
            }
        }

        /**
         * Get the front item from the deque.
         */

        public int getFront() {
            if (currentDataList.size() > 0) {
                return currentDataList.get(0);
            } else {
                return -1;
            }
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (currentDataList.size() > 0) {
                return currentDataList.get(currentDataList.size() - 1);
            } else {
                return -1;
            }
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            if (currentDataList.size() == 0) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            if (currentDataList.size() == size) {
                return true;
            } else {
                return false;
            }
        }
    }


}
