package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 22:20
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
 * Write an SQL query that reports the products that were only sold in spring 2019. That is, between 2019-01-01 and 2019-03-31 inclusive.
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
 * +-------------+--------------+
 * | product_id  | product_name |
 * +-------------+--------------+
 * | 1           | S8           |
 * +-------------+--------------+
 * The product with id 1 was only sold in spring 2019 while the other two were sold after.
 */
public class Leetcode1084 {
    public static void main(String[] args) {
        System.out.println("SELECT\n" +
                "\ts.product_id,\n" +
                "\tproduct_name \n" +
                "FROM\n" +
                "\tSales s\n" +
                "\tLEFT JOIN Product p ON s.product_id = p.product_id \n" +
                "GROUP BY\n" +
                "\ts.product_id \n" +
                "HAVING\n" +
                "\tMIN( sale_date ) >= CAST( '2019-01-01' AS DATE ) \n" +
                "\tAND MAX( sale_date ) <= CAST( '2019-03-31' AS DATE )");
    }
}
