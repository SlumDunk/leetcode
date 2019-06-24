package com.github.leetcode.hard;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 6/20/19 12:49
 * @Description: Given an array A of integers, return the number of non-empty continuous subarrays that satisfy the following condition:
 * <p>
 * The leftmost element of the subarray is not larger than other elements in the subarray.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,4,2,5,3]
 * Output: 11
 * Explanation: There are 11 valid subarrays: [1],[4],[2],[5],[3],[1,4],[2,5],[1,4,2],[2,5,3],[1,4,2,5],[1,4,2,5,3].
 * Example 2:
 * <p>
 * Input: [3,2,1]
 * Output: 3
 * Explanation: The 3 valid subarrays are: [3],[2],[1].
 * Example 3:
 * <p>
 * Input: [2,2,2]
 * Output: 6
 * Explanation: There are 6 valid subarrays: [2],[2],[2],[2,2],[2,2],[2,2,2].
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 50000
 * 0 <= A[i] <= 100000
 */
public class Leetcode1063 {
    public static void main(String[] args) {
        Leetcode1063 leetcode1063 = new Leetcode1063();
        int[] nums = new int[]{1, 4, 2, 5, 3};
        leetcode1063.validSubarrays(nums);
    }

    public int validSubarrays(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {//维护一个最小递增栈，作为左边界的下标
                count += (i - stack.pop());
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) { //出栈
            count += (nums.length - stack.pop());
        }
        return count;
    }
}
