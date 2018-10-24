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
        leetcode39.combinationSum(candidates, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, target, 0, 0, temp, res);
        return res;
    }

    public void findSum(int[] candidates, int target, int sum, int level, List<Integer> temp, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        } else if (sum > target) {
            return;
        } else {
            for (int i = level; i < candidates.length; i++) {
                temp.add(candidates[i]);
                findSum(candidates, target, sum + candidates[i], i, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
