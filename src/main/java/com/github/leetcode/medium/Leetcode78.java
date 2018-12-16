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
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        List<Integer> temp = new ArrayList<Integer>();
//        dfs(res, temp, nums, 0);
//        return res;
//    }
//
//    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int j) {
//        res.add(new ArrayList<Integer>(temp));
//        for (int i = j; i < nums.length; i++) {
//            temp.add(nums[i]);  //① 加入 nums[i]
//            dfs(res, temp, nums, i + 1);  //② 递归
//            temp.remove(temp.size() - 1);  //③ 移除 nums[i]
//        }
//    }

    public static void main(String[] args) {
        Leetcode78 leetcode78 = new Leetcode78();
        System.out.println(leetcode78.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int num : nums) {  // ①从数组中取出每个元素
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(res.get(i));  // ②逐一取出中间结果集
                temp.add(num);  // ③将 num 放入中间结果集
                res.add(temp);  // ④加入到结果集中
            }
        }
        return res;

    }
}
