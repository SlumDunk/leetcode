package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 9/15/19 13:37
 * @Description: Given an array nums of integers, a move consists of choosing any element and decreasing it by 1.
 * <p>
 * An array A is a zigzag array if either:
 * <p>
 * Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * Return the minimum number of moves to transform the given array nums into a zigzag array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: 2
 * Explanation: We can decrease 2 to 0 or 3 to 1.
 * Example 2:
 * <p>
 * Input: nums = [9,6,1,6,2]
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 */
public class Leetcode1144 {
    public static void main(String[] args) {
        Leetcode1144 leetcode1144 = new Leetcode1144();
        int[] nums = new int[]{9, 6, 1, 6, 2};
        leetcode1144.movesToMakeZigzag(nums);
    }

    /**
     * 9 6 1 6 2
     *
     * 削奇数位
     * 4 6 1 6 2
     *
     * 削偶数位
     * 9 0 1 0 2
     *
     * 削峰
     *
     * @param nums
     * @return
     */
    public int movesToMakeZigzag(int[] nums) {
        int N = nums.length;
        //削奇数位峰的成本和削偶数位峰的成本
        int res1 = 0, res2 = 0;
        int before, after;

        for (int i = 0; i < N; i++) {
            //calculate adjacent neighbours - one before and one after
            before = (i - 1) >= 0 ? nums[i - 1] : Integer.MAX_VALUE;
            after = (i + 1) < N ? nums[i + 1] : Integer.MAX_VALUE;
            //calculate running count of steps for each option
            int steps = Math.max(0, nums[i] - Math.min(before, after) + 1);
            if (i % 2 == 0) res1 += steps;
            else res2 += steps;
        }
        //return min of two options
        return Math.min(res1, res2);
    }
}
