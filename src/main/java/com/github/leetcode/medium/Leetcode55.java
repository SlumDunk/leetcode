package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 10:58
 * @Description: Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 */
public class Leetcode55 {

    public boolean canJump(int[] nums) {
        int reach = nums[0];
        for (int i = 1; i < nums.length && reach >= i; i++)
            if (i + nums[i] > reach) reach = i + nums[i];  //贪心策略
        return reach >= (nums.length - 1) ? true : false;
    }
}
