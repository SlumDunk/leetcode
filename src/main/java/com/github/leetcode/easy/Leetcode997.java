package com.github.leetcode.easy;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 18:24
 * @Description: In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * <p>
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 * <p>
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 * <p>
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Example 4:
 * <p>
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * Example 5:
 * <p>
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 */
public class Leetcode997 {
    public int findJudge(int N, int[][] trust) {
        List[] map = new List[N];
        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList();
        }

        for (int[] unit :
                trust) {
            map[unit[1] - 1].add(unit[0]);
        }
        int res = -1;
        for (int i = 0; i < N; i++) {
            if (map[i].size() == N - 1) {
                res = i + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            if (map[i].contains(res)) {
                return -1;
            }
        }

        return res;
    }


    /**
     * O(n)
     *
     * @param N
     * @param trust
     * @return
     */
    public int findJudge_(int N, int[][] trust) {

        if (trust == null || trust.length == 0) {
            return N;
        }
        //key为领导人， value为人民群众
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] edge : trust) {
            int u = edge[0];
            int v = edge[1];
            Set<Integer> set = graph.getOrDefault(v, new HashSet<Integer>());
            set.add(u);
            graph.put(v, set);
        }
        int res = -1;

        for (Integer key : graph.keySet()) {
            if (graph.get(key).size() == N - 1) {
                res = key;
            }
        }

        //检查一下有没有领导人记住人民群众
        for (Integer key : graph.keySet()) {
            if (graph.get(key).contains(res)) {
                return -1;
            }
        }

        return res;
    }

}
