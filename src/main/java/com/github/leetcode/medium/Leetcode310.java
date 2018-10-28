package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 10/27/18 15:31
 * @Description: For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * <p>
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * <p>
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * <p>
 * Example 1 :
 * <p>
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * <p>
 * 0
 * |
 * 1
 * / \
 * 2   3
 * <p>
 * Output: [1]
 * Example 2 :
 * <p>
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * <p>
 * 0  1  2
 * \ | /
 * 3
 * |
 * 4
 * |
 * 5
 * <p>
 * Output: [3, 4]
 * Note:
 * <p>
 * According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
public class Leetcode310 {
    public static void main(String[] args) {
        Leetcode310 leetcode310 = new Leetcode310();
        int[][] edges = {
                {
                        0, 1
                }, {
                1, 2
        }, {
                1, 3
        }, {
                2, 4
        }, {
                3, 5
        }
        };
        System.out.println(leetcode310.findMinHeightTrees(6, edges));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if (n <= 1)

        {
            leaves.add(0);
            return leaves;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (
                int i = 0;
                i < n; i++)
            graph.put(i, new HashSet<Integer>());
        for (
                int[] edge : edges)

        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++)

        {
            if (graph.get(i).size() == 1)
                leaves.add(i);
        }
        while (n > 2)

        {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                for (int newLeaf : graph.get(leaf)) {
                    graph.get(leaf).remove(newLeaf);
                    graph.get(newLeaf).remove(leaf);
                    if (graph.get(newLeaf).size() == 1)
                        newLeaves.add(newLeaf);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
