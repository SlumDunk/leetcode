package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 21:10
 * @Description: Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Leetcode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        dfs(res, temp, n, k, 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int n, int k, int m) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = m; i <= n; i++) {
            temp.add(i);
            dfs(res, temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
