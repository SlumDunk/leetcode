package com.github.leetcode.easy;

/**
 * There is a table courses with columns: student and class
 * <p>
 * Please list out all classes which have more than or equal to 5 students.
 * <p>
 * For example, the table:
 * <p>
 * +---------+------------+
 * | student | class      |
 * +---------+------------+
 * | A       | Math       |
 * | B       | English    |
 * | C       | Math       |
 * | D       | Biology    |
 * | E       | Math       |
 * | F       | Computer   |
 * | G       | Math       |
 * | H       | Math       |
 * | I       | Math       |
 * +---------+------------+
 * Should output:
 * <p>
 * +---------+
 * | class   |
 * +---------+
 * | Math    |
 * +---------+
 */
public class Leetcode596 {
    public static void main(String[] args) {
        System.out.println("select c.class from courses c group by c.class having count(distinct c.student)>=5;");
    }
}
