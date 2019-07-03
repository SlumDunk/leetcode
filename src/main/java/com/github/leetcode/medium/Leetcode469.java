package com.github.leetcode.medium;

import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 20:25
 * @Description: Given a list of points that form a polygon when joined sequentially, find if this polygon is convex (Convex polygon definition).
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * There are at least 3 and at most 10,000 points.
 * Coordinates are in the range -10,000 to 10,000.
 * You may assume the polygon formed by given points is always a simple polygon (Simple polygon definition). In other words, we ensure that exactly two edges intersect at each vertex, and that edges otherwise don't intersect each other.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * [[0,0],[0,1],[1,1],[1,0]]
 * <p>
 * Answer: True
 * <p>
 * Explanation:
 * Example 2:
 * <p>
 * [[0,0],[0,10],[10,10],[10,0],[5,5]]
 * <p>
 * Answer: False
 * <p>
 * Explanation:
 */
public class Leetcode469 {
    public boolean isConvex(List<List<Integer>> points) {
        int sz = points.size();
        int flag = 0;
        for (int i = 0; i < points.size(); i++) {
            int ori = getOrientation(points.get(i % sz), points.get((i + 1) % sz), points.get((i + 2) % sz));
            if (ori == 0) { // cannot decide the result
                continue;
            }
            if (flag == 0) {
                flag = ori;
            } else {
                if (flag != ori) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Utility Method to get the orientation of 3 ordered points
     *
     * @param p1
     * @param p2
     * @param p3
     * @return 0 if colinear, 1 if clockwise, 2 if counterclockwise
     */
    public int getOrientation(List<Integer> p1, List<Integer> p2, List<Integer> p3) {
        int val = (p3.get(0) - p2.get(0)) * (p2.get(1) - p1.get(1)) - (p2.get(0) - p1.get(0)) * (p3.get(1) - p2.get(1));
        if (val < 0) {
            return 2;
        }
        if (val == 0) {
            return 0;
        }
        return 1;
    }
}
