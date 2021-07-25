package com.github.leetcode.medium;

import java.util.*;

/**
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
 * <p>
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 * <p>
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 * <p>
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 * <p>
 * It's guaranteed that each city can reach city 0 after reorder.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * Output: 3
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 * Example 2:
 * <p>
 * <p>
 * Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * Output: 2
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 * Example 3:
 * <p>
 * Input: n = 3, connections = [[1,0],[2,0]]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 5 * 104
 * connections.length == n - 1
 * connections[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 */
public class Leetcode1466 {
    class Pair {
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    /**
     * 从 0 反向 reverse
     *
     *
     * @param n
     * @param connections
     * @return
     */
    public int minReorder(int n, int[][] connections) {
        // key 为目标，value 为指向 key 的 node list
        Map<Integer, List<Pair>> graphs = new HashMap<>();
        for (int[] connection :
                connections) {
            // dest->start
            int start = connection[0];
            List<Pair> sourceList = graphs.getOrDefault(start, new ArrayList<>());
            int dest = connection[1];
            sourceList.add(new Pair(dest, 1));
            graphs.put(start, sourceList);

            // start->dest
            List<Pair> targetList = graphs.getOrDefault(dest, new ArrayList<>());
            targetList.add(new Pair(start, 0));
            graphs.put(dest, targetList);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);
        int res = 0;
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (Pair pair :
                    graphs.get(current)) {
                if (visited.contains(pair.node)) {
                    continue;
                }
                queue.add(pair.node);
                visited.add(pair.node);
                res += pair.cost;
            }
        }
        return res;
    }
}
