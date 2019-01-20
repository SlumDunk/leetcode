package com.github.lintcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/20/19 11:10
 * @Description: Given a set of distinct integers, return all possible subsets.
 * <p>
 * Example
 * If S = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * Challenge
 * Can you do it in both recursively and iteratively?
 * <p>
 * Notice
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 */
public class Lintcode17 {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        } else {
            List<Integer> temp = new ArrayList<Integer>();
            helper(result, temp, 0, nums);
            return result;
        }
    }

    public void helper(List<List<Integer>> result, List<Integer> temp, int index, int[] nums) {
        if (index > nums.length) {
            return;
        } else {
            List<Integer> list = new ArrayList<Integer>(temp);
            Collections.sort(list);
            result.add(list);
            for (int i = index; i < nums.length; i++) {
                temp.add(nums[i]);
                helper(result, temp, i + 1, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
