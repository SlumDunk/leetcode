package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 20:59
 * @Description: Given the edges of a directed graph, and two nodes source and destination of this graph, determine whether or not all paths starting from source eventually end at destination, that is:
 * <p>
 * At least one path exists from the source node to the destination node
 * If a path exists from the source node to a node with no outgoing edges, then that node is equal to destination.
 * The number of possible paths from source to destination is a finite number.
 * Return true if and only if all roads from source lead to destination.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
 * Output: false
 * Explanation: It is possible to reach and get stuck on both node 1 and node 2.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3
 * Output: false
 * Explanation: We have two possibilities: to end at node 3, or to loop over node 1 and node 2 indefinitely.
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: n = 4, edges = [[0,1],[0,2],[1,3],[2,3]], source = 0, destination = 3
 * Output: true
 * Example 4:
 * <p>
 * <p>
 * <p>
 * Input: n = 3, edges = [[0,1],[1,1],[1,2]], source = 0, destination = 2
 * Output: false
 * Explanation: All paths from the source node end at the destination node, but there are an infinite number of paths, such as 0-1-2, 0-1-1-2, 0-1-1-1-2, 0-1-1-1-1-2, and so on.
 * Example 5:
 * <p>
 * <p>
 * <p>
 * Input: n = 2, edges = [[0,1],[1,1]], source = 0, destination = 1
 * Output: false
 * Explanation: There is infinite self-loop at destination node.
 * <p>
 * <p>
 * Note:
 * <p>
 * The given graph may have self loops and parallel edges.
 * The number of nodes n in the graph is between 1 and 10000
 * The number of edges in the graph is between 0 and 10000
 * 0 <= edges.length <= 10000
 * edges[i].length == 2
 * 0 <= source <= n - 1
 * 0 <= destination <= n - 1
 */
public class Leetcode1059 {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<Integer>() {{
                    add(edge[1]);
                }});
            } else {
                map.get(edge[0]).add(edge[1]);
            }
        }
        return dfs(source, destination, new HashSet<>(), map);
    }

    /**
     * @param curr
     * @param destination
     * @param visited
     * @param map
     * @return
     */
    private boolean dfs(int curr, int destination, HashSet<Integer> visited, HashMap<Integer, List<Integer>> map) {
        visited.add(curr);
        //走不下去了
        if (!map.containsKey(curr)) return curr == destination;
        List<Integer> list = map.get(curr);
        for (int next : list) {
            if (!map.containsKey(next)) {//这个节点没有出边
                if (next == destination) return true;
                else return false;
            } else if (visited.contains(next)) {//出现环
                return false;
            } else if (!dfs(next, destination, visited, map)) {//继续深度遍历
                return false;
            }
        }
        //重置状态
        visited.remove(curr);
        return true;
    }
}
