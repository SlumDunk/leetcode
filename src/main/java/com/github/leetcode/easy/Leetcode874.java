package com.github.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 9/2/18 13:56
 * @Description: A robot on an infinite grid starts at point (0, 0) and faces north.  The robot can receive one of three possible types of commands:
 * <p>
 * -2: turn left 90 degrees
 * -1: turn right 90 degrees
 * 1 <= x <= 9: move forward x units
 * Some of the grid squares are obstacles.
 * <p>
 * The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
 * <p>
 * If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues following the rest of the route.)
 * <p>
 * Return the square of the maximum Euclidean distance that the robot will be from the origin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: commands = [4,-1,3], obstacles = []
 * Output: 25
 * Explanation: robot will go to (3, 4)
 * Example 2:
 * <p>
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * Output: 65
 * Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * The answer is guaranteed to be less than 2 ^ 31.
 */
public class Leetcode874 {
    public static void main(String[] args) {
        Leetcode874 leetcode874 = new Leetcode874();
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};
        leetcode874.robotSim(commands, obstacles);
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        //north,east,south,west
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currentDir = 0;
        int x = 0, y = 0;
        int max = 0;
        int nx, ny;
        Set<Long> obstacleSet = new HashSet<Long>();
        for (int[] obstacle : obstacles) {
            long ox = (long) obstacle[0];
            long oy = (long) obstacle[1];
            obstacleSet.add((ox << 16) + oy);
        }

        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                currentDir = (currentDir + 1) % 4;
            } else if (commands[i] == -2) {
                currentDir = (currentDir - 1 + 4) % 4;
            } else {
                for (int j = 0; j < commands[i]; j++) {
                    nx = x + dir[currentDir][0];
                    ny = y + dir[currentDir][1];
                    long code = (((long) nx) << 16) + ((long) ny);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        max = Math.max(max, x * x + y * y);
                    }
                }
            }
        }
        return max;
    }
}
