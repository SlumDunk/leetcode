package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 5/31/19 11:26
 * @Description: An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.
 * <p>
 * The ith edge connects nodes edges[i][0] and edges[i][1] together.
 * <p>
 * Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.
 * <p>
 * Example 1:
 * <p>
 * Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * Output: [8,12,6,10,10,10]
 * Explanation:
 * Here is a diagram of the given tree:
 * 0
 * / \
 * 1   2
 * /|\
 * 3 4 5
 * We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
 * Note: 1 <= N <= 10000
 */
public class Leetcode834 {
    public static void main(String[] args) {
        Leetcode834 leetcode834 = new Leetcode834();
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        leetcode834.sumOfDistancesInTree(6, edges);
    }

    class Graph {
        int V;
        List<Integer>[] adjList;

        Graph(int V) {
            this.V = V;
            adjList = new List[V];
            for (int i = 0; i < V; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        void addEdge(int src, int des) {
            adjList[src].add(des);
        }

        /**
         * 求出非叶子节点的distance
         *
         * @param root
         * @param d     距离数组
         * @param c     节点子树的数量
         * @param visit
         */
        void insertDistanceAndCount(int root, int[] d, int[] c, boolean[] visit) {
            visit[root] = true;
            c[root] = 1;
            for (int node :
                    adjList[root]) {
                if (!visit[node]) {
                    insertDistanceAndCount(node, d, c, visit);
                    d[root] += d[node] + c[node];
                    c[root] += c[node];
                }
            }
        }

        /**
         * 求叶子节点的distance
         *
         * @param root
         * @param d     距离数组
         * @param c     关联的节点数量
         * @param visit
         */
        void updateDistanceAndCount(int root, int[] d, int[] c, boolean[] visit) {
            visit[root] = true;
            for (int node :
                    adjList[root]) {
                if (!visit[node]) {
                    d[node] = d[root] - c[node] + (V - c[node]);
                    updateDistanceAndCount(node, d, c, visit);
                }
            }
        }
    }

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        Graph g = new Graph(N);
        int[] distance = new int[N];
        int[] count = new int[N];

        for (int i = 0; i < edges.length; i++) {
            g.addEdge(edges[i][0], edges[i][1]);
            g.addEdge(edges[i][1], edges[i][0]);
        }

        g.insertDistanceAndCount(0, distance, count, new boolean[N]);
        g.updateDistanceAndCount(0, distance, count, new boolean[N]);

        return distance;
    }
}
