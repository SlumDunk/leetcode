package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 1/4/19 10:57
 * @Description: Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the maxHeap sliding window.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array'word size for non-empty array.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 */
public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        } else {
            int len = nums.length;
            int[] result = new int[len - k + 1];
            //结果集中下一个要放置元素的位置
            int index = 0;
            //双向队列 用于存储当前滑动窗口中的数字的位置索引
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < len; i++) {
                //修正左边界 [i-k+1,i]
                while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                    //移除头部元素
                    queue.poll();
                }
                //保证队列头部放置的是窗口的最大元素 移除[i-k+1,i]中比nums[i]小的元素
                while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                    queue.pollLast();
                }
                //往尾部插入元素
                queue.offer(i);
                if (i >= k - 1) {
                    result[index] = nums[queue.peek()];
                    index++;
                }
            }
            return result;
        }

    }


    public int[] maxSlidingWindow__(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        int len = nums.length;
        //store index position of each item
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!dq.isEmpty() && dq.peek() < i + 1 - k) {
                dq.poll();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            if (i >= k - 1) {
                result.add(nums[dq.peek()]);
            }

        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    public int[] maxSlidingWindow_(int[] nums, int k) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            //remove elements outside the boundary
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            //compare the one come after the current maximum, just keep the max one
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);

            if (i >= k - 1) {
                result.add(queue.peek());
            }
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = nums[result.get(i)];
        }

        return ans;
    }


    /**
     * O(N)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow___(int[] nums, int k) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        // head of the queue is the maximum one in each window
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            //handle elements that out of boundary
            while (!deque.isEmpty() && (i - k + 1 > deque.peek())) {
                deque.poll();
            }
            //just keep the elements that greater than current num
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);
            if (i >= k - 1) {
                result.add(deque.peek());
            }
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = nums[result.get(i)];
        }

        return ans;
    }

    public int[] maxSlidingWindow____(int[] nums, int k) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        //最长维护一个长度为k的双向队列 维护一个递减队列
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            //处理越界问题
            while (!deque.isEmpty() && i - k + 1 > deque.peek()) {
                deque.pollFirst();
            }

            //是否需要调整窗口内的最大值,队列头部放置的始终是窗口内的最大值
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                //因为都在同一个大小为k的窗口内
                deque.pollLast();
            }
            //i进入队列
            deque.offerLast(i);
            if (i >= k - 1) {
                result.add(deque.peekFirst());
            }
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = nums[result.get(i)];
        }

        return ans;
    }
}
