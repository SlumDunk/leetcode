package com.github.interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 11/6/19 10:08
 * @Description:
 */
public class CriticalConnection {
    // I know these are globals, but I think it makes it easier to read.
    // Just pass it into bridgeDfs if you have an issue.
    private static int time = 0;
    private static int[] discTime;
    private static int[] low;
    private static List<Integer>[] graph;

    public static List<List<Integer>> findBridges(int n, int[][] edges) {
        graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++)
            graph[i] = new ArrayList<>();

        // add edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        discTime = new int[n + 1];
        low = new int[n + 1];
        List<List<Integer>> result = new ArrayList<>();
        visit(1, -1, result);
        return result;
    }

    private static void visit(int currNode, int parent, List<List<Integer>> bridges) {
        low[currNode] = discTime[currNode] = time++;

        // Loop through, dfs.
        for (int tempNode : graph[currNode]) {
            if (discTime[tempNode] == 0) { // not visited
                visit(tempNode, currNode, bridges);
                low[currNode] = Math.min(low[currNode], low[tempNode]);

                if (low[tempNode] > low[currNode]) {
                    bridges.add(Arrays.asList(currNode, tempNode));
                }

            } else if (parent != tempNode) {
                low[currNode] = Math.min(low[currNode], discTime[tempNode]);
            }
        }

        return;
    }

    public static void main(String[] args) {
        int[] n = {5, 6, 9, 90, 10};
        int[][][] edges = {
                // given
                {{1, 2}, {1, 3}, {3, 4}, {1, 4}, {4, 5}},
                {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {2, 5}, {4, 6}, {5, 6}},
                {{1, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 6}, {4, 5}, {6, 7}, {6, 9}, {7, 8}, {8, 9}},

                // Empty
                {}
        };
        for (int i = 0; i < n.length; i++) {
            List<List<Integer>> ans = findBridges(n[i], edges[i]);
            System.out.println(ans);
        }

    }
}
