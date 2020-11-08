package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/21/19 21:24
 * @Description: You are given a circular array nums of positive and negative integers. If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is circular, you may assume that the last element's children element is the first element, and the first element's previous element is the last element.
 * <p>
 * Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must not consist of both forward and backward movements.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,-1,1,2,2]
 * Output: true
 * Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
 * Example 2:
 * <p>
 * Input: [-1,2]
 * Output: false
 * Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1. By definition the cycle's length must be greater than 1.
 * Example 3:
 * <p>
 * Input: [-2,1,-1,-2,-2]
 * Output: false
 * Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.
 * <p>
 * <p>
 * Note:
 * <p>
 * -1000 ≤ nums[i] ≤ 1000
 * nums[i] ≠ 0
 * 1 ≤ nums.length ≤ 5000
 * <p>
 * <p>
 * Follow up:
 * <p>
 * Could you solve it in O(n) time complexity and O(1) extra space complexity?
 */
public class Leetcode457 {
    public static void main(String[] args) {
        Leetcode457 leetcode457 = new Leetcode457();
        int[] nums = new int[]{-1};
        leetcode457.circularArrayLoop(nums);
    }

    public boolean circularArrayLoop(int[] nums) {
        boolean found = false;

        for (int n = 0; n < nums.length; n++) {
            Integer ps = n;
            Integer pf = next(nums, 0, n);
            int dir = nums[n];

            while (ps != null && pf != null && ps != pf) {
                ps = next(nums, dir, ps);
                pf = next(nums, dir, next(nums, dir, pf));
            }

            if (ps != null && ps == pf) {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * @param nums
     * @param dir  方向
     * @param pos  当前位置
     * @return
     */
    Integer next(int[] nums, int dir, Integer pos) {
        if (pos == null) return null; // null, return null
        if (dir * nums[pos] < 0) return null; // change in direction, return null

        Integer next = (pos + nums[pos]) % nums.length;
        if (next < 0) next += nums.length; // wrap negative

        if (next == pos) next = null; // self-pointer, return null
        return next;
    }
}
