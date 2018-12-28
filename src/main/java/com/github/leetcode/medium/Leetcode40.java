package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/13/18 11:42
 * @Description: Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */
public class Leetcode40 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, target, 0, 0, temp, res);
        return res;
    }

    /**
     * @param candidates
     * @param target
     * @param sum
     * @param currentIndex
     * @param temp
     * @param res
     */
    public void findSum(int[] candidates, int target, int sum, int currentIndex, List<Integer> temp, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        } else if (sum > target) {
            return;
        } else {
            for (int i = currentIndex; i < candidates.length; i++) {
                temp.add(candidates[i]);
                //从当前位置的下一个位置开始，因为每个位置的数字只能用一次
                findSum(candidates, target, sum + candidates[i], i + 1, temp, res);
                temp.remove(temp.size() - 1);
                //候选数字里头会有重复值
                while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) {
                    i++;
                }
            }
        }
    }
}
