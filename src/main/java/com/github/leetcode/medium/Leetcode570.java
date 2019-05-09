package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 19:59
 * @Description: The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.
 * <p>
 * +------+----------+-----------+----------+
 * |Id    |Name 	  |Department |ManagerId |
 * +------+----------+-----------+----------+
 * |101   |John 	  |A 	      |null      |
 * |102   |Dan 	  |A 	      |101       |
 * |103   |James 	  |A 	      |101       |
 * |104   |Amy 	  |A 	      |101       |
 * |105   |Anne 	  |A 	      |101       |
 * |106   |Ron 	  |B 	      |101       |
 * +------+----------+-----------+----------+
 * Given the Employee table, write a SQL query that finds out managers with at least 5 direct report. For the above table, your SQL query should return:
 * <p>
 * +-------+
 * | Name  |
 * +-------+
 * | John  |
 * +-------+
 * Note:
 * No one would report to himself.
 */
public class Leetcode570 {
    public static void main(String[] args) {
        System.out.println("select\n" +
                "    Name\n" +
                "from\n" +
                "    Employee as t1 join\n" +
                "    (\n" +
                "        select\n" +
                "            ManagerId\n" +
                "        from\n" +
                "            Employee\n" +
                "        group by ManagerId\n" +
                "        Having count(ManagerId)>=5\n" +
                "    )as t2\n" +
                "    on t1.Id=t2.ManagerId;");
    }
}
