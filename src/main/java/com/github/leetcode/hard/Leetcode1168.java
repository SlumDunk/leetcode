package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 9/12/19 15:26
 * @Description: There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.
 * <p>
 * For each house i, we can either build a well inside it directly with cost wells[i], or pipe in water from another well to it. The costs to lay pipes between houses are given by the array pipes, where each pipes[i] = [house1, house2, cost] represents the cost to connect house1 and house2 together using a pipe. Connections are bidirectional.
 * <p>
 * Find the minimum total cost to supply water to all houses.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
 * Output: 3
 * Explanation:
 * The image shows the costs of connecting houses using pipes.
 * The best strategy is to build a well in the first house with cost 1 and connect the other houses to it with cost 2 so the total cost is 3.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10000
 * wells.length == n
 * 0 <= wells[i] <= 10^5
 * 1 <= pipes.length <= 10000
 * 1 <= pipes[i][0], pipes[i][1] <= n
 * 0 <= pipes[i][2] <= 10^5
 * pipes[i][0] != pipes[i][1]
 */
public class Leetcode1168 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        //key为节点 value为到其他点的cost
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        //key为0的value存储每个节点造井的代价
        graph.put(0, new HashMap<>());
        for (int i = 0; i < wells.length; i++)
            graph.get(0).put(i + 1, wells[i]);
        //存储架设管道的代价
        for (int i = 0; i < pipes.length; i++) {
            graph.putIfAbsent(pipes[i][0], new HashMap<>());
            graph.putIfAbsent(pipes[i][1], new HashMap<>());
            int prev = graph.get(pipes[i][0]).getOrDefault(pipes[i][1], Integer.MAX_VALUE);
            graph.get(pipes[i][0]).put(pipes[i][1], Math.min(prev, pipes[i][2]));
            graph.get(pipes[i][1]).put(pipes[i][0], Math.min(prev, pipes[i][2]));
        }
        int minCost = 0;
        //记录通水的点
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        //最小堆
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> graph.get(a[0]).get(a[1]) - graph.get(b[0]).get(b[1]));
        //先把井入堆
        for (int i = 1; i <= n; i++)
            pq.offer(new int[]{0, i});
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int v = edge[1];
            //已经通水了，直接返回
            if (visited.contains(v)) continue;
            visited.add(v);
            int cost = graph.get(edge[0]).get(edge[1]);
            minCost += cost;
            if (graph.get(v) != null) {
                for (int nei : graph.get(v).keySet()) {
                    if (!visited.contains(nei))
                        pq.offer(new int[]{v, nei});
                }
            }
        }
        return minCost;
    }
}
