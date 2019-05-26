package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/11/19 10:10
 * @Description: Given the coordinates of four points in 2D space, return whether the four points could construct a square.
 * <p>
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 * <p>
 * Example:
 * <p>
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 * <p>
 * <p>
 * Note:
 * <p>
 * All the input integers are in the range [-10000, 10000].
 * A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 * Input points have no order.
 */
public class Leetcode593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d12 = distance(p1, p2), d13 = distance(p1, p3), d23 = distance(p2, p3);
        if (d12 == 0 || d13 == 0 || d23 == 0) {
            return false;
        }
        if (d12 == d23) {
            return validate(p2, p1, p3, p4);
        }
        if (d12 == d13) {
            return validate(p1, p2, p3, p4);
        }
        if (d13 == d23) {
            return validate(p3, p2, p1, p4);
        }
        return false;
    }

    /**
     * 判断是否是正方形
     *
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     */
    private boolean validate(int[] p1, int[] p2, int[] p3, int[] p4) {
        if ((p1[0] - p2[0]) * (p1[0] - p3[0]) + (p1[1] - p2[1]) * (p1[1] - p3[1]) == 0) {
            return p4[0] == p2[0] + p3[0] - p1[0] && p4[1] == p2[1] + p3[1] - p1[1];
        } else {
            return false;
        }
    }

    /**
     * 求两点间距
     *
     * @param p
     * @param q
     * @return
     */
    private int distance(int[] p, int[] q) {
        int x = p[0] - q[0];
        int y = p[1] - q[1];
        return x * x + y * y;
    }
}
