package com.github.leetcode.hard;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 6/20/19 13:45
 * @Description: Given a non-empty array of unique positive integers A, consider the following graph:
 * <p>
 * There are A.length nodes, labelled A[0] to A[A.length - 1];
 * There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
 * Return the size of the largest connected component in the graph.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [4,6,15,35]
 * Output: 4
 * <p>
 * Example 2:
 * <p>
 * Input: [20,50,9,63]
 * Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: [2,3,6,7,4,12,21,39]
 * Output: 8
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= 100000
 */
public class Leetcode952 {
    /**
     * 每个节点的信息
     */
    class Item {
        int root;
        int cnt;

        Item(int root, int cnt) {
            this.root = root;
            this.cnt = cnt;
        }
    }

    /**
     * 查找最终的根节点
     *
     * @param parents
     * @param id
     * @return
     */
    int find(Item[] parents, int id) {
        if (parents[id].root != id) {
            parents[id].root = find(parents, parents[id].root);
        }
        return parents[id].root;
    }

    /**
     * 合并节点
     *
     * @param parents
     * @param id1
     * @param id2
     */
    void union(Item[] parents, int id1, int id2) {
        int p1 = find(parents, id1);
        int p2 = find(parents, id2);
        if (p1 != p2) {
            parents[p2].root = p1;
            parents[p1].cnt += parents[p2].cnt;
        }
    }

    public int largestComponentSize(int[] A) {
        int n = A.length;

        Set<Integer> vis = new HashSet<>();
        for (int num : A) {
            vis.add(num);
        }
        //注意题目给出的节点的数量的边界值
        Item[] parents = new Item[100001];
        //节点数值的边界值
        for (int i = 0; i <= 100000; ++i) {
            parents[i] = new Item(i, 1);
        }
        //key为因子，value为数值
        Map<Integer, Integer> pf = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int f = 1; (long) f * f <= A[i]; ++f) {
                if (A[i] % f == 0) {//能整除
                    if (!pf.containsKey(f)) {
                        pf.put(f, A[i]);
                    }
                    if (!pf.containsKey(A[i] / f)) {
                        pf.put(A[i] / f, A[i]);
                    }

                    if (f != 1) {
                        union(parents, pf.get(f), A[i]);
                    }
                    if (A[i] / f != 1) {
                        union(parents, pf.get(A[i] / f), A[i]);
                    }
                }
            }
        }

        int res = 0;
        //比较求出最大的连通分量
        for (Integer value :
                vis) {
            if (parents[value].root == value) {
                res = Math.max(res, parents[value].cnt);
            }
        }
        return res;
    }
}
