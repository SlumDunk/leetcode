package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 4/23/21 20:29
 * @Description: Given an array nums of 0s and 1s and an integer k, return True if all 1's are at least k places away from each other, otherwise return False.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: nums = [1,0,0,0,1,0,0,1], k = 2
 * Output: true
 * Explanation: Each of the 1s are at least 2 places away from each other.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: nums = [1,0,0,1,0,1], k = 2
 * Output: false
 * Explanation: The second 1 and third 1 are only one apart from each other.
 * Example 3:
 * <p>
 * Input: nums = [1,1,1,1,1], k = 0
 * Output: true
 * Example 4:
 * <p>
 * Input: nums = [0,1,0,1], k = 1
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= k <= nums.length
 * nums[i] is 0 or 1
 */
public class Leetcode1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int lastIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastIndex == -1) {
                    lastIndex = i;
                    continue;
                } else {
                    if (i - lastIndex-1 < k) {
                        return false;
                    }
                    lastIndex = i;
                }
            }
        }
        return true;
    }
}
