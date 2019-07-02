package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 09:15
 * @Description:
 */
public class Leetcode1045 {
    public static void main(String[] args) {
        System.out.println("SELECT\n" +
                "    c.customer_id\n" +
                "FROM\n" +
                "    Customer c\n" +
                "GROUP BY\n" +
                "    c.customer_id\n" +
                "HAVING\n" +
                "    count(DISTINCT product_key) = (SELECT count(*) FROM Product);");
    }
}
