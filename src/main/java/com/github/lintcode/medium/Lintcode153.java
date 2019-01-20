package com.github.lintcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/20/19 13:57
 * @Description: Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Example
 * Given candidate set [10,1,6,7,2,1,5] and target 8,
 * <p>
 * A solution set is:
 * <p>
 * [
 * [1,7],
 * [1,2,5],
 * [2,6],
 * [1,1,6]
 * ]
 * Notice
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 */
public class Lintcode153 {
    /**
     * @param num:    Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) {
            return result;
        } else {
            List<Integer> temp = new ArrayList<>();
            Arrays.sort(num);
            helper(0, temp, result, target, num);
            return result;
        }
    }

    public void helper(int index, List<Integer> temp, List<List<Integer>> result, int target, int[] num) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(temp));
        } else {
            for (int i = index; i < num.length; i++) {
                if (num[i] > target) {
                    break;
                }
                if (i != index && num[i] == num[i - 1]) {
                    continue;
                }
                temp.add(num[i]);
                helper(i + 1, temp, result, target - num[i], num);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
