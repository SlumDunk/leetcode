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


    public int rob__(int[] nums) {
        int len = nums.length;
        if(len==0){
            return 0;
        }
        if(len==1){
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0],nums[1]);
        } else {
            int[] copy = new int[len - 1];
            System.arraycopy(nums, 1, copy, 0, len - 1);
            int money1 = executeRob(copy);
            System.arraycopy(nums, 0, copy, 0, len - 1);
            int money2 = executeRob(copy);
            return Math.max(money1, money2);
        }
    }

    int executeRob(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len + 1][2];

        dp[0][0] = dp[0][1] = 0;

        for (int i = 1; i <= len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }

        return Math.max(dp[len][0], dp[len][1]);
    }
}
