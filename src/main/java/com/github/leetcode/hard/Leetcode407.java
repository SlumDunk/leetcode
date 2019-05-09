package com.github.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 5/8/19 15:55
 * @Description: Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Given the following 3x6 height map:
 * [
 * [1,4,3,1,3,2],
 * [3,2,1,3,2,4],
 * [2,3,3,2,3,1]
 * ]
 * <p>
 * Return 4.
 * <p>
 * <p>
 * The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * After the rain, water is trapped between the blocks. The total volume of water trapped is 4.
 */
public class Leetcode407 {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new PairComparator());
        boolean[][] done = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pq.offer(new Pair(heightMap[i][0], i, 0));
            pq.offer(new Pair(heightMap[i][n - 1], i, n - 1));
            done[i][0] = true;
            done[i][n - 1] = true;
        }

        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(heightMap[0][i], 0, i));
            pq.offer(new Pair(heightMap[m - 1][i], m - 1, i));
            done[0][i] = true;
            done[m - 1][i] = true;
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int x = pair.x;
            int y = pair.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < m && 0 <= ny && ny < n && !done[nx][ny]) {
                    done[nx][ny] = true;
                    pq.offer(new Pair(Math.max(heightMap[nx][ny], pair.val), nx, ny));
                    sum += Math.max(0, pair.val - heightMap[nx][ny]);
                }
            }
        }
        return sum;

    }

    private static int[] dx = new int[]{0, 1, 0, -1};
    private static int[] dy = new int[]{1, 0, -1, 0};

    private class Pair {
        int val;
        int x;
        int y;

        Pair(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    private class PairComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.val - o2.val;
        }
    }
}
