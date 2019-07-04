package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 22:10
 * @Description: Table: Product
 * <p>
 * +--------------+---------+
 * | Column Name  | Type    |
 * +--------------+---------+
 * | product_id   | int     |
 * | product_name | varchar |
 * | unit_price   | int     |
 * +--------------+---------+
 * product_id is the primary key of this table.
 * Table: Sales
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | seller_id   | int     |
 * | product_id  | int     |
 * | buyer_id    | int     |
 * | sale_date   | date    |
 * | quantity    | int     |
 * | price       | int     |
 * +------ ------+---------+
 * This table has no primary key, it can have repeated rows.
 * product_id is a foreign key to Product table.
 * <p>
 * <p>
 * Write an SQL query that reports the best seller by total sales price, If there is a tie, report them all.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Product table:
 * +------------+--------------+------------+
 * | product_id | product_name | unit_price |
 * +------------+--------------+------------+
 * | 1          | S8           | 1000       |
 * | 2          | G4           | 800        |
 * | 3          | iPhone       | 1400       |
 * +------------+--------------+------------+
 * <p>
 * Sales table:
 * +-----------+------------+----------+------------+----------+-------+
 * | seller_id | product_id | buyer_id | sale_date  | quantity | price |
 * +-----------+------------+----------+------------+----------+-------+
 * | 1         | 1          | 1        | 2019-01-21 | 2        | 2000  |
 * | 1         | 2          | 2        | 2019-02-17 | 1        | 800   |
 * | 2         | 2          | 3        | 2019-06-02 | 1        | 800   |
 * | 3         | 3          | 4        | 2019-05-13 | 2        | 2800  |
 * +-----------+------------+----------+------------+----------+-------+
 * <p>
 * Result table:
 * +-------------+
 * | seller_id   |
 * +-------------+
 * | 1           |
 * | 3           |
 * +-------------+
 * Both sellers with id 1 and 3 sold products with the most total price of 2800.
 */
public class Leetcode1082 {
    public static void main(String[] args) {
        System.out.println("SELECT\n" +
                "\tseller_id \n" +
                "FROM\n" +
                "\tSales \n" +
                "GROUP BY\n" +
                "\tseller_id \n" +
                "HAVING\n" +
                "\tSUM( price ) = ( SELECT SUM( price ) AS total FROM Sales S GROUP BY seller_id ORDER BY total DESC LIMIT 1 )");
    }
}
