package com.github.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 3/20/19 20:09
 * @Description: Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.
 * <p>
 * If there isn't any rectangle, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
 * Output: 4
 * Example 2:
 * <p>
 * Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 * Output: 2
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= points.length <= 500
 * 0 <= points[i][0] <= 40000
 * 0 <= points[i][1] <= 40000
 * All points are distinct.
 */
public class Leetcode939 {
    public int minAreaRect(int[][] points) {
        Set<Integer> pointSet = new HashSet<>();
        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            pointSet.add(code(points[i][0], points[i][1]));
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) {
                    continue;
                }
                //检测副对角线上的两个点
                int code1 = code(points[i][0], points[j][1]);
                int code2 = code(points[j][0], points[i][1]);

                if (pointSet.contains(code1) && pointSet.contains(code2)) {
                    int area = Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]);
                    minArea = Math.min(minArea, area);
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

    private Integer code(int i, int j) {
        return (40000 * i) + j;
    }
}
