package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 22:14
 * @Description:
 */
public class Leetcode1083 {
    public static void main(String[] args) {
        System.out.println("SELECT DISTINCT\n" +
                "\ta.buyer_id \n" +
                "FROM\n" +
                "\tsales a\n" +
                "\tLEFT JOIN product b ON a.product_id = b.product_id \n" +
                "WHERE\n" +
                "\tupper( b.product_name ) = 'S8' \n" +
                "\tAND a.buyer_id NOT IN ( SELECT DISTINCT a.buyer_id FROM sales a LEFT JOIN product b ON a.product_id = b.product_id WHERE upper( b.product_name ) = 'IPHONE' )");
    }
}
