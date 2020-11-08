package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 16:17
 * @Description: Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 * <p>
 * 0          3
 * |          |
 * 1 --- 2    4
 * <p>
 * Output: 2
 * Example 2:
 * <p>
 * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 * <p>
 * 0           4
 * |           |
 * 1 --- 2 --- 3
 * <p>
 * Output:  1
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class Leetcode323 {
    /**
     * O(EV)
     * union find
     *
     * @param n
     * @param edges
     * @return
     */
    public int countComponents(int n, int[][] edges) {
        int res = n;
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = -1;
        }

        for (int[] pair : edges
                ) {
            int x = find(roots, pair[0]);
            int y = find(roots, pair[1]);
            if (x != y) {
                //更新y的根祖先
                roots[x] = y;
                //连通区域减1
                res--;
            }
        }
        return res;
    }

    /**
     * 查找它的根祖先
     *
     * @param roots
     * @param x
     * @return
     */
    private int find(int[] roots, int x) {
        while (roots[x] != -1) {
            x = roots[x];
        }
        return x;
    }
}
