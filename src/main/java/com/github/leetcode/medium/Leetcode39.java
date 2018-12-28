package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/13/18 11:22
 * @Description: Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class Leetcode39 {
    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        Leetcode39 leetcode39 = new Leetcode39();
        System.out.println(leetcode39.combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //存储最终结果集
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, target, 0, 0, tmpList, resultList);
        return resultList;
    }

    /**
     * @param candidates   候选元素集合
     * @param target       目标值
     * @param sum          当前和值
     * @param currentIndex 当前开始位置
     * @param temp         缓存list
     * @param res          结果集
     */
    public void findSum(int[] candidates, int target, int sum, int currentIndex, List<Integer> temp, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        } else if (sum > target) {
            return;
        } else {
            //当前元素可以使用多次，所以指针可以从当前位置往前走 候选数字里头没有重复值，所以不需要过滤掉相同的元素
            for (int i = currentIndex; i < candidates.length; i++) {
                temp.add(candidates[i]);
                findSum(candidates, target, sum + candidates[i], i, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
