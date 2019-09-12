package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/11/19 11:55
 * @Description:
 */
public class Leetcode1173 {
    public static void main(String[] args) {
        System.out.println("select round(100*a.immediate/count(b.delivery_id),2)  as 'immediate_percentage' from (\n" +
                "select count(delivery_id) as 'immediate' from Delivery where order_date=customer_pref_delivery_date) as a, Delivery as b;");
    }
}
