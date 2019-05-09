package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 19:17
 * @Description: Select all employee's name and bonus whose bonus is < 1000.
 * <p>
 * Table:Employee
 * <p>
 * +-------+--------+-----------+--------+
 * | empId |  name  | supervisor| salary |
 * +-------+--------+-----------+--------+
 * |   1   | John   |  3        | 1000   |
 * |   2   | Dan    |  3        | 2000   |
 * |   3   | Brad   |  null     | 4000   |
 * |   4   | Thomas |  3        | 4000   |
 * +-------+--------+-----------+--------+
 * empId is the primary key column for this table.
 * Table: Bonus
 * <p>
 * +-------+-------+
 * | empId | bonus |
 * +-------+-------+
 * | 2     | 500   |
 * | 4     | 2000  |
 * +-------+-------+
 * empId is the primary key column for this table.
 * Example ouput:
 * <p>
 * +-------+-------+
 * | name  | bonus |
 * +-------+-------+
 * | John  | null  |
 * | Dan   | 500   |
 * | Brad  | null  |
 * +-------+-------+
 */
public class Leetcode577 {
    public static void main(String[] args) {
        System.out.println("select\n" +
                "    Employee.name, Bonus.bonus\n" +
                "from \n" +
                "    Employee\n" +
                "        left join\n" +
                "    Bonus on Employee.empid=Bonus.empid\n" +
                "where\n" +
                "    bonus<1000 or bonus is null;");
    }
}
