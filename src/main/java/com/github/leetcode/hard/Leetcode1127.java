package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 7/24/19 14:38
 * @Description: Table: Spending
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | user_id     | int     |
 * | spend_date  | date    |
 * | platform    | enum    |
 * | amount      | int     |
 * +-------------+---------+
 * The table logs the spendings history of users that make purchases from an online shopping website which has a desktop and a mobile application.
 * (user_id, spend_date, platform) is the primary key of this table.
 * The platform column is an ENUM type of ('desktop', 'mobile').
 * Write an SQL query to find the total number of users and the total amount spent using mobile only, desktop only and both mobile and desktop together for each date.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Spending table:
 * +---------+------------+----------+--------+
 * | user_id | spend_date | platform | amount |
 * +---------+------------+----------+--------+
 * | 1       | 2019-07-01 | mobile   | 100    |
 * | 1       | 2019-07-01 | desktop  | 100    |
 * | 2       | 2019-07-01 | mobile   | 100    |
 * | 2       | 2019-07-02 | mobile   | 100    |
 * | 3       | 2019-07-01 | desktop  | 100    |
 * | 3       | 2019-07-02 | desktop  | 100    |
 * +---------+------------+----------+--------+
 * <p>
 * Result table:
 * +------------+----------+--------------+-------------+
 * | spend_date | platform | total_amount | total_users |
 * +------------+----------+--------------+-------------+
 * | 2019-07-01 | desktop  | 100          | 1           |
 * | 2019-07-01 | mobile   | 100          | 1           |
 * | 2019-07-01 | both     | 200          | 1           |
 * | 2019-07-02 | desktop  | 100          | 1           |
 * | 2019-07-02 | mobile   | 100          | 1           |
 * | 2019-07-02 | both     | 0            | 0           |
 * +------------+----------+--------------+-------------+
 * On 2019-07-01, user 1 purchased using both desktop and mobile, user 2 purchased using mobile only and user 3 purchased using desktop only.
 * On 2019-07-02, user 2 purchased using mobile only, user 3 purchased using desktop only and no one purchased using both platforms.
 */
public class Leetcode1127 {
    public static void main(String[] args) {
        System.out.println("\tSELECT\n" +
                "\t\tspend_date,\n" +
                "\t\tuser_id,\n" +
                "\tIF\n" +
                "\t\t( mobile_amount > 0, IF ( desktop_amount > 0, 'both', 'mobile' ), 'desktop' ) platform,\n" +
                "\t\t( mobile_amount + desktop_amount ) amount \n" +
                "\tFROM\n" +
                "\t\t(\n" +
                "\t\tSELECT\n" +
                "\t\t\tspend_date,\n" +
                "\t\t\tuser_id,\n" +
                "\t\t\tSUM( CASE platform WHEN 'mobile' THEN amount ELSE 0 END ) mobile_amount,\n" +
                "\t\t\tSUM( CASE platform WHEN 'desktop' THEN amount ELSE 0 END ) desktop_amount \n" +
                "\t\tFROM\n" +
                "\t\t\tSpending \n" +
                "\t\tGROUP BY\n" +
                "\t\t\tspend_date,\n" +
                "\t\t\tuser_id \n" +
                "\t\t) o ");
    }
}
