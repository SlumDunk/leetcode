package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 6/20/19 15:26
 * @Description: Starting with an undirected graph (the "original graph") with nodes from 0 to N-1, subdivisions are made to some of the edges.
 * <p>
 * The graph is given as follows: edges[k] is a list of integer pairs (i, j, n) such that (i, j) is an edge of the original graph,
 * <p>
 * and n is the total number of new nodes on that edge.
 * <p>
 * Then, the edge (i, j) is deleted from the original graph, n new nodes (x_1, x_2, ..., x_n) are added to the original graph,
 * <p>
 * and n+1 new edges (i, x_1), (x_1, x_2), (x_2, x_3), ..., (x_{n-1}, x_n), (x_n, j) are added to the original graph.
 * <p>
 * Now, you start at node 0 from the original graph, and in each move, you travel along one edge.
 * <p>
 * Return how many nodes you can reach in at most M moves.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: edges = [[0,1,10],[0,2,1],[1,2,2]], M = 6, N = 3
 * Output: 13
 * Explanation:
 * The nodes that are reachable in the final graph after M = 6 moves are indicated below.
 * <p>
 * Example 2:
 * <p>
 * Input: edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], M = 10, N = 4
 * Output: 23
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= edges.length <= 10000
 * 0 <= edges[i][0] < edges[i][1] < N
 * There does not exist any i != j for which edges[i][0] == edges[j][0] and edges[i][1] == edges[j][1].
 * The original graph has no parallel edges.
 * 0 <= edges[i][2] <= 10000
 * 0 <= M <= 10^9
 * 1 <= N <= 3000
 * A reachable node is a node that can be travelled to using at most M moves starting from node 0.
 */
public class Leetcode882 {
    /**
     * Intuition:
     * Store edges to another 2D hashtable e, so that we can easier get length between two node by e[i][j].
     * seen[i] means that we can arrive at node i and have seen[i] moves left.
     * <p>
     * We use a dijkstra algorithm in this solution.
     * Priority queue pq store states (moves left, node index).
     * So every time when we pop from pq, we get the state with the most moves left.
     * <p>
     * In the end, we calculate the number of nodes that we can reach.
     * <p>
     * res = seen.length
     * For every edge e[i][j]:
     * res += min(seen.getOrDefault(i, 0) + seen.getOrDefault(j, 0), e[i][j])
     * <p>
     * Time Complexity:
     * Reminded by @kAc:
     * Dijkstra + Heap is O(E log E)
     * Dijkstra + Fibonacci heap is O(N log N + E)
     *
     * @param edges
     * @param M
     * @param N
     * @return
     */
    public int reachableNodes(int[][] edges, int M, int N) {
        HashMap<Integer, HashMap<Integer, Integer>> e = new HashMap<>();
        for (int i = 0; i < N; ++i) e.put(i, new HashMap<>());
        for (int[] v : edges) {
            e.get(v[0]).put(v[1], v[2]);
            e.get(v[1]).put(v[0], v[2]);
        }
        //最大堆 迪杰斯特拉
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        pq.offer(new int[]{M, 0});
        HashMap<Integer, Integer> seen = new HashMap<>();
        while (!pq.isEmpty()) {
            int moves = pq.peek()[0], i = pq.peek()[1];
            pq.poll();
            if (!seen.containsKey(i)) {
                seen.put(i, moves);
                for (int j : e.get(i).keySet()) {
                    int moves2 = moves - e.get(i).get(j) - 1;
                    if (!seen.containsKey(j) && moves2 >= 0)
                        pq.offer(new int[]{moves2, j});
                }
            }
        }
        int res = seen.size();
        for (int[] v : edges) {
            int a = seen.getOrDefault(v[0], 0);
            int b = seen.getOrDefault(v[1], 0);
            res += Math.min(a + b, v[2]);
        }
        return res;
    }
}
