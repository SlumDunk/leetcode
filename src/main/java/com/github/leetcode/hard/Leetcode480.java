package com.github.leetcode.hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 5/7/19 20:19
 * @Description: Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * <p>
 * Examples:
 * [2,3,4] , the median is 3
 * <p>
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.
 * <p>
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * <p>
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7       -1
 * 1  3 [-1  -3  5] 3  6  7       -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 * <p>
 * Note:
 * You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
 */
public class Leetcode480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int index = 0, limit = (k + 1) / 2, k1 = k - 1;
        PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder()), hi = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            hi.add(nums[i]);
            if (lo.size() > 0 && lo.peek() > hi.peek()) {
                lo.add(hi.poll());
                hi.add(lo.poll());
            }
            if (hi.size() > limit) lo.add(hi.poll());
            if (i >= k1) {
                result[index++] = hi.size() > lo.size() ? hi.peek() : (hi.peek() / 2.0d) + (lo.peek() / 2.0d);
                int remove = nums[i - k + 1];
                if (remove < hi.peek()) lo.remove(remove);
                else hi.remove(remove);
            }
        }
        return result;
    }
}
