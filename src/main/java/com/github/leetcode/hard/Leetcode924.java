package com.github.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 3/15/19 21:52
 * @Description: In a network of nodes, each node i is directly connected to another node j if and only if graph[i][j] = 1.
 * <p>
 * Some nodes initial are initially infected by malware.  Whenever two nodes are directly connected and at least one of those two nodes is infected by malware, both nodes will be infected by malware.  This spread of malware will continue until no more nodes can be infected in this manner.
 * <p>
 * Suppose M(initial) is the final number of nodes infected with malware in the entire network, after the spread of malware stops.
 * <p>
 * We will remove one node from the initial list.  Return the node that if removed, would minimize M(initial).  If multiple nodes could be removed to minimize M(initial), return such a node with the smallest index.
 * <p>
 * Note that if a node was removed from the initial list of infected nodes, it may still be infected later as a result of the malware spread.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
 * Output: 0
 * Example 2:
 * <p>
 * Input: graph = [[1,0,0],[0,1,0],[0,0,1]], initial = [0,2]
 * Output: 0
 * Example 3:
 * <p>
 * Input: graph = [[1,1,1],[1,1,1],[1,1,1]], initial = [1,2]
 * Output: 1
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 < graph.length = graph[0].length <= 300
 * 0 <= graph[i][j] == graph[j][i] <= 1
 * graph[i][i] = 1
 * 1 <= initial.length < graph.length
 * 0 <= initial[i] < graph.length
 */
public class Leetcode924 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        Set<Integer> initialSet = new HashSet<>();
        //查看该病毒节点是否访问过了
        boolean[] visitedMalware = new boolean[graph.length];
        //最大的健康的节点数
        int max = 0;
        //最大健康的节点数 对应移除的病毒节点的索引
        int maxIndex = graph.length;
        for (int vertex :
                initial) {
            initialSet.add(vertex);
            maxIndex = Math.min(maxIndex, vertex);
        }

        for (int startVertex :
                initial) {
            if (visitedMalware[startVertex]) {
                continue;
            }
            //移除该节点
            initialSet.remove(startVertex);
            int count = getHealthCount(startVertex, graph, new boolean[graph.length], visitedMalware, initialSet);
            if (count > max || count == max && startVertex < maxIndex) {
                max = count;
                maxIndex = startVertex;
            }
        }

        return maxIndex;

    }

    /**
     * 返回健康节点数
     *
     * @param root
     * @param graph
     * @param visited
     * @param visitedMalware
     * @param initialSet
     * @return
     */
    private int getHealthCount(int root, int[][] graph, boolean[] visited, boolean[] visitedMalware, Set<Integer> initialSet) {
        visited[root] = true;
        //该节点是感染节点
        if (initialSet.contains(root)) {
            visitedMalware[root] = true;
            return -1;
        }

        int sum = 1;
        for (int i = 0; i < graph.length; i++) {
            if (graph[root][i] == 1 && !visited[i]) {
                int count = getHealthCount(i, graph, visited, visitedMalware, initialSet);
                if (count > 0) {
                    sum += count;
                } else {
                    return -1;
                }
            }
        }
        return sum;
    }
}
