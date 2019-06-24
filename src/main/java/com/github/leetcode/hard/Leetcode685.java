package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/8/19 13:52
 * @Description: In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.
 * <p>
 * The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 * <p>
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.
 * <p>
 * Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.
 * <p>
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given directed graph will be like this:
 * 1
 * / \
 * v   v
 * 2-->3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * Output: [4,1]
 * Explanation: The given directed graph will be like this:
 * 5 <- 1 -> 2
 * ^    |
 * |    v
 * 4 <- 3
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */
public class Leetcode685 {
    class UnionFind {
        int[] parents;

        public UnionFind(int N) {
            parents = new int[N];
            for (int i = 0; i < N; i++)
                parents[i] = i;
        }

        public void union(int x, int y) {
            parents[find(x)] = find(y);
        }

        public int find(int x) {
            if (x != parents[x])
                parents[x] = find(parents[x]);
            return parents[x];
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] edge1 = new int[2];
        int[] edge2 = new int[2]; /*Possible two edges(Two parents) in cases 2. */
        int[] parent = new int[edges.length + 1];
        UnionFind uf = new UnionFind(edges.length + 1);
        //检测是不是有节点有两个父节点
        for (int i = 0; i < edges.length; i++) { /*First loop to detect if there is duplicate parents*/
            int nodeU = edges[i][0];
            int nodeV = edges[i][1];
            if (parent[nodeV] > 0) {  /* there is duplicate parents*/
                edge1 = new int[]{parent[nodeV], nodeV}; /*Add previous/first edge*/
                edge2 = new int[]{nodeU, nodeV};/*Add 2nd edge*/
                //先删除第二条边
                edges[i][0] = -1;
                edges[i][1] = -1;
            }
            parent[nodeV] = nodeU;
        }
        //检测是否有环
        for (int i = 0; i < edges.length; i++) {
            int nodeU = edges[i][0];
            int nodeV = edges[i][1];
            if (nodeU < 0 || nodeV < 0)
                continue; /*This is for the deleted edge we have done in first loop.*/
            int rootU = uf.find(nodeU);
            int rootV = uf.find(nodeV);
            //检测到环
            if (rootU == rootV)
                //节点不存在重复的Parent，直接返回构成loop的边，不然返回第一条边，第一条边构成环
                return edge1[0] == 0 ? new int[]{nodeU, nodeV} : edge1;
            uf.union(nodeU, nodeV);
        }
        //一个顶点两个parent没有环，直接返回后面出现的边
        return edge2;
    }
}
