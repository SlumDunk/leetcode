package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 17:40
 * @Description: Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .
 * <p>
 * Example:
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * Note:
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 */
public class Leetcode491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();

        helper(nums, 0, new ArrayList<>(), ret);
        return ret;
    }

    /**
     * @param nums
     * @param pos  开始位置
     * @param list
     * @param ret
     */
    private void helper(int[] nums, int pos, List<Integer> list, List<List<Integer>> ret) {
        if (list.size() > 1) ret.add(new ArrayList<>(list));
        Set<Integer> set = new HashSet<>();
        for (int i = pos; i < nums.length; ++i) {
            //这一轮出现重复
            if (!set.add(nums[i])) continue;
            if (list.isEmpty() || nums[i] >= list.get(list.size() - 1)) {
                list.add(nums[i]);
                helper(nums, i + 1, list, ret);
                //back track
                list.remove(list.size() - 1);
            }
        }
    }
}
