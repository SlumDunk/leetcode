package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 7/21/19 10:12
 * @Description: Table: Actions
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | user_id       | int     |
 * | post_id       | int     |
 * | action_date   | date    |
 * | action        | enum    |
 * | extra         | varchar |
 * +---------------+---------+
 * There is no primary key for this table, it may have duplicate rows.
 * The action column is an ENUM type of ('view', 'like', 'reaction', 'comment', 'report', 'share').
 * The extra column has optional information about the action such as a reason for report or a type of reaction.
 * <p>
 * <p>
 * Write an SQL query that reports the number of posts reported yesterday for each report reason. Assume today is 2019-07-05.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Actions table:
 * +---------+---------+-------------+--------+--------+
 * | user_id | post_id | action_date | action | extra  |
 * +---------+---------+-------------+--------+--------+
 * | 1       | 1       | 2019-07-01  | view   | null   |
 * | 1       | 1       | 2019-07-01  | like   | null   |
 * | 1       | 1       | 2019-07-01  | share  | null   |
 * | 2       | 4       | 2019-07-04  | view   | null   |
 * | 2       | 4       | 2019-07-04  | report | spam   |
 * | 3       | 4       | 2019-07-04  | view   | null   |
 * | 3       | 4       | 2019-07-04  | report | spam   |
 * | 4       | 3       | 2019-07-02  | view   | null   |
 * | 4       | 3       | 2019-07-02  | report | spam   |
 * | 5       | 2       | 2019-07-04  | view   | null   |
 * | 5       | 2       | 2019-07-04  | report | racism |
 * | 5       | 5       | 2019-07-04  | view   | null   |
 * | 5       | 5       | 2019-07-04  | report | racism |
 * +---------+---------+-------------+--------+--------+
 * <p>
 * Result table:
 * +---------------+--------------+
 * | report_reason | report_count |
 * +---------------+--------------+
 * | spam          | 1            |
 * | racism        | 2            |
 * +---------------+--------------+
 * Note that we only care about report reasons with non zero number of reports.
 */
public class Leetcode1113 {
    public static void main(String[] args) {
        System.out.println("select extra as report_reason, count(distinct post_id) as report_count from Actions where " +
                "extra is not null and action_date='2019-07-04' and action='report' group by extra;");
    }
}
