package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/21/19 10:35
 * @Description: Table: Events
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | business_id   | int     |
 * | event_type    | varchar |
 * | occurences    | int     |
 * +---------------+---------+
 * (business_id, event_type) is the primary key of this table.
 * Each row in the table logs the info that an event of some type occured at some business for a number of times.
 * <p>
 * <p>
 * Write an SQL query to find all active businesses.
 * <p>
 * An active business is a business that has more than one event type with occurences greater than the average occurences of that event type among all businesses.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Events table:
 * +-------------+------------+------------+
 * | business_id | event_type | occurences |
 * +-------------+------------+------------+
 * | 1           | reviews    | 7          |
 * | 3           | reviews    | 3          |
 * | 1           | ads        | 11         |
 * | 2           | ads        | 7          |
 * | 3           | ads        | 6          |
 * | 1           | page views | 3          |
 * | 2           | page views | 12         |
 * +-------------+------------+------------+
 * <p>
 * Result table:
 * +-------------+
 * | business_id |
 * +-------------+
 * | 1           |
 * +-------------+
 * Average for 'reviews', 'ads' and 'page views' are (7+3)/2=5, (11+7+6)/3=8, (3+12)/2=7.5 respectively.
 * Business with id 1 has 7 'reviews' events (more than 5) and 11 'ads' events (more than 8) so it is an active business.
 */
public class Leetcode1126 {
    public static void main(String[] args) {
        System.out.println("select\n" +
                "    distinct sumt.business_id\n" +
                "from\n" +
                "    (select business_id, event_type, sum(occurences) as sumO\n" +
                "    from events\n" +
                "    group by business_id, event_type) as sumt,\n" +
                "    (select event_type, avg(occurences) as averageO\n" +
                "    from events\n" +
                "    group by event_type) as avgt\n" +
                "where \n" +
                "    sumt.event_type = avgt.event_type and\n" +
                "    sumt.sumO > avgt.averageO\n" +
                "group by \n" +
                "    sumt.business_id\n" +
                "having\n" +
                "    count(sumt.event_type) > 1");
    }
}
