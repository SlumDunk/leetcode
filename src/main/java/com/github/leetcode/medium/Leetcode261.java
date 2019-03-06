package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 3/4/19 20:11
 * @Description: Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 * Example 2:
 * <p>
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
 */
public class Leetcode261 {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        Set<Integer> visited = new HashSet<>();

        visited.add(0);

        boolean res = helper(graph, visited, 0, -1);
        if (res == false) return false;
        //是否有节点不可达
        return visited.size() == n ? true : false;
    }

    private boolean helper(List<List<Integer>> graph, Set<Integer> visited, int node, int parent) {
        List<Integer> targetVertexes = graph.get(node);
        for (Integer vertex : targetVertexes
                ) {
            if (vertex == parent) continue;
            //有环，直接返回false
            if (visited.contains(vertex)) return false;
            visited.add(vertex);
            boolean res = helper(graph, visited, vertex, node);
            if (res == false) return false;
        }
        return true;
    }
}
