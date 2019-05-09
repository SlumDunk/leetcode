package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 18:25
 * @Description: Given two tables as below, write a query to display the comparison result (higher/lower/same) of the average salary of employees in a department to the company's average salary.
 * <p>
 * <p>
 * Table: salary
 * | id | employee_id | amount | pay_date   |
 * |----|-------------|--------|------------|
 * | 1  | 1           | 9000   | 2017-03-31 |
 * | 2  | 2           | 6000   | 2017-03-31 |
 * | 3  | 3           | 10000  | 2017-03-31 |
 * | 4  | 1           | 7000   | 2017-02-28 |
 * | 5  | 2           | 6000   | 2017-02-28 |
 * | 6  | 3           | 8000   | 2017-02-28 |
 * <p>
 * <p>
 * The employee_id column refers to the employee_id in the following table employee.
 * <p>
 * <p>
 * | employee_id | department_id |
 * |-------------|---------------|
 * | 1           | 1             |
 * | 2           | 2             |
 * | 3           | 2             |
 * <p>
 * <p>
 * So for the sample data above, the result is:
 * <p>
 * <p>
 * | pay_month | department_id | comparison  |
 * |-----------|---------------|-------------|
 * | 2017-03   | 1             | higher      |
 * | 2017-03   | 2             | lower       |
 * | 2017-02   | 1             | same        |
 * | 2017-02   | 2             | same        |
 * <p>
 * <p>
 * Explanation
 * <p>
 * <p>
 * In March, the company's average salary is (9000+6000+10000)/3 = 8333.33...
 * <p>
 * <p>
 * The average salary for department '1' is 9000, which is the salary of employee_id '1' since there is only one employee in this department. So the comparison result is 'higher' since 9000 > 8333.33 obviously.
 * <p>
 * <p>
 * The average salary of department '2' is (6000 + 10000)/2 = 8000, which is the average of employee_id '2' and '3'. So the comparison result is 'lower' since 8000 < 8333.33.
 * <p>
 * <p>
 * With he same formula for the average salary comparison in February, the result is 'same' since both the department '1' and '2' have the same average salary with the company, which is 7000.
 */
public class Leetcode615 {
    public static void main(String[] args) {
        System.out.println("select department_salary.pay_month, department_id,\n" +
                "case\n" +
                "    when department_avg>company_avg then 'higher'\n" +
                "    when department_avg<company_avg then 'lower'\n" +
                "    else 'same'\n" +
                "end as comparison\n" +
                "from\n" +
                "(\n" +
                "    select department_id, avg(amount) as        department_avg,date_format(pay_date,'%Y-%m') as pay_month\n" +
                "from salary join employee on salary.employee_id=employee.employee_id\n" +
                "    group by department_id,pay_month\n" +
                ") as department_salary\n" +
                "join\n" +
                "(\n" +
                "    select avg(amount) as company_avg,date_format(pay_date,'%Y-%m') as pay_month from salary group by pay_month\n" +
                ") as company_salary\n" +
                "on department_salary.pay_month=company_salary.pay_month;");
    }
}
