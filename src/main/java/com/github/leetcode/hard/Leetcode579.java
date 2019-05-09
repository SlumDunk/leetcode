package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 10:11
 * @Description: The Employee table holds the salary information in a year.
 * <p>
 * Write a SQL to get the cumulative sum of an employee's salary over a period of 3 months but exclude the most recent month.
 * <p>
 * The result should be displayed by 'Id' ascending, and then by 'Month' descending.
 * <p>
 * Example
 * Input
 * <p>
 * | Id | Month | Salary |
 * |----|-------|--------|
 * | 1  | 1     | 20     |
 * | 2  | 1     | 20     |
 * | 1  | 2     | 30     |
 * | 2  | 2     | 30     |
 * | 3  | 2     | 40     |
 * | 1  | 3     | 40     |
 * | 3  | 3     | 60     |
 * | 1  | 4     | 60     |
 * | 3  | 4     | 70     |
 * Output
 * <p>
 * | Id | Month | Salary |
 * |----|-------|--------|
 * | 1  | 3     | 90     |
 * | 1  | 2     | 50     |
 * | 1  | 1     | 20     |
 * | 2  | 1     | 20     |
 * | 3  | 3     | 100    |
 * | 3  | 2     | 40     |
 * <p>
 * <p>
 * Explanation
 * Employee '1' has 3 salary records for the following 3 months except the most recent month '4': salary 40 for month '3', 30 for month '2' and 20 for month '1'
 * So the cumulative sum of salary of this employee over 3 months is 90(40+30+20), 50(30+20) and 20 respectively.
 * <p>
 * | Id | Month | Salary |
 * |----|-------|--------|
 * | 1  | 3     | 90     |
 * | 1  | 2     | 50     |
 * | 1  | 1     | 20     |
 * Employee '2' only has one salary record (month '1') except its most recent month '2'.
 * | Id | Month | Salary |
 * |----|-------|--------|
 * | 2  | 1     | 20     |
 * <p>
 * <p>
 * Employ '3' has two salary records except its most recent pay month '4': month '3' with 60 and month '2' with 40. So the cumulative salary is as following.
 * | Id | Month | Salary |
 * |----|-------|--------|
 * | 3  | 3     | 100    |
 * | 3  | 2     | 40     |
 */
public class Leetcode579 {
    public static void main(String[] args) {
        System.out.println("select \n" +
                "    E1.id,\n" +
                "    E1.month,\n" +
                "    (ifnull(E1.salary,0)+ifnull(E2.salary,0)+ifnull(E3.salary,0)) as Salary\n" +
                "from\n" +
                "        (select\n" +
                "        id,max(month) as month\n" +
                "        from Employee\n" +
                "        group by id\n" +
                "        having count(*)>1) as maxmonth\n" +
                "        left join\n" +
                "        Employee E1 on (maxmonth.id=E1.id and   maxmonth.month>E1.month)\n" +
                "        left join\n" +
                "        Employee E2 on (E2.id=E1.id and E2.month=E1.month-1)\n" +
                "        left join\n" +
                "        Employee E3 on (E3.id=E1.id and E3.month=E1.month-2)\n" +
                "        order by id asc, month desc;\n");
    }
}
