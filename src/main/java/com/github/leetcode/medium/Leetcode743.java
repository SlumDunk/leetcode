package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 5/8/19 15:27
 * @Description: There are N network nodes, labelled 1 to N.
 * <p>
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
 * <p>
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 * <p>
 * Note:
 * <p>
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 */
public class Leetcode743 {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int[] minTimes = new int[N + 1];
        Arrays.fill(minTimes, Integer.MAX_VALUE);
        minTimes[K] = 0;
        queue.offer(K);
        int res = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (graph.containsKey(node)) {
                for (int[] edge :
                        graph.get(node)) {
                    int value = minTimes[node] + edge[1];
                    if (value < minTimes[edge[0]]) {
                        minTimes[edge[0]] = value;
                        queue.offer(edge[0]);
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (minTimes[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, minTimes[i]);
        }
        return res;
    }
}
