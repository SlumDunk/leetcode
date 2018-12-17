package com.github.leetcode.easy;

/**
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 * <p>
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 * Note: Length of the array will not exceed 10,000.
 */
public class Leetcode674 {
    public static void main(String[] args) {
        Leetcode674 leetcode674 = new Leetcode674();
        int[] nums = {1, 3, 5, 7};
        leetcode674.findLengthOfLCIS(nums);
    }

    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int max = 1;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
                max = Math.max(max, count);
            } else {//出现中断，重置为1
                count = 1;
            }
        }
        return max;
    }
}
