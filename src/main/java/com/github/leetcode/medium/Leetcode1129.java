package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 7/24/19 13:13
 * @Description:Consider a directed graph, with nodes labelled 0, 1, ..., n-1.  In this graph, each edge is either red or blue, and there could be self-edges or parallel edges.
 * <p>
 * Each [i, j] in red_edges denotes a red directed edge from node i to node j.  Similarly, each [i, j] in blue_edges denotes a blue directed edge from node i to node j.
 * <p>
 * Return an array answer of length n, where each answer[X] is the length of the shortest path from node 0 to node X such that the edge colors alternate along the path (or -1 if such a path doesn't exist).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * Output: [0,1,-1]
 * Example 2:
 * <p>
 * Input: n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * Output: [0,1,-1]
 * Example 3:
 * <p>
 * Input: n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * Output: [0,-1,-1]
 * Example 4:
 * <p>
 * Input: n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * Output: [0,1,2]
 * Example 5:
 * <p>
 * Input: n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * Output: [0,1,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 */
public class Leetcode1129 {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        List<List<Integer>> redList = new ArrayList<>();
        List<List<Integer>> blueList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            redList.add(new ArrayList<>());
            blueList.add(new ArrayList<>());
        }
        for (int[] redEdge : red_edges) {
            redList.get(redEdge[0]).add(redEdge[1]);
        }
        for (int[] blueEdge : blue_edges) {
            blueList.get(blueEdge[0]).add(blueEdge[1]);
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        //节点 和 颜色
        queue.offer(Arrays.asList(0, 0));
        queue.offer(Arrays.asList(0, 1));

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        //分别存储从该点出发，走红色和走蓝色
        boolean[][] visited
                = new boolean[n][2];
        int num = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> pointNode = queue.poll();
                int point = pointNode.get(0);
                int color = pointNode.get(1);
                if (color == 0) {
                    // red
                    List<Integer> targets = blueList.get(point);
                    for (int target : targets) {
                        if (visited[target][1]) {
                            continue;
                        }
                        result[target] = Math.min(result[target], num + 1);
                        queue.offer(Arrays.asList(target, 1));
                        visited[target][1] = true;
                    }
                } else {
                    List<Integer> targets = redList.get(point);
                    for (int target : targets) {
                        if (visited[target][0]) {
                            continue;
                        }
                        result[target] = Math.min(result[target], num + 1);
                        queue.offer(Arrays.asList(target, 0));
                        visited[target][0] = true;
                    }
                }
            }
            num++;
        }
        result[0] = 0;
        for (int i = 1; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }
}
