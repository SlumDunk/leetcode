package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 10:35
 * @Description: X city built a new stadium, each day many people visit it and the stats are saved as these columns: id, visit_date, people
 * <p>
 * Please write a query to display the records which have 3 or more consecutive rows and the amount of people more than 100(inclusive).
 * <p>
 * For example, the table stadium:
 * +------+------------+-----------+
 * | id   | visit_date | people    |
 * +------+------------+-----------+
 * | 1    | 2017-01-01 | 10        |
 * | 2    | 2017-01-02 | 109       |
 * | 3    | 2017-01-03 | 150       |
 * | 4    | 2017-01-04 | 99        |
 * | 5    | 2017-01-05 | 145       |
 * | 6    | 2017-01-06 | 1455      |
 * | 7    | 2017-01-07 | 199       |
 * | 8    | 2017-01-08 | 188       |
 * +------+------------+-----------+
 * For the sample data above, the output is:
 * <p>
 * +------+------------+-----------+
 * | id   | visit_date | people    |
 * +------+------------+-----------+
 * | 5    | 2017-01-05 | 145       |
 * | 6    | 2017-01-06 | 1455      |
 * | 7    | 2017-01-07 | 199       |
 * | 8    | 2017-01-08 | 188       |
 * +------+------------+-----------+
 * Note:
 * Each day only have one row record, and the dates are increasing with id increasing.
 */
public class Leetcode601 {
    public static void main(String[] args) {
        System.out.println("select distinct t1.*\n" +
                "from stadium t1,stadium t2,stadium t3\n" +
                "where t1.people>=100 and t2.people>=100 and t3.people>=100\n" +
                "and\n" +
                "(\n" +
                "    (t1.id-t2.id=1 and t1.id-t3.id=2 and t2.id -t3.id=1) #t1,t2,t3\n" +
                "    or\n" +
                "    (t2.id-t1.id=1 and t2.id-t3.id=2 and t1.id-t3.id=1)\n" +
                "    #t2,t1,t3\n" +
                "    or\n" +
                "    (t3.id-t2.id=1 and t2.id-t1.id=1 and t3.id-t1.id=2)\n" +
                "    #t3,t2,t1\n" +
                ")\n" +
                "order by t1.id;");
    }
}
