package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 10:56
 * @Description: Table my_numbers contains many numbers in column num including duplicated ones.
 * Can you write a SQL query to find the biggest number, which only appears once.
 * <p>
 * +---+
 * |num|
 * +---+
 * | 8 |
 * | 8 |
 * | 3 |
 * | 3 |
 * | 1 |
 * | 4 |
 * | 5 |
 * | 6 |
 * For the sample data above, your query should return the following result:
 * +---+
 * |num|
 * +---+
 * | 6 |
 * Note:
 * If there is no such number, just output null.
 */
public class Leetcode619 {
    public static void main(String[] args) {
        System.out.println("select max(num) as num\n" +
                "from \n" +
                "    (\n" +
                "        select num from my_numbers\n" +
                "        group by num\n" +
                "        having count(num)=1\n" +
                "    ) as t;");
    }
}
