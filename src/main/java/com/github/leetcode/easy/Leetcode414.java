package com.github.leetcode.easy;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 8/30/18 19:30
 * @Description: Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 * <p>
 * Example 1:
 * Input: [3, 2, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * <p>
 * Output: 2
 * <p>
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class Leetcode414 {
    public static void main(String[] args) {
        Leetcode414 leetcode414 = new Leetcode414();
        int[] nums = {Integer.MIN_VALUE, 1, 1};
        System.out.println(leetcode414.thirdMax(nums));
    }

    public int thirdMax(int[] nums) {
        //进行排序
        Arrays.sort(nums);
        if (nums.length < 3) {
            return nums[nums.length - 1];
        } else {
            int max = Integer.MAX_VALUE;
            int count = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] < max) {
                    max = nums[i];
                    count++;
                }
                if (count == 3) {
                    return max;
                }
            }
            return nums[nums.length - 1];
        }
    }
}
