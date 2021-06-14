package com.github.leetcode.medium;

import java.util.*;

/**
 * Given an undirected tree, return its diameter: the number of edges in a longest path in that tree.
 * <p>
 * The tree is given as an array of edges where edges[i] = [u, v] is a bidirectional edge between nodes u and v.  Each node has labels in the set {0, 1, ..., edges.length}.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: edges = [[0,1],[0,2]]
 * Output: 2
 * Explanation:
 * A longest path of the tree is the path 1 - 0 - 2.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
 * Output: 4
 * Explanation:
 * A longest path of the tree is the path 3 - 2 - 1 - 4 - 5.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= edges.length < 10^4
 * edges[i][0] != edges[i][1]
 * 0 <= edges[i][j] <= edges.length
 * The given edges form an undirected tree.
 */
public class Leetcode1245 {
    int longest = 0;
    int endPoint = -1;

    /**
     * 因为是树， 所以没有环
     * 找两个端点
     *
     * @param edges
     * @return
     */
    public int treeDiameter(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge :
                edges) {
            int start = edge[0];
            int end = edge[1];

            List startList = graph.getOrDefault(start, new ArrayList<>());
            startList.add(end);
            graph.put(start, startList);

            List endList = graph.getOrDefault(end, new ArrayList<>());
            endList.add(start);
            graph.put(end, endList);
        }

        helper(0, graph);
        helper(endPoint, graph);
        return longest;

    }

    private void helper(Integer key, Map<Integer, List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(key);
        visited.add(key);
        int len = 0;
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            while (size-- > 0) {
                Integer start = queue.poll();
                endPoint = start;
                List<Integer> endList = graph.get(start);
                for (Integer end :
                        endList) {
                    if (!visited.contains(end)) {
                        queue.add(end);
                        visited.add(end);
                    }
                }
            }
        }
        longest = Math.max(len - 1, longest);
    }
}
