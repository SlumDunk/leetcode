package com.github.leetcode.easy;

/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its
 * moves, judge if this robot makes a circle, which means it moves backTrack to the
 * original place.
 * <p>
 * The move sequence is represented by a string. And each move is represent by a
 * character. The valid robot moves are R (Right), L (Left), U (Up) and D
 * (down). The output should be true or false representing whether the robot
 * makes a circle.
 * <p>
 * Example 1: Input: "UD" Output: true Example 2: Input: "LL" Output: false
 *
 * @author liuzhongda
 */
public class Leetcode657 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static boolean judgeCircle(String moves) {
        //存储该机器人在水平方向和竖直方向上的位移，最后判断是否为0
        if (moves == null || moves.length() == 0) {
            return false;
        } else {
            int x = 0, y = 0;
            for (char value : moves.toCharArray()) {
                if (value == 'U') {
                    y++;
                } else if (value == 'D') {
                    y--;
                } else if (value == 'L') {
                    x--;
                } else if (value == 'R') {
                    x++;
                }
            }
            return x == 0 && y == 0;
        }
    }
}
