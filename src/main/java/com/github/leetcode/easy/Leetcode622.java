package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Design your implementation of the circular heap. The circular heap is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected backTrack to the first position to make a circle. It is also called ‘Ring Buffer’.
 * One of the Benefits of the circular heap is that we can make use of the spaces in front of the heap. In a normal heap, once the heap becomes full, we can not insert the next element even if there is a space in front of the heap. But using the circular heap, we can use the space to store new values.
 * Your implementation should support following operations:
 * <p>
 * MyCircularQueue(k): Constructor, set the size of the queue to be k.
 * Front: Get the front item from the heap. If the heap is empty, return -1.
 * Rear: Get the last item from the heap. If the heap is empty, return -1.
 * enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
 * deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
 * isEmpty(): Checks whether the circular queue is empty or not.
 * isFull(): Checks whether the circular queue is full or not.
 * Example:
 * <p>
 * MyCircularQueue circularQueue = new MycircularQueue(3); // set the size to be 3
 * <p>
 * circularQueue.enQueue(1);  // return true
 * <p>
 * circularQueue.enQueue(2);  // return true
 * <p>
 * circularQueue.enQueue(3);  // return true
 * <p>
 * circularQueue.enQueue(4);  // return false, the queue is full
 * <p>
 * circularQueue.Rear();  // return 3
 * <p>
 * circularQueue.isFull();  // return true
 * <p>
 * circularQueue.deQueue();  // return true
 * <p>
 * circularQueue.enQueue(4);  // return true
 * <p>
 * circularQueue.Rear();  // return 4
 */
public class Leetcode622 {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(2); // set the size to be 3

        System.out.println(circularQueue.enQueue(8));  // return true

        System.out.println(circularQueue.enQueue(8));  // return true

        System.out.println(circularQueue.Front());  // return true

        System.out.println(circularQueue.enQueue(4));  // return false, the queue is full

        System.out.println(circularQueue.deQueue());  // return 3

        System.out.println(circularQueue.enQueue(1));  // return true

        System.out.println(circularQueue.enQueue(1));  // return true

        System.out.println(circularQueue.Rear());  // return true

        System.out.println(circularQueue.isEmpty());  // return 4

        System.out.println(circularQueue.Front());

        System.out.println(circularQueue.deQueue());
    }

    static class MyCircularQueue {

        private int front = 0;
        private int rear = -1;
        private int size;
        List<Integer> dataList;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            size = k;
            dataList = new ArrayList<Integer>(k);
            for (int i = 0; i < k; i++) {
                dataList.add(i, -1);
            }
        }

        /**
         * Insert an element into thes circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (getQueueSize() >= size) {
                return false;
            } else {
                rear = (rear + 1) % size;
                dataList.set(rear, value);
                return true;
            }
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (getQueueSize() <= 0) {
                return false;
            } else {
                dataList.set(front, -1);
                front = (front + 1) % size;
                return true;
            }
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (getQueueSize() > 0) {
                return dataList.get(front);
            } else {
                return -1;
            }
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (getQueueSize() > 0) {
                return dataList.get(rear);
            } else {
                return -1;
            }
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return getQueueSize() == 0;
        }


        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return getQueueSize() == size;
        }

        private int getQueueSize() {
            int count = 0;
            for (int i = 0; i < dataList.size(); i++) {
                if (dataList.get(i) != -1) {
                    count++;
                }
            }
            return count;
        }
    }
}
