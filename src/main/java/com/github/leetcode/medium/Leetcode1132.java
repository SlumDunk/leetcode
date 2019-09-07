package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/24/19 13:01
 * @Description:
 */
public class Leetcode1132 {
    public static void main(String[] args) {
        System.out.println("SELECT\n" +
                "\tROUND( SUM( perc_removal ) / COUNT( 1 ), 2 ) average_daily_percent \n" +
                "FROM\n" +
                "\t(\n" +
                "\tSELECT\n" +
                "\t\ta.action_date,\n" +
                "\t\tCOUNT( DISTINCT r.post_id ) / COUNT( DISTINCT a.post_id ) * 100 perc_removal \n" +
                "\tFROM\n" +
                "\t\tActions a\n" +
                "\t\tLEFT JOIN Removals r ON a.post_id = r.post_id \n" +
                "\tWHERE\n" +
                "\t\ta.action='report'\n" +
                "\t\tand\n" +
                "\t\ta.extra = 'spam' \n" +
                "\tGROUP BY\n" +
                "\ta.action_date \n" +
                "\t) t");
    }
}
