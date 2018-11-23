package com.github.leetcode.medium;

import com.github.leetcode.vo.Solution;

/**
 * @Author: zerongliu
 * @Date: 11/22/18 11:55
 * @Description: Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 * <p>
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * <p>
 * Example:
 * <p>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 * <p>
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 */
public class Leetcode398 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        Solution solution = new Solution(nums);
        System.out.println(solution.pick(1));
    }

}
