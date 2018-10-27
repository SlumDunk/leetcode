package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 12:43
 * @Description: Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * Note:
 * <p>
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Leetcode216 {
    private void find(int from, int sum, int[] nums, int step, List<List<Integer>> results) {
        if (sum < 0) return;
        if (step == nums.length) {
            if (sum == 0) {
                Integer[] n = new Integer[nums.length];
                for(int i=0; i<step; i++) n[i] = nums[i];
                results.add(Arrays.asList(n));
            }
            return;
        }
        for(int i=from; i<10 && i<=sum; i++) {
            nums[step] = i;
            find(i+1, sum-i, nums, step+1, results);
        }

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        find(1, n, new int[k], 0, results);
        return results;
    }
}
