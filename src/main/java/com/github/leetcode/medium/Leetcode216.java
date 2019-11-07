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
    public static void main(String[] args) {
        Leetcode216 leetcode216 = new Leetcode216();
        leetcode216.combinationSum3(3, 7);
    }

    /**
     * @param from    开始值
     * @param sum     目标和值
     * @param temp    中间结果值
     * @param count   中间结果数字个数
     * @param results 结果集
     * @param k       中间结果目标数量
     */
    private void find(int from, int sum, List<Integer> temp, int count, List<List<Integer>> results, int k) {
        //目标和值小于0，直接返回
        if (sum < 0) return;
        //个数相同
        if (count == k) {
            //目标和值等于0
            if (sum == 0) {
                results.add(new ArrayList<Integer>(temp));
            }
            return;
        }

        for (int i = from; i < 10 && i <= sum; i++) {
            //中间结果集加上
            temp.add(i);
            find(i + 1, sum - i, temp, count + 1, results, k);
            //回溯移除i
            temp.remove(temp.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> temp = new ArrayList<Integer>();
        find(1, n, temp, 0, results, k);
        return results;
    }


    /**
     * O(n^k)
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3__(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        helper(result, temp, k, n, 1);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> temp, int k, int n, int pos) {
        if (temp.size() == k && n == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = pos; i <= 9; i++) {
                if (i > n) {
                    return;
                } else {
                    temp.add(i);
                    helper(result, temp, k, n - i, i + 1);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
