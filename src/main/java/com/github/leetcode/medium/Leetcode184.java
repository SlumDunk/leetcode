package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 11:10
 * @Description: The Employee table holds all employees. Every employee has an Id, a salary, and there is also a column for the department Id.
 * <p>
 * +----+-------+--------+--------------+
 * | Id | Name  | Salary | DepartmentId |
 * +----+-------+--------+--------------+
 * | 1  | Joe   | 70000  | 1            |
 * | 2  | Henry | 80000  | 2            |
 * | 3  | Sam   | 60000  | 2            |
 * | 4  | Max   | 90000  | 1            |
 * +----+-------+--------+--------------+
 * The Department table holds all departments of the company.
 * <p>
 * +----+----------+
 * | Id | Name     |
 * +----+----------+
 * | 1  | IT       |
 * | 2  | Sales    |
 * +----+----------+
 * Write a SQL query to find employees who have the highest salary in each of the departments. For the above tables, Max has the highest salary in the IT department and Henry has the highest salary in the Sales department.
 * <p>
 * +------------+----------+--------+
 * | Department | Employee | Salary |
 * +------------+----------+--------+
 * | IT         | Max      | 90000  |
 * | Sales      | Henry    | 80000  |
 * +------------+----------+--------+
 */
public class Leetcode184 {
    public static void main(String[] args) {
        System.out.println("SELECT\n" +
                "    Department.name AS 'Department',\n" +
                "    Employee.name AS 'Employee',\n" +
                "    Salary\n" +
                "FROM\n" +
                "    Employee\n" +
                "        JOIN\n" +
                "    Department ON Employee.DepartmentId = Department.Id\n" +
                "WHERE\n" +
                "    (Employee.DepartmentId , Salary) IN\n" +
                "    (   SELECT\n" +
                "            DepartmentId, MAX(Salary)\n" +
                "        FROM\n" +
                "            Employee\n" +
                "        GROUP BY DepartmentId\n" +
                "\t)");
    }
}
