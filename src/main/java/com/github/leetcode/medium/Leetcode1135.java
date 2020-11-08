package com.github.leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

import static com.github.graph.StrongConnectedComponents.n;

/**
 * @Author: zerongliu
 * @Date: 9/14/19 13:46
 * @Description: There are N cities numbered from 1 to N.
 * <p>
 * You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together.  (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)
 * <p>
 * Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1) that connects those two cities together.  The cost is the sum of the connection costs used. If the task is impossible, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
 * Output: 6
 * Explanation:
 * Choosing any 2 edges will connect all cities so we choose the minimum 2.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: N = 4, connections = [[1,2,3],[3,4,4]]
 * Output: -1
 * Explanation:
 * There is no way to connect all cities even if all edges are used.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10000
 * 1 <= connections.length <= 10000
 * 1 <= connections[i][0], connections[i][1] <= N
 * 0 <= connections[i][2] <= 10^5
 * connections[i][0] != connections[i][1]
 */
public class Leetcode1135 {
    /**
     * 定义边的类
     */
    class Edge {
        /**
         * 起始点
         */
        int u;
        /**
         * 结束点
         */
        int v;
        /**
         * 消耗
         */
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    /**
     * 祖先数组，为union时用
     */
    int[] parent;

    /**
     * O(VE)
     *
     * @param N
     * @param connections
     * @return
     */
    public int minimumCost(int N, int[][] connections) {
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        Queue<Edge> edges = generateEdges(connections);
        int count = 0;
        int result = 0;
        //最小生成树 n-1条边
        while (count < N - 1 && edges.size() > 0) {
            Edge edge = edges.poll();
            int parentU = parent[edge.u];
            int parentV = parent[edge.v];
            //不构成环
            if (parentU != parentV) {
                count++;
                result += edge.weight;
                union(parentU, parentV);
            }

        }
        return count == N - 1 ? result : -1;
    }

    /**
     * 把u下面的子孙都归入v
     *
     * @param u
     * @param v
     */
    public void union(int u, int v) {
        for (int i = 1; i < parent.length; i++) {
            if (parent[i] == u) {
                parent[i] = v;
            }
        }
    }

    /**
     * 返回所有的边， 有序队列
     *
     * @param connections
     * @return
     */
    public Queue<Edge> generateEdges(int[][] connections) {
        Queue<Edge> priorityQueueEdges = new PriorityQueue<Edge>((a, b) -> {
            return a.weight - b.weight;
        });
        for (int[] connection : connections) {
            priorityQueueEdges.add(new Edge(connection[0], connection[1], connection[2]));
        }
        return priorityQueueEdges;
    }
}
