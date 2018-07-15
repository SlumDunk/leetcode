package com.github.leetcode.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * <p>
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * <p>
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class Leetcode447 {
    public static void main(String[] args) {

    }

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> distanceMap = new HashMap<Integer, Integer>(64);
            for (int j = 0; j < points.length; j++) {
                int distance = (int) (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                if (distanceMap.get(distance) == null) {
                    distanceMap.put(distance, 1);
                } else {
                    distanceMap.put(distance, distanceMap.get(distance) + 1);
                }
            }
            for (Integer value : distanceMap.values()
                    ) {
                ans += value * (value - 1);
            }
        }
        return ans;
    }
}
