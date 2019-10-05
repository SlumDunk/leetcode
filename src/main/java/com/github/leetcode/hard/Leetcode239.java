package com.github.leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
}
