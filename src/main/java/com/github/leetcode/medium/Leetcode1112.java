package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/21/19 17:05
 * @Description: Table: Enrollments
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | student_id    | int     |
 * | course_id     | int     |
 * | grade         | int     |
 * +---------------+---------+
 * (student_id, course_id) is the primary key of this table.
 * <p>
 * Write a SQL query to find the highest grade with its corresponding course for each student. In case of a tie, you should find the course with the smallest course_id. The output must be sorted by increasing student_id.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Enrollments table:
 * +------------+-------------------+
 * | student_id | course_id | grade |
 * +------------+-----------+-------+
 * | 2          | 2         | 95    |
 * | 2          | 3         | 95    |
 * | 1          | 1         | 90    |
 * | 1          | 2         | 99    |
 * | 3          | 1         | 80    |
 * | 3          | 2         | 75    |
 * | 3          | 3         | 82    |
 * +------------+-----------+-------+
 * <p>
 * Result table:
 * +------------+-------------------+
 * | student_id | course_id | grade |
 * +------------+-----------+-------+
 * | 1          | 2         | 99    |
 * | 2          | 2         | 95    |
 * | 3          | 3         | 82    |
 * +------------+-----------+-------+
 */
public class Leetcode1112 {
    public static void main(String[] args) {
        System.out.println("");
    }
}
