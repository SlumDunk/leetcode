package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 9/15/19 12:26
 * @Description:
 */
public class Leetcode1158 {
    public static void main(String[] args) {
        System.out.println("SELECT\n" +
                "\tuser_id AS buyer_id,\n" +
                "\tMIN( join_date ) join_date,\n" +
                "\tCOALESCE ( COUNT( o.order_id ), 0 ) AS orders_in_2019 \n" +
                "FROM\n" +
                "\tUsers u\n" +
                "\tLEFT JOIN Orders o ON u.user_id = o.buyer_id \n" +
                "\tAND YEAR ( order_date ) = '2019' \n" +
                "GROUP BY\n" +
                "\tuser_id");
    }
}
