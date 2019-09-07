package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 7/21/19 10:32
 * @Description: Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.
 * <p>
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 */
public class Leetcode1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int[] d : dominoes) {
            int k = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
            count.put(k, count.getOrDefault(k, 0) + 1);
        }
        for (int v : count.values()) {
            res += v * (v - 1) / 2;
        }
        return res;
    }
}
