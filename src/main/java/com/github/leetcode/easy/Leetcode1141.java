package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/11/19 09:09
 * @Description: Table: Activity
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | user_id       | int     |
 * | session_id    | int     |
 * | activity_date | date    |
 * | activity_type | enum    |
 * +---------------+---------+
 * There is no primary key for this table, it may have duplicate rows.
 * The activity_type column is an ENUM of type ('open_session', 'end_session', 'scroll_down', 'send_message').
 * The table shows the user activities for a social media website.
 * Note that each session belongs to exactly one user.
 * <p>
 * <p>
 * Write an SQL query to find the daily active user count for a period of 30 days ending 2019-07-27 inclusively. A user was active on some day if he/she made at least one activity on that day.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Activity table:
 * +---------+------------+---------------+---------------+
 * | user_id | session_id | activity_date | activity_type |
 * +---------+------------+---------------+---------------+
 * | 1       | 1          | 2019-07-20    | open_session  |
 * | 1       | 1          | 2019-07-20    | scroll_down   |
 * | 1       | 1          | 2019-07-20    | end_session   |
 * | 2       | 4          | 2019-07-20    | open_session  |
 * | 2       | 4          | 2019-07-21    | send_message  |
 * | 2       | 4          | 2019-07-21    | end_session   |
 * | 3       | 2          | 2019-07-21    | open_session  |
 * | 3       | 2          | 2019-07-21    | send_message  |
 * | 3       | 2          | 2019-07-21    | end_session   |
 * | 4       | 3          | 2019-06-25    | open_session  |
 * | 4       | 3          | 2019-06-25    | end_session   |
 * +---------+------------+---------------+---------------+
 * <p>
 * Result table:
 * +------------+--------------+
 * | day        | active_users |
 * +------------+--------------+
 * | 2019-07-20 | 2            |
 * | 2019-07-21 | 2            |
 * +------------+--------------+
 * Note that we do not care about days with zero active users.
 */
public class Leetcode1141 {
    public static void main(String[] args) {
        System.out.println("SELECT\n" +
                "\tactivity_date AS 'day',\n" +
                "\tcount( DISTINCT user_id ) AS 'active_users' \n" +
                "FROM Activity\n" +
                "WHERE\n" +
                "\tactivity_date>=date_add('2019-07-27', interval -29 day) and activity_date <= '2019-07-27' \n" +
                "GROUP BY\n" +
                "\tday;");
    }
}
