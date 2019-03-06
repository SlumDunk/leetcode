package com.github.leetcode.medium;

import java.util.HashSet;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 22:45
 * @Description: Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],[-1,1]]
 * Output: true
 * Example 2:
 * <p>
 * Input: [[1,1],[-1,-1]]
 * Output: false
 * Follow up:
 * Could you do better than O(n2) ?
 */
public class Leetcode356 {
    public boolean isReflected(int[][] points) {
        HashSet<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] pair :
                points) {
            set.add(pair[0] + "," + pair[1]);
            min = Math.min(min, pair[0]);
            max = Math.max(max, pair[0]);
        }
        //x坐标的range
        int sum = min + max;
        for (int[] pair :
                points) {
            if (!set.contains(sum - pair[0] + "," + pair[1])) {
                return false;
            }
        }
        return true;
    }
}
