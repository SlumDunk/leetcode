package com.github.leetcode.easy;

/**
 * Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.
 * <p>
 * +---------+------------------+------------------+
 * | Id(INT) | RecordDate(DATE) | Temperature(INT) |
 * +---------+------------------+------------------+
 * |       1 |       2015-01-01 |               10 |
 * |       2 |       2015-01-02 |               25 |
 * |       3 |       2015-01-03 |               20 |
 * |       4 |       2015-01-04 |               30 |
 * +---------+------------------+------------------+
 * For example, return the following Ids for the above Weather table:
 * <p>
 * +----+
 * | Id |
 * +----+
 * |  2 |
 * |  4 |
 * +----+
 */
public class Leetcode197 {
    public static void main(String[] args) {
        System.out.println("select w1.Id from Weather w1, Weather w2 where w1.Temperature>w2.Temperature and DATEDIFF(w1.RecordDate,w2.RecordDate)=1;");
    }
}
