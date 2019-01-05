package com.github.leetcode.hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 1/4/19 14:15
 * @Description: Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * <p>
 * For example,
 * [2,3,4], the median is 3
 * <p>
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * <p>
 * <p>
 * Example:
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * <p>
 * <p>
 * Follow up:
 * <p>
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class Leetcode295 {
    /**
     * 寻找中位数
     */
    class MedianFinder {
        /**
         * 最小堆，用于存储大数值
         */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        /**
         * 最大堆，用于存储小数值
         */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1024, Collections.reverseOrder());

        /**
         * 初始化数据结构
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            //保证两个堆能够平分所有的数
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }
        }
    }
}
