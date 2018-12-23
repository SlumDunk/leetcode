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

    public static void main(String[] args) {

        int[] nums = {8, 5, 4, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(6));
        System.out.println(kthLargest.add(4));
    }

    static class KthLargest {
        int k;
        PriorityQueue<Integer> queue;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            queue = new PriorityQueue<>();
            if (nums.length <= k) {
                for (int ele : nums
                        ) {
                    queue.add(ele);
                }
            } else {
                for (int i = 0; i < k; i++) {
                    queue.add(nums[i]);
                }
                for (int i = k; i < nums.length; i++) {
                    if (queue.peek() < nums[i]) {
                        queue.poll();
                        queue.add(nums[i]);
                    }
                }
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.offer(val);
            } else if (queue.peek() < val) {
                queue.poll();
                queue.offer(val);
            }
            return queue.peek();
        }
    }
}

