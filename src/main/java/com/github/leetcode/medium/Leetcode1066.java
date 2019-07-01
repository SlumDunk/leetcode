package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 17:46
 * @Description: On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker and bike is a 2D coordinate on this grid.
 * <p>
 * We assign one unique bike to each worker so that the sum of the Manhattan distances between each worker and their assigned bike is minimized.
 * <p>
 * The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
 * <p>
 * Return the minimum possible sum of Manhattan distances between each worker and their assigned bike.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
 * Output: 6
 * Explanation:
 * We assign bike 0 to worker 0, bike 1 to worker 1. The Manhattan distance of both assignments is 3, so the output is 6.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
 * Output: 4
 * Explanation:
 * We first assign bike 0 to worker 0, then assign bike 1 to worker 1 or worker 2, bike 2 to worker 2 or worker 1. Both assignments lead to sum of the Manhattan distances as 4.
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= workers[i][0], workers[i][1], bikes[i][0], bikes[i][1] < 1000
 * All worker and bike locations are distinct.
 * 1 <= workers.length <= bikes.length <= 10
 */
public class Leetcode1066 {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int N = workers.length;
        int M = bikes.length;
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = getManhattanDistance(workers[i], bikes[j]);
            }
        }
        return backtrack(N, new boolean[M], dist, 0, new HashMap<>());
    }

    /**
     * @param N        工人总数
     * @param bikeUsed 标志单车是否被使用
     * @param dist     距离数组
     * @param i        当前处理的工人下标
     * @param map      缓存 key为当前单车的使用状态， value为使用这批单车的最小成本
     * @return
     */
    private int backtrack(int N, boolean[] bikeUsed, int[][] dist, int i, Map<Integer, Integer> map) {
        if (i >= N) {
            return 0;
        }
        //获取单车的使用状态
        int key = convert(bikeUsed);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < bikeUsed.length; j++) {
            //已经被占用
            if (bikeUsed[j]) {
                continue;
            }
            //打上标记
            bikeUsed[j] = true;
            min = Math.min(min, dist[i][j] + backtrack(N, bikeUsed, dist, i + 1, map));
            //重新置位
            bikeUsed[j] = false;
        }
        map.put(key, min);
        return min;
    }

    /**
     * 获取曼哈顿距离
     *
     * @param worker
     * @param bike
     * @return
     */
    private int getManhattanDistance(int[] worker, int[] bike) {
        return (int) Math.abs(worker[0] - bike[0]) + (int) Math.abs(worker[1] - bike[1]);
    }

    /**
     * 用个二进制数表示单车的使用状态
     *
     * @param bikeUsed
     * @return
     */
    private int convert(boolean[] bikeUsed) {
        int res = 0;
        for (boolean b : bikeUsed) {
            res <<= 1;
            if (b) {
                res |= 1;
            }
        }
        return res;
    }
}
