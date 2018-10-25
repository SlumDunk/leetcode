package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 10:24
 * @Description: Write a SQL query to get the nth highest salary from the Employee table.
 * <p>
 * +----+--------+
 * | Id | Salary |
 * +----+--------+
 * | 1  | 100    |
 * | 2  | 200    |
 * | 3  | 300    |
 * +----+--------+
 * For example, given the above Employee table, the nth highest salary where n = 2 is 200. If there is no nth highest salary, then the query should return null.
 * <p>
 * +------------------------+
 * | getNthHighestSalary(2) |
 * +------------------------+
 * | 200                    |
 * +------------------------+
 */
public class Leetcode177 {
    public static void main(String[] args) {
        System.out.println("CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT\n" +
                "BEGIN\n" +
                "      DECLARE m int;\n" +
                "      SET m = N - 1;\n" +
                "  RETURN (\n" +
                "      # Write your MySQL query statement below.\n" +
                "      select distinct e.Salary from Employee e order by e.Salary desc limit m,1\n" +
                "  );\n" +
                "END");
    }
}
