package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [5,5,4], k = 1
 * Output: 1
 * Explanation: Remove the single 4, only 5 is left.
 * Example 2:
 * Input: arr = [4,3,1,1,3,3,2], k = 3
 * Output: 2
 * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 */
public class Leetcode1481 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (arr == null) {
            return 0;
        }
        int n = arr.length;
        if (n <= k) {
            return 0;
        } else {
            Arrays.sort(arr);
            Queue<Integer> minHeap = new PriorityQueue<>();
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i] == arr[i - 1]) {
                    count++;
                } else {
                    minHeap.offer(count);
                    count = 1;
                }
            }
            minHeap.offer(count);
            while (k > 0 && !minHeap.isEmpty()) {
                if (k >= minHeap.peek()) {
                    Integer val = minHeap.poll();
                    k -= val;
                } else {
                    break;
                }
            }
            return minHeap.size();
        }
    }
}
