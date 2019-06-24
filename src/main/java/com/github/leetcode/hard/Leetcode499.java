package com.github.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 6/6/19 21:23
 * @Description: There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up (u), down (d), left (l) or right (r), but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction. There is also a hole in this maze. The ball will drop into the hole if it rolls on to the hole.
 * <p>
 * Given the ball position, the hole position and the maze, find out how the ball could drop into the hole by moving the shortest distance. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the hole (included). Output the moving directions by using 'u', 'd', 'l' and 'r'. Since there could be several different shortest ways, you should output the lexicographically smallest way. If the ball cannot reach the hole, output "impossible".
 * <p>
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The ball and the hole coordinates are represented by row and column indexes.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input 1: a maze represented by a 2D array
 * <p>
 * 0 0 0 0 0
 * 1 1 0 0 1
 * 0 0 0 0 0
 * 0 1 0 0 1
 * 0 1 0 0 0
 * <p>
 * Input 2: ball coordinate (rowBall, colBall) = (4, 3)
 * Input 3: hole coordinate (rowHole, colHole) = (0, 1)
 * <p>
 * Output: "lul"
 * <p>
 * Explanation: There are two shortest ways for the ball to drop into the hole.
 * The first way is left -> up -> left, represented by "lul".
 * The second way is up -> left, represented by 'ul'.
 * Both ways have shortest distance 6, but the first way is lexicographically smaller because 'l' < 'u'. So the output is "lul".
 * <p>
 * Example 2:
 * <p>
 * Input 1: a maze represented by a 2D array
 * <p>
 * 0 0 0 0 0
 * 1 1 0 0 1
 * 0 0 0 0 0
 * 0 1 0 0 1
 * 0 1 0 0 0
 * <p>
 * Input 2: ball coordinate (rowBall, colBall) = (4, 3)
 * Input 3: hole coordinate (rowHole, colHole) = (3, 0)
 * <p>
 * Output: "impossible"
 * <p>
 * Explanation: The ball cannot reach the hole.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * There is only one ball and one hole in the maze.
 * Both the ball and hole exist on an empty space, and they will not be at the same position initially.
 * The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
 * The maze contains at least 2 empty spaces, and the width and the height of the maze won't exceed 30.
 */
public class Leetcode499 {

    class Point {
        final int r;
        final int c;
        final int cost;
        final String path;

        Point(int r, int c, int cost, String path) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.path = path;
        }

        Point update(int r, int c, int cost, String s) {
            return new Point(r, c, cost, path + s);
        }
    }

    int[][] directions = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    String[] direction_letters = {"d", "l", "r", "u"};

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int rows = maze.length, cols = maze[0].length;
        // distance to each index 存储到各个点的最短路径值
        int[][] dist = new int[rows][cols];
        // answer String
        String ans = null;
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(ball[0], ball[1], 1, ""));
        dist[ball[0]][ball[1]] = 1;
        int tr = hole[0], tc = hole[1];

        // start BFS
        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            // early pruning 1:
            // in case current path cost is greater or equal to the path cost to hole
            // then we no longer need to consider this case
            if (dist[tr][tc] > 0 && dist[tr][tc] <= curr.cost) continue;
            // early pruning 2:
            // in case the path cost stored in Point is greater than the shortest
            // path to current index
            if (curr.cost > dist[curr.r][curr.c]) continue;

            // try each of four possible directions
            for (int i = 0; i < directions.length; i++) {
                int[] direction = directions[i];
                String s = direction_letters[i];
                int rr = curr.r, cc = curr.c, cost = curr.cost, num = 0, numToHole = 0;
                boolean passHole = false;
                while (isValid(rr + direction[0], cc + direction[1], maze)) {
                    rr += direction[0];
                    cc += direction[1];
                    num += 1;
                    // check if it pass the hole
                    if (rr == tr && cc == tc) {
                        passHole = true;
                        numToHole = num;
                    }
                }
                //不需要move，碰到墙，继续
                if (num == 0) continue;
                // in case the move pass hole, check to see if we need to update the answer string
                if (passHole) {
                    // ans == null : this is the first time we pass the hole
                    // dist[tr][tc] > cost + num: we find a shorter path to hole
                    if (ans == null || dist[tr][tc] > cost + numToHole) {
                        ans = curr.path + s;
                        dist[tr][tc] = cost + numToHole;
                    }
                    // in case the path cost is equal to the current shortest path cost to hole
                    // but the string representation is lexicographically smaller
                    else if (dist[tr][tc] == cost + numToHole) {
                        String temp = curr.path + s;
                        if (ans != null && ans.compareTo(temp) > 0) ans = temp;
                    }
                }
                //不是最短，继续
                if (dist[rr][cc] > 0 && dist[rr][cc] < cost + num) continue;
                dist[rr][cc] = cost + num;
                queue.offer(curr.update(rr, cc, cost + num, s));
            }
        }
        return ans == null ? "impossible" : ans;

    }

    /**
     * 检查目标位置是否有效
     *
     * @param r
     * @param c
     * @param maze
     * @return
     */
    private boolean isValid(int r, int c, int[][] maze) {
        return r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c] == 0;
    }
}
