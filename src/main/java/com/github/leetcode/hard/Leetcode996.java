package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 6/8/19 13:10
 * @Description: Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
 * <p>
 * Return the number of permutations of A that are squareful.  Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,17,8]
 * Output: 2
 * Explanation:
 * [1,8,17] and [17,8,1] are the valid permutations.
 * Example 2:
 * <p>
 * Input: [2,2,2]
 * Output: 1
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 12
 * 0 <= A[i] <= 1e9
 * Accepted
 * 5.4K
 * Submissions
 * 11.4K
 */
public class Leetcode996 {
    /**
     * 是不是可以开方
     *
     * @param n
     * @return
     */
    private boolean isPerfectSquare(int n) {
        int m = (int) Math.sqrt(n);
        return Math.pow(m, 2) == n;
    }

    public int numSquarefulPerms(int[] A) {
        //存储每个数字出现的次数
        Map<Integer, Integer> count = new HashMap<>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            count.put(A[i], count.getOrDefault(A[i], 0) + 1);
        }

        //存储能组合整开方的数字 图的形式存储
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isPerfectSquare(A[i] + A[j])) {
                    Set<Integer> set = graph.getOrDefault(A[i], new HashSet<>());
                    if (!set.contains(A[j])) {
                        set.add(A[j]);
                        graph.put(A[i], set);
                    }

                    set = graph.getOrDefault(A[j], new HashSet<>());
                    if (!set.contains(A[i])) {
                        set.add(A[i]);
                        graph.put(A[j], set);
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int key : count.keySet()) {
            backtrack(graph, count, len, key, new ArrayList<>(), res);
        }

        return res.size();
    }

    /**
     * 回溯法
     *
     * @param graph
     * @param count
     * @param len   数组长度
     * @param value
     * @param temp
     * @param res
     */
    public void backtrack(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> count, int len, int value,
                          List<Integer> temp, List<List<Integer>> res) {
        if (count.get(value) == 0) return;
        //不存在跟当前数字组成能开整数方的数字
        if (!graph.containsKey(value)) return;

        count.put(value, count.get(value) - 1);
        temp.add(value);
        if (temp.size() == len) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int key : graph.get(value)) {
                backtrack(graph, count, len, key, temp, res);
            }
        }
        temp.remove(temp.size() - 1);
        count.put(value, count.get(value) + 1);
    }
}
