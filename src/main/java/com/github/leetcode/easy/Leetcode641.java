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

    /**
     * 循环双向队列
     */
    private static class MyCircularDeque {
        /**
         * 实际存储数据的结构
         */
        private int[] values;
        /**
         * 开始位置 即队头
         */
        private int start;
        /**
         * 队列的大小
         */
        private int max_size;
        /**
         * 队列的实际大小
         */
        private int current_size;


        /**
         * 初始化数据结构，设置队列的大小
         */
        public MyCircularDeque(int k) {
            values = new int[k];
            start = 0;
            current_size = 0;
            max_size = k;
        }

        /**
         * 往队列的头部插入元素
         *
         * @param value
         * @return
         */
        public boolean insertFront(int value) {
            if (current_size == max_size) {
                return false;
            } else {
                values[start] = value;
                //start指针前移
                start = (start + max_size - 1) % max_size;
                current_size++;
                return true;
            }
        }

        /**
         * 往队列末尾插入元素
         *
         * @param value
         * @return
         */
        public boolean insertLast(int value) {
            if (current_size == max_size) {
                return false;
            } else {
                //往末尾插入元素
                values[(start + current_size + 1) % max_size] = value;
                current_size++;
                return true;
            }
        }

        /**
         * 删除头部元素
         *
         * @return
         */
        public boolean deleteFront() {
            if (current_size == 0) {
                return false;
            } else {
                current_size--;
                //指针后移
                start = (start + 1) % max_size;
                return true;
            }
        }

        /**
         * 删除尾部元素
         *
         * @return
         */
        public boolean deleteLast() {
            if (current_size == 0) {
                return false;
            } else {
                current_size--;
                return true;
            }
        }

        /**
         * 获取头部元素
         *
         * @return
         */
        public int getFront() {
            if (current_size == 0) {
                return -1;
            }
            //因为往头部插入元素的时候，start指针发生了前移
            return values[(start + 1) % max_size];
        }

        /**
         * 获取尾部元素
         *
         * @return
         */
        public int getRear() {
            if (current_size == 0) {
                return -1;
            }
            return values[(start + current_size) % max_size];
        }

        /**
         * 判断队列是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return current_size == 0;
        }

        /**
         * 判断队列是否满了
         *
         * @return
         */
        public boolean isFull() {
            return current_size == max_size;
        }
    }
}
