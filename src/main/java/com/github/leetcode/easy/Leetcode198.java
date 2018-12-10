package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/9/18 22:02
 * @Description: You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class Leetcode198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //[][0]存储抢第n个的累积收益和[][1]不抢第n个的累积收益
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][1] + nums[i];//不抢第i-1家，抢i家
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
