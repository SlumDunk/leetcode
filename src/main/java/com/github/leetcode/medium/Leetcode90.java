package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 13:00
 * @Description: Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class Leetcode90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        sub(0, new ArrayList<>(), len, nums, res);
        return res;
    }

    public void sub(int start, List<Integer> ans, int len, int[] nums, List<List<Integer>> res) {
        for (int i = start; i < len; i++) {
            if (i > start && nums[i] == nums[i - 1])//往前重复的元素跳过
                continue;
            ans.add(nums[i]);
            res.add(new ArrayList<Integer>(ans));
            sub(i + 1, ans, len, nums, res);
            ans.remove(ans.size() - 1);
        }
        return;
    }
}
