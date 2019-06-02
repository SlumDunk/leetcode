package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/2/19 16:46
 * @Description: Table: Sales
 * <p>
 * +-------------+-------+
 * | Column Name | Type  |
 * +-------------+-------+
 * | sale_id     | int   |
 * | product_id  | int   |
 * | year        | int   |
 * | quantity    | int   |
 * | price       | int   |
 * +-------------+-------+
 * (sale_id, year) is the primary key of this table.
 * product_id is a foreign key to Product table.
 * Note that the price is per unit.
 * Table: Product
 * <p>
 * +--------------+---------+
 * | Column Name  | Type    |
 * +--------------+---------+
 * | product_id   | int     |
 * | product_name | varchar |
 * +--------------+---------+
 * product_id is the primary key of this table.
 * <p>
 * <p>
 * Write an SQL query that reports all product names of the products in the Sales table along with their selling year and price.
 * <p>
 * For example:
 * <p>
 * Sales table:
 * +---------+------------+------+----------+-------+
 * | sale_id | product_id | year | quantity | price |
 * +---------+------------+------+----------+-------+
 * | 1       | 100        | 2008 | 10       | 5000  |
 * | 2       | 100        | 2009 | 12       | 5000  |
 * | 7       | 200        | 2011 | 15       | 9000  |
 * +---------+------------+------+----------+-------+
 * <p>
 * Product table:
 * +------------+--------------+
 * | product_id | product_name |
 * +------------+--------------+
 * | 100        | Nokia        |
 * | 200        | Apple        |
 * | 300        | Samsung      |
 * +------------+--------------+
 * <p>
 * Result table:
 * +--------------+-------+-------+
 * | product_name | year  | price |
 * +--------------+-------+-------+
 * | Nokia        | 2008  | 5000  |
 * | Nokia        | 2009  | 5000  |
 * | Apple        | 2011  | 9000  |
 * +--------------+-------+-------+
 */
public class Leetcode1068 {
    public static void main(String[] args) {
        System.out.println("select p.product_name,s.year,s.price from Sales s join Product p on s.product_id=p.product_id;");
    }
}
