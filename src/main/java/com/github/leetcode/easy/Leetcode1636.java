package com.github.leetcode.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 11/3/20 16:04
 * @Description: Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
 * <p>
 * Return the sorted array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 * Example 2:
 * <p>
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 * Example 3:
 * <p>
 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
 * Output: [5,-1,4,4,-6,-6,1,1,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class Leetcode1636 {

    class Pair {
        int val;
        int count;

        public Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Pair pair = map.getOrDefault(nums[i], new Pair(nums[i], 0));
            pair.count++;
            map.put(nums[i], pair);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.count == o2.count) {
                    return Integer.compare(o2.val, o1.val);
                }
                return Integer.compare(o1.count, o2.count);
            }
        });

        for (Map.Entry<Integer, Pair> entry :
                map.entrySet()) {
            pq.offer(entry.getValue());
        }
        int[] ans = new int[nums.length];
        int idx = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            for (int i = 0; i < pair.count; i++) {
                ans[idx++] = pair.val;
            }
        }
        return ans;
    }
}
