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
        //最多有两个节点，从外到内一点点裁剪，裁减掉度为1的节点和边
        //结果集
        List<Integer> result = new ArrayList<>();
        if (n <= 1) {
            result.add(0);
            return result;
        }
        //边集合
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        //初始化边集合
        for (int i = 0; i < n; i++)
            graph.put(i, new HashSet<Integer>());
        //构造边集合
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        //度为1的节点
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1)
                result.add(i);
        }
        //剩余节点数大于2
        while (n > 2) {
            n -= result.size();
            List<Integer> vertexes = new ArrayList<>();
            for (int vertex : result) {
                for (int adjVertex : graph.get(vertex)) {
                    //删除关联边
                    graph.get(vertex).remove(adjVertex);
                    graph.get(adjVertex).remove(vertex);
                    //度为1的节点放入list
                    if (graph.get(adjVertex).size() == 1)
                        vertexes.add(adjVertex);
                }
            }
            result = vertexes;
        }
        return result;
    }

    /**
     * 广度优先
     *
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> bfsMinHeightTrees(int n, int[][] edges) {
        //构造图
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        if (n == 1) {
            result.add(0);
            return result;
        }
        //存储各个节点的度
        int[] degree = new int[n];
        //初始化边集合
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        //构造边集合
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();

        //先从叶子节点往里缩，叶子节点的度为1
        for (int i = 0; i < n; i++)
            //一开始有度为0的点，已经找到最小高度树
            if (degree[i] == 0)
                return result;
            else if (degree[i] == 1) {
                queue.offer(i);
            }

        while (!queue.isEmpty()) {
            result = new ArrayList<Integer>();
            int count = queue.size();
            //遍历当前叶子节点，把它的度和与它关联节点的度减1
            for (int i = 0; i < count; i++) {
                int current = queue.poll();
                //加入结果集
                result.add(current);
                //度减1
                degree[current]--;
                List<Integer> adjEdges = graph.get(current);
                //处理关联节点的度
                for (int k = 0; k < adjEdges.size(); k++) {
                    int vertex = adjEdges.get(k);
                    //查看边是否已经删除过
                    if (degree[vertex] == 0) {
                        continue;
                    } else {
                        degree[vertex]--;
                        if (degree[vertex] == 1) {
                            queue.offer(vertex);
                        }
                    }
                }
            }
        }
        return result;
    }
}
