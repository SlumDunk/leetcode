package com.github.leetcode.easy;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 10/31/20 20:13
 * @Description: You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 */
public class Leetcode1232 {
    public static void main(String[] args) {
        Leetcode1232 leetcode1232 = new Leetcode1232();
        int[][] coordinates = {{0, 1}, {2, 4}, {3, 3}};
        leetcode1232.checkStraightLine(coordinates);
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int noOfRows=coordinates.length;
        for(int i=2;i<noOfRows;i++)
        {
            int x0=coordinates[i-2][0];
            int y0=coordinates[i-2][1];
            int x1=coordinates[i-1][0];
            int y1=coordinates[i-1][1];
            int x2=coordinates[i][0];
            int y2=coordinates[i][1];
            if((y1-y0)*(x2-x1)!=(y2-y1)*(x1-x0))
                return false;
        }
        return true;
    }
}
