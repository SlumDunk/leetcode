package com.github.leetcode.hard;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 6/6/19 16:26
 * @Description: On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).
 * <p>
 * Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.
 * <p>
 * You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?
 * <p>
 * Example 1:
 * <p>
 * Input: [[0,2],[1,3]]
 * Output: 3
 * Explanation:
 * At time 0, you are in grid location (0, 0).
 * You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
 * <p>
 * You cannot reach point (1, 1) until time 3.
 * When the depth of water is 3, we can swim anywhere inside the grid.
 * Example 2:
 * <p>
 * Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * Output: 16
 * Explanation:
 * 0  1  2  3  4
 * 24 23 22 21  5
 * 12 13 14 15 16
 * 11 17 18 19 20
 * 10  9  8  7  6
 * <p>
 * The final route is marked in bold.
 * We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 * Note:
 * <p>
 * 2 <= N <= 50.
 * grid[i][j] is a permutation of [0, ..., N*N - 1].
 */
public class Leetcode778 {
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> priQueue = new PriorityQueue<int[]>((int[] a, int[] b) ->
                ((Integer) (grid[a[0]][a[1]])).compareTo(
                        grid[b[0]][b[1]]));
        HashSet<Integer> visited = new HashSet<Integer>();
        priQueue.add(new int[]{0, 0});
        int res = 0;
        while (priQueue.size() > 0) {
            int[] indexes = priQueue.poll();
            res = Math.max(res, grid[indexes[0]][indexes[1]]);
            if (indexes[0] == grid.length - 1 &&
                    indexes[1] == grid[0].length - 1) return res;
            visited.add(hashCode(indexes[0], indexes[1]));
            for (int i = 0; i < dirs.length; i++) {
                int r = indexes[0] + dirs[i][0], c = indexes[1] + dirs[i][1];
                int[] nextIndexes = new int[]{r, c};
                if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||
                        visited.contains(hashCode(r, c))) continue;
                priQueue.add(nextIndexes);
            }
        }
        return -1;
    }

    private int hashCode(int r, int c) {
        return r * 1000 + c;
    }
}
