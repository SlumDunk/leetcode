package com.github.lintcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 1/26/19 22:49
 * @Description: Numbers keep coming, return the median of numbers at every time a new number added.
 * <p>
 * Example
 * For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].
 * <p>
 * For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].
 * <p>
 * For numbers coming list: [2, 20, 100], return [2, 2, 20].
 * <p>
 * Challenge
 * Total run time in O(nlogn).
 * <p>
 * Clarification
 * What's the definition of Median?
 * <p>
 * Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.
 */
public class Lintcode81 {
    private PriorityQueue<Integer> maxHeap, minHeap;
    private int numOfElements = 0;

    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        //用最大堆保存左半部分的数，最小堆保存右半部分的数
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer left, Integer right) {
                return right.compareTo(left);
            }
        };

        int len = nums.length;
        //左半部分堆顶放的总是数据流的中位数
        maxHeap = new PriorityQueue<Integer>(len, comparator);
        minHeap = new PriorityQueue<Integer>(len);
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            addNumber(nums[i]);
            result[i] = getMedian();
        }
        return result;
    }

    public void addNumber(int value) {
        maxHeap.add(value);
        numOfElements++;
        if (numOfElements % 2 == 1) {//奇数个数的时候
            if (minHeap.isEmpty()) {
                return;
            } else if (maxHeap.peek() > minHeap.peek()) {
                Integer maxHeapRoot = maxHeap.poll();
                Integer minHeapRoot = minHeap.poll();
                maxHeap.add(minHeapRoot);
                minHeap.add(maxHeapRoot);
            }
        } else {//偶数个数的时候，保证两个堆元素个数差不大于1
            minHeap.add(maxHeap.poll());
        }
    }

    int getMedian() {
        return maxHeap.peek();
    }
}
