package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 11/15/18 20:17
 * @Description: Given an integer n, return 1 - n in lexicographical order.
 * <p>
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * <p>
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 */
public class Leetcode386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        for (int i = 1; i <= 9; i++) {
            if (i > n) break;
            dfs(i, res, n);
        }
        return res;
    }

    private void dfs(int i, List<Integer> res, int n) {
        res.add(i);
        for (int m = 0; m <= 9; m++) {
            if (i * 10 + m > n) break;
            dfs(i * 10 + m, res, n);
        }
    }
}
