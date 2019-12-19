package com.github.leetcode.medium;

import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 3/15/19 21:30
 * @Description: We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class Leetcode973 {
    /**
     * O(n)
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        if (points == null || K <= 0) {
            return result;
        }

        if (points.length <= K) {
            return points;
        }
        PriorityQueue<int[]> maxQueue = new PriorityQueue<>((a, b) -> {
            return getDistance(b) - getDistance(a);
        });
        for (int i = 0; i < points.length; i++) {
            maxQueue.offer(points[i]);
            if (maxQueue.size() > K) {
                maxQueue.poll();
            }
        }

        for (int i = 0; i < K; i++) {
            int[] point = maxQueue.poll();
            result[i][0] = point[0];
            result[i][1] = point[1];
        }
        return result;
    }

    public int getDistance(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }
}
