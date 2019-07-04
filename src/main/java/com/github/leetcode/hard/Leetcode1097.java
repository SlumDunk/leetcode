package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 21:09
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
 * We define the install date of a player to be the first login day of that player.
 * <p>
 * We also define day 1 retention of some date X to be the number of players whose install date is X and they logged back in on the day right after X, divided by the number of players whose install date is X, rounded to 2 decimal places.
 * <p>
 * Write an SQL query that reports for each install date, the number of players that installed the game on that day and the day 1 retention.
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
 * | 3         | 1         | 2016-03-01 | 0            |
 * | 3         | 4         | 2016-07-03 | 5            |
 * +-----------+-----------+------------+--------------+
 * <p>
 * Result table:
 * +------------+----------+----------------+
 * | install_dt | installs | Day1_retention |
 * +------------+----------+----------------+
 * | 2016-03-01 | 2        | 0.50           |
 * | 2017-06-25 | 1        | 0.00           |
 * +------------+----------+----------------+
 * Player 1 and 3 installed the game on 2016-03-01 but only player 1 logged back in on 2016-03-02 so the day 1 retention of 2016-03-01 is 1 / 2 = 0.50
 * Player 2 installed the game on 2017-06-25 but didn't log back in on 2017-06-26 so the day 1 retention of 2017-06-25 is 0 / 1 = 0.00
 */
public class Leetcode1097 {
    public static void main(String[] args) {
        System.out.println("SELECT\n" +
                "\ta1.event_date AS install_dt,\n" +
                "\tcount( DISTINCT a1.player_id ) AS installs,\n" +
                "\tround( sum( CASE WHEN a2.event_date IS NOT NULL THEN 1 ELSE 0 END ) / count( DISTINCT a1.player_id ), 2 ) AS Day1_retention \n" +
                "FROM\n" +
                "\t( SELECT player_id, min( event_date ) AS event_date FROM Activity GROUP BY player_id ) a1\n" +
                "\tLEFT JOIN Activity a2 ON a1.player_id = a2.player_id \n" +
                "\tAND a1.event_date = a2.event_date - 1 \n" +
                "GROUP BY\n" +
                "\tinstall_dt");
    }
}
