package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 3/4/19 10:29
 * @Description: The Employee table holds all employees. Every employee has an Id, and there is also a column for the department Id.
 * <p>
 * +----+-------+--------+--------------+
 * | Id | Name  | Salary | DepartmentId |
 * +----+-------+--------+--------------+
 * | 1  | Joe   | 70000  | 1            |
 * | 2  | Henry | 80000  | 2            |
 * | 3  | Sam   | 60000  | 2            |
 * | 4  | Max   | 90000  | 1            |
 * | 5  | Janet | 69000  | 1            |
 * | 6  | Randy | 85000  | 1            |
 * +----+-------+--------+--------------+
 * The Department table holds all departments of the company.
 * <p>
 * +----+----------+
 * | Id | Name     |
 * +----+----------+
 * | 1  | IT       |
 * | 2  | Sales    |
 * +----+----------+
 * Write a SQL query to find employees who earn the top three salaries in each of the department. For the above tables, your SQL query should return the following rows.
 * <p>
 * +------------+----------+--------+
 * | Department | Employee | Salary |
 * +------------+----------+--------+
 * | IT         | Max      | 90000  |
 * | IT         | Randy    | 85000  |
 * | IT         | Joe      | 70000  |
 * | Sales      | Henry    | 80000  |
 * | Sales      | Sam      | 60000  |
 * +------------+----------+--------+
 */
public class Leetcode185 {
    public static void main(String[] args) {
        System.out.println("select d.Name as 'Department', e1.Name as 'Employee', e1.Salary from Employee e1 join Department d on e1.DepartmentId=d.Id\n" +
                "where\n" +
                "    (select count(distinct e2.salary) from Employee e2 \n" +
                "    where\n" +
                "        e2.Salary>e1.Salary and e1.DepartmentId=e2.DepartmentId)<3 order by d.Name;");
    }
}
