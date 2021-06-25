package com.github.leetcode.medium;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend to collect all apples in the tree, starting at vertex 0 and coming back to this vertex.
 * <p>
 * The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
 * Output: 8
 * Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
 * Output: 6
 * Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.
 * Example 3:
 * <p>
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai < bi <= n - 1
 * fromi < toi
 * hasApple.length == n
 */
public class Leetcode1443 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> paths = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            paths.add(new ArrayList<>());
        }

        for (int[] edge :
                edges) {
            paths.get(edge[0]).add(edge[1]);
            paths.get(edge[1]).add(edge[0]);
        }

        return dfs(paths, hasApple, new boolean[n + 1], 0);
    }

    private int dfs(List<List<Integer>> paths, List<Boolean> hasApple, boolean[] visited, int cur) {
        visited[cur] = true;
        int total = 0;
        for (int neighbor :
                paths.get(cur)) {
            if (visited[neighbor]) continue;
            total += dfs(paths, hasApple, visited, neighbor);
        }

        if ((total > 0 || hasApple.get(cur)) && cur != 0) {
            total += 2;
        }

        return total;
    }
}
