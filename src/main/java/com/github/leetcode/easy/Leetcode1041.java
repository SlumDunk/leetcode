package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/2/19 17:00
 * @Description: On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:
 * <p>
 * "G": go straight 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degress to the right.
 * The robot performs the instructions given in order, and repeats them forever.
 * <p>
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "GGLLGG"
 * Output: true
 * Explanation:
 * The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
 * When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
 * Example 2:
 * <p>
 * Input: "GG"
 * Output: false
 * Explanation:
 * The robot moves north indefinitely.
 * Example 3:
 * <p>
 * Input: "GL"
 * Output: true
 * Explanation:
 * The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= instructions.length <= 100
 * instructions[i] is in {'G', 'L', 'R'}
 */
public class Leetcode1041 {
    public boolean isRobotBounded(String instructions) {
        int dis = 0;
        int x = 0;
        int y = 0;

        for (int i = 0; i < 4; i++) {
            for (char c : instructions.toCharArray()) {
                switch (c) {
                    case 'G':
                        if (dis == 0) {//north
                            y++;
                        }
                        if (dis == 1) {//east
                            x++;
                        }
                        if (dis == 2) {//south
                            y--;
                        }
                        if (dis == 3) {//west
                            x--;
                        }
                        break;
                    case 'L':
                        dis = (dis == 0 ? 3 : dis - 1);
                        break;
                    case 'R':
                        dis = (dis == 3 ? 0 : dis + 1);
                        break;
                }
            }
            if (x == 0 && y == 0) {
                return true;
            }
        }
        return false;
    }
}
