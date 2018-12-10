package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 11:23
 * @Description: You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 * because they are adjacent houses.
 * Example 2:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 */
public class Leetcode213 {
    public static void main(String[] args) {
        Leetcode213 leetcode213 = new Leetcode213();
        int[] nums = {2, 7, 9, 3, 1};
        leetcode213.dpRob(nums);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robsub(nums, 0, nums.length - 2), robsub(nums, 1, nums.length - 1));
    }

    private int robsub(int[] nums, int s, int e) {
        int n = e - s + 1;
        int[] d = new int[n];
        d[0] = nums[s];
        d[1] = Math.max(nums[s], nums[s + 1]);

        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i - 2] + nums[s + i], d[i - 1]);
        }
        return d[n - 1];
    }

    public int dpRob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1)
            return nums[0];

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        //rob first house but do not check last one
        int[] dp1 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(nums[i] + dp1[i - 2], dp1[i - 1]);
        }

        //rob last house but do not check first one
        int[] dp2 = new int[nums.length];
        dp2[0] = 0;
        dp2[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            dp2[i] = Math.max(nums[i] + dp2[i - 2], dp2[i - 1]);
        }

        return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);
    }


}
