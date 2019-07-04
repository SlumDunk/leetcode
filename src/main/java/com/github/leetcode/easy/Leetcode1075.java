package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 21:53
 * @Description: Table: Project
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | project_id  | int     |
 * | employee_id | int     |
 * +-------------+---------+
 * (project_id, employee_id) is the primary key of this table.
 * employee_id is a foreign key to Employee table.
 * Table: Employee
 * <p>
 * +------------------+---------+
 * | Column Name      | Type    |
 * +------------------+---------+
 * | employee_id      | int     |
 * | name             | varchar |
 * | experience_years | int     |
 * +------------------+---------+
 * employee_id is the primary key of this table.
 * <p>
 * <p>
 * Write an SQL query that reports the average experience years of all the employees for each project, rounded to 2 digits.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Project table:
 * +-------------+-------------+
 * | project_id  | employee_id |
 * +-------------+-------------+
 * | 1           | 1           |
 * | 1           | 2           |
 * | 1           | 3           |
 * | 2           | 1           |
 * | 2           | 4           |
 * +-------------+-------------+
 * <p>
 * Employee table:
 * +-------------+--------+------------------+
 * | employee_id | name   | experience_years |
 * +-------------+--------+------------------+
 * | 1           | Khaled | 3                |
 * | 2           | Ali    | 2                |
 * | 3           | John   | 1                |
 * | 4           | Doe    | 2                |
 * +-------------+--------+------------------+
 * <p>
 * Result table:
 * +-------------+---------------+
 * | project_id  | average_years |
 * +-------------+---------------+
 * | 1           | 2.00          |
 * | 2           | 2.50          |
 * +-------------+---------------+
 * The average experience years for the first project is (3 + 2 + 1) / 3 = 2.00 and for the second project is (3 + 2) / 2 = 2.50
 */
public class Leetcode1075 {
    public static void main(String[] args) {
        System.out.println("SELECT\n" +
                "\tp.project_id,\n" +
                "\tROUND( AVG( e.experience_years ), 2 ) AS average_years \n" +
                "FROM\n" +
                "\tProject AS p\n" +
                "\tJOIN Employee AS e ON p.employee_id = e.employee_id \n" +
                "GROUP BY\n" +
                "\tproject_id");
    }
}
