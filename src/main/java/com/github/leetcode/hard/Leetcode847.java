package com.github.leetcode.hard;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 2/24/19 18:26
 * @Description: An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.
 * <p>
 * graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.
 * <p>
 * Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,2,3],[0],[0],[0]]
 * Output: 4
 * Explanation: One possible path is [1,0,2,0,3]
 * Example 2:
 * <p>
 * Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
 * Output: 4
 * Explanation: One possible path is [0,1,4,2,3]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= graph.length <= 12
 * 0 <= graph[i].length < graph.length
 */
public class Leetcode847 {
    class State {
        public int mask, source;

        public State(int m, int s) {
            this.mask = m;
            this.source = s;
        }
    }

    public int shortestPathLength(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return 0;
        } else {
            int len = graph.length;
            int[][] dp = new int[len][1 << len];
            Queue<State> queue = new LinkedList<State>();
            for (int i = 0; i < len; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
                dp[i][1 << i] = 0;
                queue.offer(new State(1 << i, i));
            }

            while (!queue.isEmpty()) {
                State state = queue.poll();
                for (int next :
                        graph[state.source]) {
                    int nextMask = state.mask | 1 << next;
                    if (dp[next][nextMask] > dp[state.source][state.mask] + 1) {
                        dp[next][nextMask] = dp[state.source][state.mask] + 1;
                        queue.offer(new State(nextMask, next));
                    }
                }
            }
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                result = Math.min(dp[i][(1 << len) - 1], result);
            }
            return result;
        }
    }
}
