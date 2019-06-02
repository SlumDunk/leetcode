package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 5/31/19 10:14
 * @Description: (This problem is the same as Minimize Malware Spread, with the differences bolded.)
 * <p>
 * In a network of nodes, each node i is directly connected to another node j if and only if graph[i][j] = 1.
 * <p>
 * Some nodes initial are initially infected by malware.  Whenever two nodes are directly connected and at least one of those two nodes is infected by malware, both nodes will be infected by malware.  This spread of malware will continue until no more nodes can be infected in this manner.
 * <p>
 * Suppose M(initial) is the final number of nodes infected with malware in the entire network, after the spread of malware stops.
 * <p>
 * We will remove one node from the initial list, completely removing it and any connections from this node to any other node.  Return the node that if removed, would minimize M(initial).  If multiple nodes could be removed to minimize M(initial), return such a node with the smallest index.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
 * Output: 0
 * Example 2:
 * <p>
 * Input: graph = [[1,1,0],[1,1,1],[0,1,1]], initial = [0,1]
 * Output: 1
 * Example 3:
 * <p>
 * Input: graph = [[1,1,0,0],[1,1,1,0],[0,1,1,1],[0,0,1,1]], initial = [0,1]
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
public class Leetcode928 {
    public static final int UNKNOWN = 0;  // unknown
    public static final int ISCALCULATING = 1;  // is calculating
    public static final int SAFE = 2;   // safe
    public static final int UNSAFE = 3;   // unsafe

    /**
     * @param N
     * @param initial     感染节点数组
     * @param removedNode 要移除的感染节点
     * @return
     */
    public int[] states(int N, int[] initial, int removedNode) {
        int[] res = new int[N];
        for (int i : initial) {
            res[i] = (i == removedNode) ? SAFE : UNSAFE;
        }
        return res;
    }

    /**
     * @param graph
     * @param initial
     * @return
     */
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int N = graph.length, min = Integer.MAX_VALUE, res = initial[0];
        //遍历感染节点
        for (int mal : initial) {
            int[] states = states(N, initial, mal);
            //移除此感染节点后，受感染的节点数量
            int mals = check(graph, states);
            if (mals < min || (mals == min && mal < res)) {
                min = mals;
                res = mal;
            }
        }
        return res;
    }

    /**
     * @param graph
     * @param states
     * @return
     */
    public int check(int[][] graph, int[] states) {
        for (int i = 0; i < graph.length; i++) {
            dfs(graph, i, states);
        }

        int res = 0;
        for (int st : states) {
            if (st == UNSAFE) res++;
        }
        return res;
    }

    /**
     * @param graph
     * @param node
     * @param states
     * @return
     */
    public int dfs(int[][] graph, int node, int[] states) {
        if (states[node] != UNKNOWN) return states[node];
        states[node] = ISCALCULATING;
        boolean neighborIsCalculating = false;
        for (int i = 0, adjs[] = graph[node]; i < adjs.length; i++) {
            if (i == node) continue;
            if (adjs[i] == 0) continue;
            if (states[i] == ISCALCULATING) {
                neighborIsCalculating = true;
                continue;
            }
            if (dfs(graph, i, states) == UNSAFE) {
                states[node] = UNSAFE;
                return UNSAFE;
            }
        }
        states[node] = (neighborIsCalculating) ? UNKNOWN : SAFE;
        return SAFE;
    }
}
