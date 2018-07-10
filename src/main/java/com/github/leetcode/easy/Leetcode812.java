package com.github.leetcode.easy;

/**
 * You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.
 * <p>
 * Example:
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2
 * Explanation:
 * The five points are show in the figure below. The red triangle is the largest.
 */
public class Leetcode812 {
    public static void main(String[] args) {

    }

    public double largestTriangleArea(int[][] points) {
        int length = points.length;
        double res = 0;
        double area;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    area = 0.5 * Math.abs(points[i][0] * (points[j][1] - points[k][1]) + points[j][0] * (points[k][1] - points[i][1]) + points[k][0] * (points[i][1] - points[j][1]));
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }
}


