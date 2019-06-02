package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/2/19 16:42
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
 * Write an SQL query that reports the total quantity sold for every product id.
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
 * +--------------+----------------+
 * | product_id   | total_quantity |
 * +--------------+----------------+
 * | 100          | 22             |
 * | 200          | 15             |
 * +--------------+----------------+
 */
public class Leetcode1069 {
    public static void main(String[] args) {
        System.out.println("select s.product_id, sum(s.quantity) as 'total_quantity' from Sales s group by s.product_id; ");
    }
}
