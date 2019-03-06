package com.github.leetcode.hard;

import java.util.HashSet;

/**
 * @Author: zerongliu
 * @Date: 3/6/19 10:32
 * @Description: Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.
 * <p>
 * Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [3,2,4,4],
 * [1,3,2,4],
 * [2,3,3,4]
 * ]
 * <p>
 * Return true. All 5 rectangles together form an exact cover of a rectangular region.
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 * rectangles = [
 * [1,1,2,3],
 * [1,3,2,4],
 * [3,1,4,2],
 * [3,2,4,4]
 * ]
 * <p>
 * Return false. Because there is a gap between the two rectangular regions.
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 3:
 * <p>
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [1,3,2,4],
 * [3,2,4,4]
 * ]
 * <p>
 * Return false. Because there is a gap in the top center.
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 4:
 * <p>
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [1,3,2,4],
 * [2,2,4,4]
 * ]
 * <p>
 * Return false. Because two of the rectangles overlap with each other.
 */
public class Leetcode391 {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0 || rectangles[0].length == 0) {
            return false;
        }

        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;

        HashSet<String> set = new HashSet<>();
        int area = 0;

        for (int[] rect :
                rectangles) {
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);

            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);

            //存储矩形的四个顶点 逆时针
            String s1 = rect[0] + " " + rect[1];
            String s2 = rect[0] + " " + rect[3];
            String s3 = rect[2] + " " + rect[3];
            String s4 = rect[2] + " " + rect[1];

            if (!set.add(s1)) set.remove(s1);
            if (!set.add(s2)) set.remove(s2);
            if (!set.add(s3)) set.remove(s3);
            if (!set.add(s4)) set.remove(s4);
        }

        //如果完美覆盖，那么最终只剩下四个顶点
        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2)
                || !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2) || set.size() != 4) {
            return false;
        }
        return area == (x2 - x1) * (y2 - y1);

    }
}
