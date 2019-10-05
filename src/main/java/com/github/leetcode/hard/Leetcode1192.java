package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 9/16/19 08:32
 * @Description: There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.
 * <p>
 * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
 * <p>
 * Return all critical connections in the network in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5
 * n-1 <= connections.length <= 10^5
 * connections[i][0] != connections[i][1]
 * There are no repeated connections.
 */
public class Leetcode1192 {
    public static void main(String[] args) {
        Leetcode1192 leetcode1192 = new Leetcode1192();
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        leetcode1192.criticalConnections(4, connections);

    }

    int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //找不在环上面的边,不在强连通边量上的边
        int[] disc = new int[n], low = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> res = new ArrayList<>();

        Arrays.fill(disc, -1);
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < connections.size(); i++) {
            int from = connections.get(i).get(0);
            int to = connections.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                helper(i, low, disc, graph, res, 0);
            }
        }
        return res;
    }

    /**
     * @param node  当前节点
     * @param low   各节点所属的连通分量数组
     * @param disc  各个节点的发现顺序
     * @param graph 图
     * @param res   结果集
     * @param pre   父节点
     */
    public void helper(int node, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int pre) {
        disc[node] = low[node] = ++time;
        for (int j = 0; j < graph[node].size(); j++) {
            int v = graph[node].get(j);
            //跟有向图不同的地方
            if (v == pre) {
                continue;
            }
            if (disc[v] == -1) {
                helper(v, low, disc, graph, res, node);
                low[node] = Math.min(low[node], low[v]);
                if (low[v] > disc[node]) {//不属于同一个连通分量
                    res.add(Arrays.asList(node, v));
                }
            } else {//更新当前节点所属的连通分量
                low[node] = Math.min(low[node], disc[v]);
            }
        }
    }
}
