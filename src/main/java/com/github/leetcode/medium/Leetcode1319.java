package com.github.leetcode.medium;

import java.util.*;

/**
 * There are n computers numbered from 0 to n-1 connected by ethernet cables connections forming a network where connections[i] = [a, b] represents a connection between computers a and b. Any computer can reach any other computer directly or indirectly through the network.
 * <p>
 * Given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected. Return the minimum number of times you need to do this in order to make all the computers connected. If it's not possible, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: n = 4, connections = [[0,1],[0,2],[1,2]]
 * Output: 1
 * Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * Output: 2
 * Example 3:
 * <p>
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * Output: -1
 * Explanation: There are not enough cables.
 * Example 4:
 * <p>
 * Input: n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5
 * 1 <= connections.length <= min(n*(n-1)/2, 10^5)
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] < n
 * connections[i][0] != connections[i][1]
 * There are no repeated connections.
 * No two computers are connected by more than one cable.
 */
public class Leetcode1319 {
    /**
     * 强连通分量的个数 - 1
     *
     * @param n
     * @param connections
     * @return
     */
    public int makeConnected(int n, int[][] connections) {
        int length = connections.length;
        if (length < n - 1) {
            return -1;
        } else {
            // 构造图
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] connection :
                    connections) {
                int start = connection[0];
                int end = connection[1];
                List<Integer> edgeList = graph.getOrDefault(start, new ArrayList<>());
                edgeList.add(end);
                graph.put(start, edgeList);

                List<Integer> edgeList2 = graph.getOrDefault(end, new ArrayList<>());
                edgeList2.add(start);
                graph.put(end, edgeList2);
            }

            //标志该节点是否被归入某个连通分量
            boolean[] visited = new boolean[n];
            //强连通分量的个数
            int ans = 0;
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    ans++;
                    helper(graph, visited, i);
                }
            }
            return ans - 1;
        }
    }

    private void helper(Map<Integer, List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        List<Integer> endNodes = graph.get(node);
        if (endNodes != null) {
            for (Integer endNode :
                    endNodes) {
                if (!visited[endNode]) {
                    helper(graph, visited, endNode);
                }
            }
        }
    }
}
