package com.github.leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given a m x n binary matrix mat. In one step, you can choose one cell and flip it and all the four neighbors of it if they exist (Flip is changing 1 to 0 and 0 to 1). A pair of cells are called neighbors if they share one edge.
 * <p>
 * Return the minimum number of steps required to convert mat to a zero matrix or -1 if you cannot.
 * <p>
 * A binary matrix is a matrix with all cells equal to 0 or 1 only.
 * <p>
 * A zero matrix is a matrix with all cells equal to 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: mat = [[0,0],[0,1]]
 * Output: 3
 * Explanation: One possible solution is to flip (1, 0) then (0, 1) and finally (1, 1) as shown.
 * Example 2:
 * <p>
 * Input: mat = [[0]]
 * Output: 0
 * Explanation: Given matrix is a zero matrix. We don't need to change it.
 * Example 3:
 * <p>
 * Input: mat = [[1,1,1],[1,0,1],[0,0,0]]
 * Output: 6
 * Example 4:
 * <p>
 * Input: mat = [[1,0,0],[1,0,0]]
 * Output: -1
 * Explanation: Given matrix can't be a zero matrix
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 3
 * mat[i][j] is either 0 or 1.
 */
public class Leetcode1284 {
    int[] dx = {0, 0, 1, 0, -1};
    int[] dy = {0, -1, 0, 1, 0};

    public int minFlips(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                start |= (mat[i][j] << (i * m + j));
            }
        }
        visited.add(start);
        queue.offer(start);
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == 0) {
                    return step;
                }
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < m; y++) {
                        int next = flip(curr, x, y, n, m);
                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private int flip(int curr, int x, int y, int n, int m) {
        for (int i = 0; i < 5; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];
            if (newx < 0 || newx >= n || newy < 0 || newy >= m) {
                continue;
            }
            curr ^= (1 << newx * m + newy);
        }
        return curr;
    }
}
