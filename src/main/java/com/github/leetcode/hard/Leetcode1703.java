package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array, nums, and an integer k. nums comprises of only 0's and 1's. In one move, you can choose two adjacent indices and swap their values.
 * <p>
 * Return the minimum number of moves required so that nums has k consecutive 1's.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,0,0,1,0,1], k = 2
 * Output: 1
 * Explanation: In 1 move, nums could be [1,0,0,0,1,1] and have 2 consecutive 1's.
 * Example 2:
 * <p>
 * Input: nums = [1,0,0,0,0,0,1,1], k = 3
 * Output: 5
 * Explanation: In 5 moves, the leftmost 1 can be shifted right until nums = [0,0,0,0,0,1,1,1].
 * Example 3:
 * <p>
 * Input: nums = [1,1,0,1], k = 2
 * Output: 0
 * Explanation: nums already has 2 consecutive 1's.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] is 0 or 1.
 * 1 <= k <= sum(nums)
 */
public class Leetcode1703 {
    /**
     * https://www.youtube.com/watch?v=Il5sSd-AReI
     *
     * @param nums
     * @param k
     * @return
     */
    public int minMoves(int[] nums, int k) {
        if (k <= 1) return 0;
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) ones.add(i);
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += Math.abs(ones.get(i) - ones.get(k / 2));
        }
        int ret = sum;
        // i 表示滑动的位置
        for (int i = 0; i + k < ones.size(); i++) {
            int mid = i + k / 2;
            sum -= Math.abs(ones.get(i) - ones.get(mid));
            sum += Math.abs(ones.get(mid + 1) - ones.get(mid)) * (k / 2);
            sum += Math.abs(ones.get(i + k) - ones.get(mid + 1));
            sum -= Math.abs(ones.get(mid + 1) - ones.get(mid)) * (k - k / 2 - 1);
            ret = Math.min(ret, sum);
        }

        int offset = 0;
        for (int i = 0; i < k; i++) {
            offset += Math.abs(i - k / 2);
        }

        return ret - offset;
    }
}
