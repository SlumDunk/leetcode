package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 07:29
 * @Description: In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.
 * <p>
 * Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.
 * <p>
 * Which nodes are eventually safe?  Return them as an array in sorted order.
 * <p>
 * The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.
 * <p>
 * Example:
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Here is a diagram of the above graph.
 * <p>
 * Illustration of graph
 * <p>
 * Note:
 * <p>
 * graph will have length at most 10000.
 * The number of edges in the graph will not exceed 32000.
 * Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].
 */
public class Leetcode802 {
    /**
     * 找环 dfs 拓扑排序
     *
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        Set<Integer>[] rg = new HashSet[N];
        for (int i = 0; i < N; i++) {
            rg[i] = new HashSet<>();
        }

        int[] outDegrees = new int[N];
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int nei : graph[i]) {
                //节点的入度情况
                rg[nei].add(i);
                //节点i的出度
                outDegrees[i]++;
            }
            //出度为0的点先入队列
            if (outDegrees[i] == 0) {
                que.offer(i);
            }
        }

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int nei : rg[cur]) {
                outDegrees[nei]--;
                if (outDegrees[nei] == 0) {
                    que.offer(nei);
                }
            }
        }

        List<Integer> res = new ArrayList();
        for (int i = 0; i < N; ++i)
            if (outDegrees[i] == 0) res.add(i);

        return res;
    }
}
