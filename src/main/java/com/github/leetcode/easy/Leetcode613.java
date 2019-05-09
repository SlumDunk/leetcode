package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 10:32
 * @Description: Table point holds the x coordinate of some points on x-axis in a plane, which are all integers.
 * <p>
 * <p>
 * Write a query to find the shortest distance between two points in these points.
 * <p>
 * <p>
 * | x   |
 * |-----|
 * | -1  |
 * | 0   |
 * | 2   |
 * <p>
 * <p>
 * The shortest distance is '1' obviously, which is from point '-1' to '0'. So the output is as below:
 * <p>
 * <p>
 * | shortest|
 * |---------|
 * | 1       |
 * <p>
 * <p>
 * Note: Every point is unique, which means there is no duplicates in table point.
 * <p>
 * <p>
 * Follow-up: What if all these points have an id and are arranged from the left most to the right most of x axis?
 */
public class Leetcode613 {
    public static void main(String[] args) {
        System.out.println("select\n" +
                "    min(abs(p1.x-p2.x)) as shortest\n" +
                "from \n" +
                "    point p1\n" +
                "        join\n" +
                "    point p2\n" +
                "        on p1.x!=p2.x;");
    }
}
