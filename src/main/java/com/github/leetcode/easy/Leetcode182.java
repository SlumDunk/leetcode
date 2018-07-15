package com.github.leetcode.easy;

/**
 * Write a SQL query to find all duplicate emails in a table named Person.
 * <p>
 * +----+---------+
 * | Id | Email   |
 * +----+---------+
 * | 1  | a@b.com |
 * | 2  | c@d.com |
 * | 3  | a@b.com |
 * +----+---------+
 * For example, your query should return the following for the above table:
 * <p>
 * +---------+
 * | Email   |
 * +---------+
 * | a@b.com |
 * +---------+
 */
public class Leetcode182 {
    public static void main(String[] args) {
        System.out.println("select Email from (select count(Email), Email from Person group by Email having count(Email)>1) t;");
    }
}
