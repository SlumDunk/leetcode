package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 18:34
 * @Description: Table point_2d holds the coordinates (x,y) of some unique points (more than two) in a plane.
 * <p>
 * <p>
 * Write a query to find the shortest distance between these points rounded to 2 decimals.
 * <p>
 * <p>
 * | x  | y  |
 * |----|----|
 * | -1 | -1 |
 * | 0  | 0  |
 * | -1 | -2 |
 * <p>
 * <p>
 * The shortest distance is 1.00 from point (-1,-1) to (-1,2). So the output should be:
 * <p>
 * <p>
 * | shortest |
 * |----------|
 * | 1.00     |
 * <p>
 * <p>
 * Note: The longest distance among all the points are less than 10000.
 */
public class Leetcode612 {
    public static void main(String[] args) {
        System.out.println("select\n" +
                "    round(sqrt(min((pow(p1.x-p2.x,2)+pow(p1.y-p2.y,2)))),2) as shortest\n" +
                "from\n" +
                "    point_2d p1\n" +
                "        join\n" +
                "    point_2d p2 on p1.x!=p2.x or p1.y!=p2.y;");
    }
}
