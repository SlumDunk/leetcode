package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 07:44
 * @Description: Table: Activity
 * <p>
 * +--------------+---------+
 * | Column Name  | Type    |
 * +--------------+---------+
 * | player_id    | int     |
 * | device_id    | int     |
 * | event_date   | date    |
 * | games_played | int     |
 * +--------------+---------+
 * (player_id, event_date) is the primary key of this table.
 * This table shows the activity of players of some game.
 * Each row is a record of a player who logged in and played a number of games (possibly 0) before logging out on some day using some device.
 * <p>
 * <p>
 * Write an SQL query that reports the fraction of players that logged in again on the day after the day they first logged in, rounded to 2 decimal places. In other words, you need to count the number of players that logged in for at least two consecutive days starting from their first login date, then divide that number by the total number of players.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Activity table:
 * +-----------+-----------+------------+--------------+
 * | player_id | device_id | event_date | games_played |
 * +-----------+-----------+------------+--------------+
 * | 1         | 2         | 2016-03-01 | 5            |
 * | 1         | 2         | 2016-03-02 | 6            |
 * | 2         | 3         | 2017-06-25 | 1            |
 * | 3         | 1         | 2016-03-02 | 0            |
 * | 3         | 4         | 2018-07-03 | 5            |
 * +-----------+-----------+------------+--------------+
 * <p>
 * Result table:
 * +-----------+
 * | fraction  |
 * +-----------+
 * | 0.33      |
 * +-----------+
 * Only the player with id 1 logged back in after the first day he had logged in so the answer is 1/3 = 0.33
 */
public class Leetcode550 {
    public static void main(String[] args) {
        System.out.println("select \n" +
                "round(sum(case when a.first_date+1=b.event_date then 1 else 0 end)/count(distinct a.player_id),2) as fraction\n" +
                "from\n" +
                "(select player_id, min(event_date) as first_date\n" +
                "from activity\n" +
                "group by player_id) a\n" +
                "join activity b\n" +
                "on a.player_id = b.player_id;");
    }
}
