package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 9/15/19 12:12
 * @Description: 1164. Product Price at a Given Date
 * Medium
 * <p>
 * 15
 * <p>
 * 2
 * <p>
 * Favorite
 * <p>
 * Share
 * SQL Schema
 * Table: Products
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | product_id    | int     |
 * | new_price     | int     |
 * | change_date   | date    |
 * +---------------+---------+
 * (product_id, change_date) is the primary key of this table.
 * Each row of this table indicates that the price of some product was changed to a new price at some date.
 * <p>
 * <p>
 * Write an SQL query to find the prices of all products on 2019-08-16. Assume the price of all products before any change is 10.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Products table:
 * +------------+-----------+-------------+
 * | product_id | new_price | change_date |
 * +------------+-----------+-------------+
 * | 1          | 20        | 2019-08-14  |
 * | 2          | 50        | 2019-08-14  |
 * | 1          | 30        | 2019-08-15  |
 * | 1          | 35        | 2019-08-16  |
 * | 2          | 65        | 2019-08-17  |
 * | 3          | 20        | 2019-08-18  |
 * +------------+-----------+-------------+
 * <p>
 * Result table:
 * +------------+-------+
 * | product_id | price |
 * +------------+-------+
 * | 2          | 50    |
 * | 1          | 35    |
 * | 3          | 10    |
 * +------------+-------+
 */
public class Leetcode1164 {
    public static void main(String[] args) {
        System.out.println("SELECT\n" +
                "\tproduct_id,\n" +
                "\tmax( price ) AS price \n" +
                "FROM\n" +
                "\t(\n" +
                "\tSELECT\n" +
                "\t\tproduct_id,\n" +
                "\tCASE\n" +
                "\t\t\t\n" +
                "\t\t\tWHEN ( product_id, change_date ) IN ( SELECT product_id, max( change_date ) FROM products WHERE change_date <= date( '2019-08-16' ) GROUP BY product_id ) THEN\n" +
                "\t\t\tnew_price ELSE 10 \n" +
                "\t\tEND AS price \n" +
                "\tFROM\n" +
                "\t\tproducts \n" +
                "\t) AS temp1 \n" +
                "GROUP BY\n" +
                "\ttemp1.product_id \n" +
                "ORDER BY\n" +
                "\tprice DESC");
    }
}
