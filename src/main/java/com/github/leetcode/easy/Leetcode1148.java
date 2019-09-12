package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/11/19 09:50
 * @Description: Table: Views
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | article_id    | int     |
 * | author_id     | int     |
 * | viewer_id     | int     |
 * | view_date     | date    |
 * +---------------+---------+
 * There is no primary key for this table, it may have duplicate rows.
 * Each row of this table indicates that some viewer viewed an article (written by some author) on some date.
 * Note that equal author_id and viewer_id indicate the same person.
 * <p>
 * <p>
 * Write an SQL query to find all the authors that viewed at least one of their own articles, sorted in ascending order by their id.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Views table:
 * +------------+-----------+-----------+------------+
 * | article_id | author_id | viewer_id | view_date  |
 * +------------+-----------+-----------+------------+
 * | 1          | 3         | 5         | 2019-08-01 |
 * | 1          | 3         | 6         | 2019-08-02 |
 * | 2          | 7         | 7         | 2019-08-01 |
 * | 2          | 7         | 6         | 2019-08-02 |
 * | 4          | 7         | 1         | 2019-07-22 |
 * | 3          | 4         | 4         | 2019-07-21 |
 * | 3          | 4         | 4         | 2019-07-21 |
 * +------------+-----------+-----------+------------+
 * <p>
 * Result table:
 * +------+
 * | id   |
 * +------+
 * | 4    |
 * | 7    |
 * +------+
 */
public class Leetcode1148 {
    public static void main(String[] args) {
        System.out.println("select distinct(author_id) as 'id' from Views where author_id=viewer_id order by id;");
    }
}
