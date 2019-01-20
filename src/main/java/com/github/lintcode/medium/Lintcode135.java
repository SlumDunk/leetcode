package com.github.lintcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/20/19 13:49
 * @Description: Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Example
 * Given candidate set [2,3,6,7] and target 7, a solution set is:
 * <p>
 * [7]
 * [2, 2, 3]
 * Notice
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 */
public class Lintcode135 {
    /**
     * @param candidates: A list of integers
     * @param target:     An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            result.add(new ArrayList<>());
            return result;
        } else {
            List<Integer> temp = new ArrayList<>();
            Arrays.sort(candidates);
            helper(candidates, 0, temp, result, target);
            return result;
        }
    }

    public void helper(int[] candidates, int index, List<Integer> temp, List<List<Integer>> result, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(temp));
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    break;
                }
                if (i != index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                temp.add(candidates[i]);
                helper(candidates, i, temp, result, target - candidates[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
