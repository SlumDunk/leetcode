package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 21:37
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
 * Write a SQL query that reports the device that is first logged in for each player.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Activity table:
 * +-----------+-----------+------------+--------------+
 * | player_id | device_id | event_date | games_played |
 * +-----------+-----------+------------+--------------+
 * | 1         | 2         | 2016-03-01 | 5            |
 * | 1         | 2         | 2016-05-02 | 6            |
 * | 2         | 3         | 2017-06-25 | 1            |
 * | 3         | 1         | 2016-03-02 | 0            |
 * | 3         | 4         | 2018-07-03 | 5            |
 * +-----------+-----------+------------+--------------+
 * <p>
 * Result table:
 * +-----------+-----------+
 * | player_id | device_id |
 * +-----------+-----------+
 * | 1         | 2         |
 * | 2         | 3         |
 * | 3         | 1         |
 * +-----------+-----------+
 */
public class Leetcode512 {
    public static void main(String[] args) {
        System.out.println("SELECT\n" +
                "\tplayer_id,\n" +
                "\tdevice_id \n" +
                "FROM\n" +
                "\tactivity a1 \n" +
                "WHERE\n" +
                "\tEXISTS (\n" +
                "\tSELECT\n" +
                "\t\t* from ( SELECT player_id, event_date FROM ( SELECT player_id, min( event_date ) as event_date FROM activity GROUP BY player_id ) as temp ) AS a2 \n" +
                "\tWHERE\n" +
                "\t\ta2.player_id = a1.player_id \n" +
                "\tAND a2.event_date = a1.event_date \n" +
                "\t);");
    }
}
