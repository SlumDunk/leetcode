package com.github.leetcode.easy;

/**
 * Write a SQL query to get the second highest salary from the Employee table.
 * <p>
 * +----+--------+
 * | Id | Salary |
 * +----+--------+
 * | 1  | 100    |
 * | 2  | 200    |
 * | 3  | 300    |
 * +----+--------+
 * For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.
 * <p>
 * +---------------------+
 * | SecondHighestSalary |
 * +---------------------+
 * | 200                 |
 * +---------------------+
 */
public class Leetcode176 {
    public static void main(String[] args) {
        System.out.println("select Salary from Employee group by Salary union all (select NULL as Salary) order by Salary desc limit 1 offset 1");
    }
}
