package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 9/14/19 21:50
 * @Description:
 */
public class Leetcode1174 {
    public static void main(String[] args) {
        System.out.println("select round(100*sum(order_date=customer_pref_delivery_date)/count(order_date),2) as immediate_percentage\n" +
                "from Delivery\n" +
                "where (customer_id, order_date) in (\n" +
                "select customer_id, min(order_date)\n" +
                "from Delivery\n" +
                "group by customer_id\n" +
                ")");
    }
}
