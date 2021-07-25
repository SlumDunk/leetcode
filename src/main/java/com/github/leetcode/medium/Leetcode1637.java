package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.
 * <p>
 * A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.
 * <p>
 * Note that points on the edge of a vertical area are not considered included in the area.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * ​
 * Input: points = [[8,7],[9,9],[7,4],[9,7]]
 * Output: 1
 * Explanation: Both the red and the blue area are optimal.
 * Example 2:
 * <p>
 * Input: points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == points.length
 * 2 <= n <= 105
 * points[i].length == 2
 * 0 <= xi, yi <= 109
 */
public class Leetcode1637 {
    int max = 0;

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        for (int i = 1; i < points.length; i++) {
            max = Math.max(points[i][0] - points[i - 1][0], max);
        }

        return max;
    }
}
