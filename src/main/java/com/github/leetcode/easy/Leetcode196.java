package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 8/30/18 19:01
 * @Description: Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.
 * <p>
 * +----+------------------+
 * | Id | Email            |
 * +----+------------------+
 * | 1  | john@example.com |
 * | 2  | bob@example.com  |
 * | 3  | john@example.com |
 * +----+------------------+
 * Id is the primary key column for this table.
 * For example, after running your query, the above Person table should have the following rows:
 * <p>
 * +----+------------------+
 * | Id | Email            |
 * +----+------------------+
 * | 1  | john@example.com |
 * | 2  | bob@example.com  |
 * +----+------------------+
 */
public class Leetcode196 {
    public static void main(String[] args) {
        System.out.println("delete from Person where Id not in (select p2.Id from (select min(p1.Id) as Id from Person p1 group by p1.Email) as p2); ");
    }
}
