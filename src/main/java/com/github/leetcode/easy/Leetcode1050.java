package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/2/19 16:56
 * @Description: Table: ActorDirector
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | actor_id    | int     |
 * | director_id | int     |
 * | timestamp   | int     |
 * +-------------+---------+
 * timestamp is the primary key column for this table.
 * <p>
 * <p>
 * Write a SQL query for a report that provides the pairs (actor_id, director_id) where the actor have cooperated with the director at least 3 times.
 * <p>
 * Example:
 * <p>
 * ActorDirector table:
 * +-------------+-------------+-------------+
 * | actor_id    | director_id | timestamp   |
 * +-------------+-------------+-------------+
 * | 1           | 1           | 0           |
 * | 1           | 1           | 1           |
 * | 1           | 1           | 2           |
 * | 1           | 2           | 3           |
 * | 1           | 2           | 4           |
 * | 2           | 1           | 5           |
 * | 2           | 1           | 6           |
 * +-------------+-------------+-------------+
 * <p>
 * Result table:
 * +-------------+-------------+
 * | actor_id    | director_id |
 * +-------------+-------------+
 * | 1           | 1           |
 * +-------------+-------------+
 * The only pair is (1, 1) where they cooperated exactly 3 times.
 */
public class Leetcode1050 {
    public static void main(String[] args) {
        System.out.println("select ad.actor_id,ad.director_id from ActorDirector ad group by actor_id,director_id having count(timestamp)>=3;");
    }
}
