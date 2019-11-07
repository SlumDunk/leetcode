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
        backTrack(0, new ArrayList<>(), len, nums, res);
        return res;
    }

    /**
     * @param start 开始位置
     * @param ans   中间结果集
     * @param len   数组长度
     * @param nums  数组
     * @param res   结果集
     */
    public void backTrack(int start, List<Integer> ans, int len, int[] nums, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(ans));
        for (int i = start; i < len; i++) {
            if (i > start && nums[i] == nums[i - 1])//往前重复的元素跳过
                continue;
            //将元素添加到中间结果集
            ans.add(nums[i]);
            //继续往前
            backTrack(i + 1, ans, len, nums, res);
            //回溯移除元素
            ans.remove(ans.size() - 1);
        }
        return;
    }


    /**
     * O(2^N)
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup__(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        } else {
            List<Integer> temp = new ArrayList<>();
            Arrays.sort(nums);
            helper(nums, result, temp, 0);
            return result;
        }
    }

    public void helper(int[] nums, List<List<Integer>> result, List<Integer> temp, int start) {
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, result, temp, i + 1);
            temp.remove(temp.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}
