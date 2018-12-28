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
}
