package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/3/19 09:52
 * @Description: A boomerang is a set of 3 points that are all distinct and not in a straight line.
 * <p>
 * Given a list of three points in the plane, return whether these points are a boomerang.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],[2,3],[3,2]]
 * Output: true
 * Example 2:
 * <p>
 * Input: [[1,1],[2,2],[3,3]]
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * points.length == 3
 * points[i].length == 2
 * 0 <= points[i][j] <= 100
 */
public class Leetcode1037 {
    public boolean isBoomerang(int[][] points) {
        int[] p1 = points[0];
        int[] p2 = points[1];
        int[] p3 = points[2];

        long left = (p2[1] - p1[1]) * (p3[0] - p1[0]);
        long right = (p2[0] - p1[0]) * (p3[1] - p1[1]);

        return left != right;
    }
}
