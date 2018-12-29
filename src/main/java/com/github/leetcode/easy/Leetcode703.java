package com.github.leetcode.easy;

import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 9/1/18 19:07
 * @Description: Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 * <p>
 * Example:
 * <p>
 * int k = 3;
 * int[] arr = [8,5,4,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 */
public class Leetcode703 {

    class KthLargest {
        //只保存最大的k个值
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                if (heap.size() == k) {
                    if (heap.peek() < num) {
                        heap.poll();
                        heap.add(num);
                    }
                } else {
                    heap.add(num);
                }

            }
        }

        public int add(int val) {
            if (heap.size() == k) {
                if (heap.peek() < val) {
                    heap.poll();
                    heap.add(val);
                }
            } else {
                heap.add(val);
            }
            return heap.peek();
        }
    }
}

