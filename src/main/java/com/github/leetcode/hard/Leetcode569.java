package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 20:00
 * @Description: The Employee table holds all employees. The employee table has three columns: Employee Id, Company Name, and Salary.
 * <p>
 * +-----+------------+--------+
 * |Id   | Company    | Salary |
 * +-----+------------+--------+
 * |1    | A          | 2341   |
 * |2    | A          | 341    |
 * |3    | A          | 15     |
 * |4    | A          | 15314  |
 * |5    | A          | 451    |
 * |6    | A          | 513    |
 * |7    | B          | 15     |
 * |8    | B          | 13     |
 * |9    | B          | 1154   |
 * |10   | B          | 1345   |
 * |11   | B          | 1221   |
 * |12   | B          | 234    |
 * |13   | C          | 2345   |
 * |14   | C          | 2645   |
 * |15   | C          | 2645   |
 * |16   | C          | 2652   |
 * |17   | C          | 65     |
 * +-----+------------+--------+
 * Write a SQL query to find the median salary of each company. Bonus points if you can solve it without using any built-in SQL functions.
 * <p>
 * +-----+------------+--------+
 * |Id   | Company    | Salary |
 * +-----+------------+--------+
 * |5    | A          | 451    |
 * |6    | A          | 513    |
 * |12   | B          | 234    |
 * |9    | B          | 1154   |
 * |14   | C          | 2645   |
 * +-----+------------+--------+
 */
public class Leetcode569 {
    public static void main(String[] args) {
        System.out.println("select\n" +
                "    Employee.Id, Employee.Company,Employee.Salary\n" +
                "from\n" +
                "    Employee,\n" +
                "    Employee alias\n" +
                "where\n" +
                "    Employee.Company=alias.Company\n" +
                "    group by Employee.Company,Employee.Salary\n" +
                "    Having sum(\n" +
                "        case\n" +
                "            when Employee.Salary=alias.Salary then 1\n" +
                "            else 0\n" +
                "        end\n" +
                "    )>=abs(sum(sign(Employee.Salary-alias.Salary)))#根据X是负数，零或正数，将参数的符号返回为-1,0或1\n" +
                "    order by Employee.Id;");
    }
}
