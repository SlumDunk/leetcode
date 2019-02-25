package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 2/24/19 09:23
 * @Description: Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 */
public class Leetcode698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        return helper(nums, visited, 0, k, 0, sum / k);
    }

    /**
     * @param nums    原数组
     * @param visited 访问标记数组
     * @param start   开始位置
     * @param k       待找的子集个数
     * @param sum     当前子集的和
     * @param target  目标和值
     * @return
     */
    private boolean helper(int[] nums, boolean[] visited, int start, int k, int sum, int target) {
        if (k == 1) {
            return true;
        }

        if (sum == target) {
            return helper(nums, visited, 0, k - 1, 0, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (sum + nums[i] > target) {
                break;
            }

            visited[i] = true;
            if (helper(nums, visited, i + 1, k, sum + nums[i], target)) {
                return true;
            }

            visited[i] = false;
        }

        return false;
    }
}
