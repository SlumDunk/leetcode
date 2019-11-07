package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/23/19 13:28
 * @Description: Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: [2,3,1,2,4,3], s = 7
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 * <p>
 * Input: [1, 2, 3, 4, 5], s = 100
 * Output: -1
 * Challenge
 * Arrays.sort()
 * If you have figured out the O(nlog n) solution, try coding another solution of which the time complexity is O(n).
 */
public class Lintcode406 {
    /**
     * 维护一个窗口，窗口中的数字和>=s
     *
     * @param nums: an array of integers
     * @param s:    An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        int len = nums.length;

        int l = 0, r = 0, sum = 0;
        int ans = Integer.MAX_VALUE;

        for (r = 0; r < len; r++) {
            sum += nums[r];
            while (sum >= s) {
                ans = Math.min(r - l + 1, ans);
                sum -= nums[l++];
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
