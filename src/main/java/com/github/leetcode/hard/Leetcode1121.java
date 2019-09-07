package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 7/24/19 13:42
 * @Description: Given a non-decreasing array of positive integers nums and an integer K, find out if this array can be divided into one or more disjoint increasing subsequences of length at least K.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,2,3,3,4,4], K = 3
 * Output: true
 * Explanation:
 * The array can be divided into the two subsequences [1,2,3,4] and [2,3,4] with lengths at least 3 each.
 * Example 2:
 * <p>
 * Input: nums = [5,6,6,7,8], K = 3
 * Output: false
 * Explanation:
 * There is no way to divide the array using the conditions required.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= K <= nums.length
 * 1 <= nums[i] <= 10^5
 */
public class Leetcode1121 {
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        int cur = 1, groups = 1, n = nums.length;
        //有序数组
        for (int i = 1; i < n; ++i) {
            //遇到相等的，得split
            cur = nums[i - 1] < nums[i] ? 1 : cur + 1;
            groups = Math.max(groups, cur);
        }
        return n >= K * groups;
    }
}
