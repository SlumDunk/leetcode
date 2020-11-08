package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 10:30
 * @Description: Write a SQL query to rank scores. If there is a tie between two scores, both should have the same ranking. Note that after a tie, the children ranking number should be the children consecutive integer frequency. In other words, there should be no "holes" between ranks.
 * <p>
 * +----+-------+
 * | Id | Score |
 * +----+-------+
 * | 1  | 3.50  |
 * | 2  | 3.65  |
 * | 3  | 4.00  |
 * | 4  | 3.85  |
 * | 5  | 4.00  |
 * | 6  | 3.65  |
 * +----+-------+
 * For example, given the above Scores table, your query should generate the following report (order by highest score):
 * <p>
 * +-------+------+
 * | Score | Rank |
 * +-------+------+
 * | 4.00  | 1    |
 * | 4.00  | 1    |
 * | 3.85  | 2    |
 * | 3.65  | 3    |
 * | 3.65  | 3    |
 * | 3.50  | 4    |
 * +-------+------+
 */
public class Leetcode178 {
    public static void main(String[] args) {
        System.out.println("select s.Score, \n" +
                "(\n" +
                "    select count(*) from \n" +
                "    (\n" +
                "        select distinct Score \n" +
                "        from Scores \n" +
                "    )\n" +
                "    tmp\n" +
                "    where \n" +
                "    tmp.Score>=s.Score\n" +
                ") \n" +
                "as Rank \n" +
                "from Scores s order by s.Score desc;");
    }
}
