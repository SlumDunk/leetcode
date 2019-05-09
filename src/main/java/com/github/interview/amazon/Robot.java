package com.github.interview.amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 4/10/19 23:19
 * @Description:
 */
public class Robot {
    /**
     * 上，右，下，左
     */
    int[][] steps = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /**
     * bfs + dijkstra
     *
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        distance[start[0]][start[1]] = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int i = 0; i < steps.length; i++) {
                int[] newPos = move(i, pos[0], pos[1], maze);
                int totalDistance = distance[pos[0]][pos[1]] + newPos[2];
                if (totalDistance < distance[newPos[0]][newPos[1]]) {
                    distance[newPos[0]][newPos[1]] = totalDistance;
                    if (newPos[0] == destination[0] && newPos[1] == destination[1]) {
                        continue;
                    }
                    queue.add(newPos);
                }
            }
        }
        int shortestDistance = distance[destination[0]][destination[1]];
        return shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance;
    }

    /**
     * 滚动小球
     *
     * @param direction
     * @param x
     * @param y
     * @param maze
     * @return
     */
    private int[] move(int direction, int x, int y, int[][] maze) {
        int[] pos = new int[]{x, y, 0};
        while (isValid(maze, pos[0] + steps[direction][0], pos[1] + steps[direction][1])) {
            pos[0] += steps[direction][0];
            pos[1] += steps[direction][1];
            pos[2] += 1;
        }
        return pos;
    }

    /**
     * 位置是否有效
     *
     * @param maze
     * @param x
     * @param y
     * @return
     */
    private boolean isValid(int[][] maze, int x, int y) {
        if (!(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length)) {
            return false;
        }
        return maze[x][y] != 1;
    }
}
