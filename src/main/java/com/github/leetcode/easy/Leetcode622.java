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

    /**
     * 循环队列
     */
    static class MyCircularQueue {
        /**
         * 当前出队位置
         */
        private int front = 0;
        /**
         * 当前队尾位置
         */
        private int rear = -1;
        /**
         * 给队列分配的大小
         */
        private int size;
        /**
         * 真正存储数据的数据结构
         */
        List<Integer> dataList;
        /**
         * 实际队列中存储元素的个数
         */
        private int count = 0;

        /**
         * 初始化数据结构，设置队列大小为k
         */
        public MyCircularQueue(int k) {
            size = k;
            dataList = new ArrayList<Integer>(k);
            for (int i = 0; i < k; i++) {
                dataList.add(i, -1);
            }
        }

        /**
         * 往队列尾部插入一个元素
         *
         * @param value
         * @return
         */
        public boolean enQueue(int value) {
            if (getQueueSize() >= size) {
                return false;
            } else {
                //要插入的位置
                rear = (rear + 1) % size;
                dataList.set(rear, value);
                count++;
                return true;
            }
        }

        /**
         * 删除队中的元素
         *
         * @return
         */
        public boolean deQueue() {
            if (getQueueSize() <= 0) {
                return false;
            } else {
                dataList.set(front, -1);
                //变更下个要出队的元素位置
                front = (front + 1) % size;
                count--;
                return true;
            }
        }

        /**
         * 获取队首元素
         *
         * @return
         */
        public int Front() {
            if (getQueueSize() > 0) {
                return dataList.get(front);
            } else {
                return -1;
            }
        }

        /**
         * 获取队尾元素
         *
         * @return
         */
        public int Rear() {
            if (getQueueSize() > 0) {
                return dataList.get(rear);
            } else {
                return -1;
            }
        }

        /**
         * 判断队列是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return getQueueSize() == 0;
        }


        /**
         * 判断队列是否已经满了
         *
         * @return
         */
        public boolean isFull() {
            return getQueueSize() == size;
        }

        /**
         * 获取队列的实际大小
         *
         * @return
         */
        private int getQueueSize() {
            return count;
        }
    }
}
