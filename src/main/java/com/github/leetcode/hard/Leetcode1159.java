package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 9/12/19 14:14
 * @Description: Table: Users
 * <p>
 * +----------------+---------+
 * | Column Name    | Type    |
 * +----------------+---------+
 * | user_id        | int     |
 * | join_date      | date    |
 * | favorite_brand | varchar |
 * +----------------+---------+
 * user_id is the primary key of this table.
 * This table has the info of the users of an online shopping website where users can sell and buy items.
 * Table: Orders
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | order_id      | int     |
 * | order_date    | date    |
 * | item_id       | int     |
 * | buyer_id      | int     |
 * | seller_id     | int     |
 * +---------------+---------+
 * order_id is the primary key of this table.
 * item_id is a foreign key to the Items table.
 * buyer_id and seller_id are foreign keys to the Users table.
 * Table: Items
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | item_id       | int     |
 * | item_brand    | varchar |
 * +---------------+---------+
 * item_id is the primary key of this table.
 * <p>
 * <p>
 * Write an SQL query to find for each user, whether the brand of the second item (by date) they sold is their favorite brand. If a user sold less than two items, report the answer for that user as no.
 * <p>
 * It is guaranteed that no seller sold more than one item on a day.
 * <p>
 * The query result format is in the following example:
 * <p>
 * Users table:
 * +---------+------------+----------------+
 * | user_id | join_date  | favorite_brand |
 * +---------+------------+----------------+
 * | 1       | 2019-01-01 | Lenovo         |
 * | 2       | 2019-02-09 | Samsung        |
 * | 3       | 2019-01-19 | LG             |
 * | 4       | 2019-05-21 | HP             |
 * +---------+------------+----------------+
 * <p>
 * Orders table:
 * +----------+------------+---------+----------+-----------+
 * | order_id | order_date | item_id | buyer_id | seller_id |
 * +----------+------------+---------+----------+-----------+
 * | 1        | 2019-08-01 | 4       | 1        | 2         |
 * | 2        | 2019-08-02 | 2       | 1        | 3         |
 * | 3        | 2019-08-03 | 3       | 2        | 3         |
 * | 4        | 2019-08-04 | 1       | 4        | 2         |
 * | 5        | 2019-08-04 | 1       | 3        | 4         |
 * | 6        | 2019-08-05 | 2       | 2        | 4         |
 * +----------+------------+---------+----------+-----------+
 * <p>
 * Items table:
 * +---------+------------+
 * | item_id | item_brand |
 * +---------+------------+
 * | 1       | Samsung    |
 * | 2       | Lenovo     |
 * | 3       | LG         |
 * | 4       | HP         |
 * +---------+------------+
 * <p>
 * Result table:
 * +-----------+--------------------+
 * | seller_id | 2nd_item_fav_brand |
 * +-----------+--------------------+
 * | 1         | no                 |
 * | 2         | yes                |
 * | 3         | yes                |
 * | 4         | no                 |
 * +-----------+--------------------+
 * <p>
 * The answer for the user with id 1 is no because they sold nothing.
 * The answer for the users with id 2 and 3 is yes because the brands of their second sold items are their favorite brands.
 * The answer for the user with id 4 is no because the brand of their second sold item is not their favorite brand.
 */
public class Leetcode1159 {
    public static void main(String[] args) {
        System.out.println("SELECT\n" +
                "\tu.user_id AS seller_id,\n" +
                "CASE\n" +
                "\t\t\n" +
                "\t\tWHEN i.item_brand = u.favorite_brand THEN\n" +
                "\t\t\"yes\" ELSE \"no\" \n" +
                "\tEND AS 2 nd_item_fav_brand \n" +
                "FROM\n" +
                "\tusers u\n" +
                "\tLEFT JOIN (\n" +
                "\tSELECT\n" +
                "\t\to2.order_id,\n" +
                "\t\to1.seller_id,\n" +
                "\t\to2.item_id \n" +
                "\tFROM\n" +
                "\t\torders o1\n" +
                "\t\tLEFT JOIN orders o2 ON o1.order_date < o2.order_date \n" +
                "\t\tAND o1.seller_id = o2.seller_id \n" +
                "\tGROUP BY\n" +
                "\t\to2.order_id \n" +
                "\tHAVING\n" +
                "\t\tcount( o1.order_id ) = 1 \n" +
                "\t) o ON u.user_id = o.seller_id\n" +
                "\tLEFT JOIN items i ON o.item_id = i.item_id \n" +
                "ORDER BY\n" +
                "\tseller_id");
    }
}
