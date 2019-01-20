package com.github.lintcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/20/19 11:52
 * @Description: Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Example
 * Input: [1,2,2]
 * Output:
 * <p>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * Challenge
 * Can you do it in both recursively and iteratively?
 * <p>
 * Notice
 * Each element in a subset must be in non-descending order.
 * The ordering between two subsets is free.
 * The solution set must not contain duplicate subsets.
 */
public class Lintcode18 {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        } else {
            List<Integer> temp = new ArrayList<Integer>();
            Arrays.sort(nums);
            helper(result, temp, 0, nums);
            return result;
        }

    }

    public void helper(List<List<Integer>> result, List<Integer> temp, int index, int[] nums) {
        if (index > nums.length) {
            return;
        } else {
            List<Integer> list = new ArrayList<>(temp);
            Collections.sort(list);
            result.add(list);
            for (int i = index; i < nums.length; i++) {
                if (i != index && nums[i] == nums[i - 1]) {
                    continue;
                }
                temp.add(nums[i]);
                helper(result, temp, i + 1, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
