package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: zerongliu
 * @Date: 6/24/19 21:32
 * @Description: There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
 * <p>
 * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 * <p>
 * Example:
 * <p>
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
 */
public class Leetcode452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length < 2) return points.length;
        //按end位置递增排序
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] x1, int[] x2) {
                return x1[1] - x2[1];
            }
        });
        int c = 1, i = 0;
        for (int j = 1; j < points.length; j++) {
            //前后区间没有覆盖，增加箭
            if (points[j][0] > points[i][1]) {
                i = j;
                c++;
            }
        }
        return c;
    }
}
