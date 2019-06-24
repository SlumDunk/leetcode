package com.github.leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 6/7/19 22:20
 * @Description: Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.
 * <p>
 * Example 1:
 * Input:
 * nums = [1,3,1]
 * k = 1
 * Output: 0
 * Explanation:
 * Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 * Note:
 * 2 <= len(nums) <= 10000.
 * 0 <= nums[i] < 1000000.
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 */
public class Leetcode719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);//sort input from small to large
        int n = nums.length, low = 0, high = 1000000;
        while (low < high) {
            int mid = (low + high) / 2, cnt = 0;
            for (int i = 0, j = 0; i < n; i++) {//2 pointers from begin and end
                while (j < n && nums[j] - nums[i] <= mid)
                    j++;
                cnt += j - i - 1;
            }
            if (cnt < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
