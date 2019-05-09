package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 19:24
 * @Description: Table: Candidate
 * <p>
 * +-----+---------+
 * | id  | Name    |
 * +-----+---------+
 * | 1   | A       |
 * | 2   | B       |
 * | 3   | C       |
 * | 4   | D       |
 * | 5   | E       |
 * +-----+---------+
 * Table: Vote
 * <p>
 * +-----+--------------+
 * | id  | CandidateId  |
 * +-----+--------------+
 * | 1   |     2        |
 * | 2   |     4        |
 * | 3   |     3        |
 * | 4   |     2        |
 * | 5   |     5        |
 * +-----+--------------+
 * id is the auto-increment primary key,
 * CandidateId is the id appeared in Candidate table.
 * Write a sql to find the name of the winning candidate, the above example will return the winner B.
 * <p>
 * +------+
 * | Name |
 * +------+
 * | B    |
 * +------+
 * Notes:
 * <p>
 * You may assume there is no tie, in other words there will be at most one winning candidate.
 */
public class Leetcode574 {
    public static void main(String[] args) {
        System.out.println("select\n" +
                "    name as 'Name'\n" +
                "from\n" +
                "    Candidate\n" +
                "        join\n" +
                "        (\n" +
                "            select CandidateId\n" +
                "            from\n" +
                "                Vote\n" +
                "            group by CandidateId\n" +
                "            order by Count(*) desc limit 1            \n" +
                "        ) as winner\n" +
                "        on Candidate.id=CandidateId;");
    }
}
