package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 19:07
 * @Description: Given a table customer holding customers information and the referee.
 * <p>
 * +------+------+-----------+
 * | id   | name | referee_id|
 * +------+------+-----------+
 * |    1 | Will |      NULL |
 * |    2 | Jane |      NULL |
 * |    3 | Alex |         2 |
 * |    4 | Bill |      NULL |
 * |    5 | Zack |         1 |
 * |    6 | Mark |         2 |
 * +------+------+-----------+
 * Write a query to return the list of customers NOT referred by the person with id '2'.
 * <p>
 * For the sample data above, the result is:
 * <p>
 * +------+
 * | name |
 * +------+
 * | Will |
 * | Jane |
 * | Bill |
 * | Zack |
 * +------+
 */
public class Leetcode584 {
    public static void main(String[] args) {
        System.out.println("select name from customer where referee_Id <> 2 or referee_Id is null;");
    }
}
