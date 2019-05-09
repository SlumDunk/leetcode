package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 18:42
 * @Description: A pupil Tim gets homework to identify whether three line segments could possibly form a triangle.
 * <p>
 * <p>
 * However, this assignment is very heavy because there are hundreds of records to calculate.
 * <p>
 * <p>
 * Could you help Tim by writing a query to judge whether these three sides can form a triangle, assuming table triangle holds the length of the three sides x, y and z.
 * <p>
 * <p>
 * | x  | y  | z  |
 * |----|----|----|
 * | 13 | 15 | 30 |
 * | 10 | 20 | 15 |
 * For the sample data above, your query should return the follow result:
 * | x  | y  | z  | triangle |
 * |----|----|----|----------|
 * | 13 | 15 | 30 | No       |
 * | 10 | 20 | 15 | Yes      |
 */
public class Leetcode610 {
    public static void main(String[] args) {
        System.out.println("select\n" +
                "    x,\n" +
                "    y,\n" +
                "    z,\n" +
                "    case\n" +
                "        when x+y>z and x+z>y and y+z>x then 'Yes'\n" +
                "        else 'No'\n" +
                "    end as 'triangle'\n" +
                "from\n" +
                "    triangle;");
    }
}
