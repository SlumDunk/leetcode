package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 08:01
 * @Description:
 */
public class Leetcode1077 {
    public static void main(String[] args) {
        System.out.println("SELECT p.project_id,\n" +
                "       p.employee_id\n" +
                "FROM   Project p\n" +
                "JOIN   Employee e\n" +
                "ON     p.employee_id = e.employee_id\n" +
                "JOIN  (SELECT   p.project_id,\n" +
                "                MAX(experience_years) AS most_experience\n" +
                "       FROM     Project p\n" +
                "       JOIN     Employee e\n" +
                "       ON       p.employee_id = e.employee_id\n" +
                "       GROUP BY p.project_id) m\n" +
                "ON     p.project_id = m.project_id\n" +
                "WHERE  e.experience_years = m.most_experience;");
    }
}
