package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 10:44
 * @Description: A university uses 2 data tables, student and department, to store data about its students and the departments associated with each major.
 * <p>
 * Write a query to print the respective department name and number of students majoring in each department for all departments in the department table (even ones with no current students).
 * <p>
 * Sort your results by descending number of students; if two or more departments have the same number of students, then sort those departments alphabetically by department name.
 * <p>
 * The student is described as follow:
 * <p>
 * | Column Name  | Type      |
 * |--------------|-----------|
 * | student_id   | Integer   |
 * | student_name | String    |
 * | gender       | Character |
 * | dept_id      | Integer   |
 * where student_id is the student's ID number, student_name is the student's name, gender is their gender, and dept_id is the department ID associated with their declared major.
 * <p>
 * And the department table is described as below:
 * <p>
 * | Column Name | Type    |
 * |-------------|---------|
 * | dept_id     | Integer |
 * | dept_name   | String  |
 * where dept_id is the department's ID number and dept_name is the department name.
 * <p>
 * Here is an example input:
 * student table:
 * <p>
 * | student_id | student_name | gender | dept_id |
 * |------------|--------------|--------|---------|
 * | 1          | Jack         | M      | 1       |
 * | 2          | Jane         | F      | 1       |
 * | 3          | Mark         | M      | 2       |
 * department table:
 * <p>
 * | dept_id | dept_name   |
 * |---------|-------------|
 * | 1       | Engineering |
 * | 2       | Science     |
 * | 3       | Law         |
 * The Output should be:
 * <p>
 * | dept_name   | student_number |
 * |-------------|----------------|
 * | Engineering | 2              |
 * | Science     | 1              |
 * | Law         | 0              |
 */
public class Leetcode580 {
    public static void main(String[] args) {
        System.out.println("select\n" +
                "    dept_name, count(student_id) as student_number\n" +
                "from\n" +
                "    department\n" +
                "        left join\n" +
                "    student on department.dept_id=student.dept_id\n" +
                "group by department.dept_name\n" +
                "order by student_number desc, department.dept_name;");
    }
}
