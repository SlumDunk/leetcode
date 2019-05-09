package com.github.interview.amazon;

import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 4/10/19 17:57
 * @Description:
 */
public class KNearestPoint {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        if (points == null || K <= 0) {
            return result;
        }

        if (points.length <= K) {
            return points;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return getDistance(b) - getDistance(a);
        });

        for (int i = 0; i < points.length; i++) {
            queue.offer(points[i]);
            if (queue.size() > K) {
                queue.poll();
            }
        }
        for (int i = 0; i < K; i++) {
            int[] point = queue.poll();
            result[i][0] = point[0];
            result[i][1] = point[1];
        }

        return result;
    }

    private int getDistance(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }
}
