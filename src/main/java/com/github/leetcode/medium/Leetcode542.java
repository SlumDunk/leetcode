package com.github.leetcode.medium;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 5/24/19 20:19
 * @Description: Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * <p>
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * Example 2:
 * <p>
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [1,1,1]]
 * <p>
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [1,2,1]]
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 */
public class Leetcode542 {
    int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        int unvisited = Integer.MAX_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList();
        //mark all 1's with MAX, so that we can use it to see unvisited nodes
        //Also, BFS from all 0's. ie, start from end/ans/desired point. So add 0's to q
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = unvisited;
                } else {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0];
            int j = point[1];

            int curr = matrix[i][j];

            for (int k = 0; k < direction.length; k++) {
                if (i + direction[k][0] >= 0 && i + direction[k][0] < m && j + direction[k][1] >= 0 && j + direction[k][1] < n) {
                    if (matrix[i + direction[k][0]][j + direction[k][1]] == unvisited) {
                        matrix[i + direction[k][0]][j + direction[k][1]] = curr + 1;
                        queue.offer(new int[]{i + direction[k][0], j + direction[k][1]});
                    }
                }
            }
        }
        return matrix;
    }
}
