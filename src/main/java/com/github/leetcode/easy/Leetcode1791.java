package com.github.leetcode.easy;

/**
 * There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.
 * <p>
 * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: edges = [[1,2],[2,3],[4,2]]
 * Output: 2
 * Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.
 * Example 2:
 * <p>
 * Input: edges = [[1,2],[5,1],[1,3],[1,4]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * ui != vi
 * The given edges represent a valid star graph.
 */
public class Leetcode1791 {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] arr = new int[n+1];
        for (int[] edge :
                edges) {
            arr[edge[0]]++;
            arr[edge[1]]++;
        }

        for (int i = 1; i <= n ; i++) {
            if (arr[i] == edges.length) {
                return i;
            }
        }

        return -1;
    }
}
