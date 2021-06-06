package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/25/20 20:24
 * @Description: Table: Submissions
 * <p>
 * +---------------+----------+
 * | Column Name   | Type     |
 * +---------------+----------+
 * | sub_id        | int      |
 * | parent_id     | int      |
 * +---------------+----------+
 * There is no primary key for this table, it may have duplicate rows.
 * Each row can be a post or comment on the post.
 * parent_id is null for posts.
 * parent_id for comments is sub_id for another post in the table.
 * <p>
 * <p>
 * Write an SQL query to find number of comments per each post.
 * <p>
 * Result table should contain post_id and its corresponding number_of_comments, and must be sorted by post_id in ascending order.
 * <p>
 * Submissions may contain duplicate comments. You should count the number of unique comments per post.
 * <p>
 * Submissions may contain duplicate posts. You should treat them as one post.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Submissions table:
 * +---------+------------+
 * | sub_id  | parent_id  |
 * +---------+------------+
 * | 1       | Null       |
 * | 2       | Null       |
 * | 1       | Null       |
 * | 12      | Null       |
 * | 3       | 1          |
 * | 5       | 2          |
 * | 3       | 1          |
 * | 4       | 1          |
 * | 9       | 1          |
 * | 10      | 2          |
 * | 6       | 7          |
 * +---------+------------+
 * <p>
 * Result table:
 * +---------+--------------------+
 * | post_id | number_of_comments |
 * +---------+--------------------+
 * | 1       | 3                  |
 * | 2       | 2                  |
 * | 12      | 0                  |
 * +---------+--------------------+
 * <p>
 * The post with id 1 has three comments in the table with id 3, 4 and 9. The comment with id 3 is repeated in the table, we counted it only once.
 * The post with id 2 has two comments in the table with id 5 and 10.
 * The post with id 12 has no comments in the table.
 * The comment with id 6 is a comment on a deleted post with id 7 so we ignored it.
 */
public class Leetcode1241 {
    public static void main(String[] args) {
        System.out.println("select s1.sub_id as post_id, ifnull(count(distinct s2.sub_id),0) as number_of_comments from Submissions s1\n" +
                "left join Submissions s2 on s1.sub_id = s2.parent_id \n" +
                "where s1.parent_id is Null\n" +
                "group by 1\n" +
                "order by 1");
    }
}
