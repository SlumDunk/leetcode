package com.github.leetcode.medium;

import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 14:38
 * @Description: Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].
 * <p>
 * The score of a path is the minimum value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.
 * <p>
 * A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [[5,4,5],[1,2,6],[7,4,6]]
 * Output: 4
 * Explanation:
 * The path with the maximum score is highlighted in yellow.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: [[2,2,1,2,2,2],[1,2,2,2,1,2]]
 * Output: 2
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
 * Output: 3
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= R, C <= 100
 * 0 <= A[i][j] <= 10^9
 */
public class Leetcode1102 {
    public int maximumMinimumPath(int[][] A) {
        int n = A.length, m = A[0].length;
        //存储各个元素的位置和这个路径上的当前最小值， 按值倒序排列
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[2] - a[2]);
        pq.offer(new int[]{0, 0, A[0][0]});
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int r = cell[0], c = cell[1];
            if (r == n - 1 && c == m - 1)
                return cell[2];
            if (r + 1 < n && A[r + 1][c] != -1)
                pq.offer(new int[]{r + 1, c, Math.min(cell[2], A[r + 1][c])});
            if (r - 1 >= 0 && A[r - 1][c] != -1)
                pq.offer(new int[]{r - 1, c, Math.min(cell[2], A[r - 1][c])});
            if (c + 1 < m && A[r][c + 1] != -1)
                pq.offer(new int[]{r, c + 1, Math.min(cell[2], A[r][c + 1])});
            if (c - 1 >= 0 && A[r][c - 1] != -1)
                pq.offer(new int[]{r, c - 1, Math.min(cell[2], A[r][c - 1])});
            //访问过的置为-1
            A[r][c] = -1;
        }
        return -1;
    }
}
