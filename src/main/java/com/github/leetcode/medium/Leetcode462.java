package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 18:08
 * @Description: Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 * <p>
 * You may assume the array's length is at most 10,000.
 * <p>
 * Example:
 * <p>
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * <p>
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class Leetcode462 {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        //先排序
        Arrays.sort(nums);
        //两侧往中间走 求两点的距离
        int i = 0, j = nums.length - 1, res = 0;
        while (i < j) {
            res += nums[j--] - nums[i++];
        }
        return res;
    }
}
