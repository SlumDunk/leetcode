package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/4/19 15:54
 * @Description: Numbers can be regarded as product of its factors. For example,
 * <p>
 * 8 = 2 x 2 x 2;
 * = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * <p>
 * Note:
 * <p>
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * Example 1:
 * <p>
 * Input: 1
 * Output: []
 * Example 2:
 * <p>
 * Input: 37
 * Output:[]
 * Example 3:
 * <p>
 * Input: 12
 * Output:
 * [
 * [2, 6],
 * [2, 2, 3],
 * [3, 4]
 * ]
 * Example 4:
 * <p>
 * Input: 32
 * Output:
 * [
 * [2, 16],
 * [2, 2, 8],
 * [2, 2, 2, 4],
 * [2, 2, 2, 2, 2],
 * [2, 4, 4],
 * [4, 8]
 * ]
 */
public class Leetcode254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        helper(result, tempList, n, 2);
        return result;
    }

    /**
     * @param result
     * @param tempList
     * @param n
     * @param start    开始位置
     */
    private void helper(List<List<Integer>> result, List<Integer> tempList, int n, int start) {
        if (n == 1) {
            if (tempList.size() > 1) {
                result.add(new ArrayList<>(tempList));
                return;
            }
        } else {
            for (int i = start; i <= n; i++) {
                if (n % i == 0) {
                    tempList.add(i);
                    helper(result, tempList, n / i, i);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
