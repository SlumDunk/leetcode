package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 21:33
 * @Description: Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
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
 */
public class Leetcode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        backTrack(res, temp, nums, 0);
        return res;
    }

    /**
     * @param res        结果集
     * @param temp       中间结果
     * @param nums       数组
     * @param startIndex 开始位置
     */
    private void backTrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int startIndex) {
        res.add(new ArrayList<Integer>(temp));
        for (int i = startIndex; i < nums.length; i++) {
            temp.add(nums[i]);  //① 加入 nums[i]
            backTrack(res, temp, nums, i + 1);  //② 递归
            temp.remove(temp.size() - 1);  //③ 移除 nums[i]
        }
    }

    public static void main(String[] args) {
        Leetcode78 leetcode78 = new Leetcode78();
        System.out.println(leetcode78.subsets(new int[]{1, 2, 3}));
    }



    /**
     * O(2^n) 划分树，每次取和不取，二叉树结构， 叶子节点个数
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets__(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, result, temp, 0);

        return result;
    }

    /**
     * @param nums
     * @param result
     * @param temp
     * @param start
     */
    public void helper(int[] nums, List<List<Integer>> result, List<Integer> temp, int start) {
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
