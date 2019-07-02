package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 08:19
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
 * sale_id is the primary key of this table.
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
 * Write an SQL query that selects the product id, year, quantity, and price for the first year of every product sold.
 * <p>
 * The query result format is in the following example:
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
 * +------------+------------+----------+-------+
 * | product_id | first_year | quantity | price |
 * +------------+------------+----------+-------+
 * | 100        | 2008       | 10       | 5000  |
 * | 200        | 2011       | 15       | 9000  |
 * +------------+------------+----------+-------+
 */
public class Leetcode1070 {
    public static void main(String[] args) {
        System.out.println("select distinct product_id, year as first_year, quantity, price\n" +
                "from sales s\n" +
                "where (product_id, year) in\n" +
                "(Select product_id, min(year) from sales group by product_id)");
    }
}
