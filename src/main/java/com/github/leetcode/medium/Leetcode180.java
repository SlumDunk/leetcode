package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 11:09
 * @Description: Write a SQL query to find all numbers that appear at least three times consecutively.
 * <p>
 * +----+-----+
 * | Id | Num |
 * +----+-----+
 * | 1  |  1  |
 * | 2  |  1  |
 * | 3  |  1  |
 * | 4  |  2  |
 * | 5  |  1  |
 * | 6  |  2  |
 * | 7  |  2  |
 * +----+-----+
 * For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.
 * <p>
 * +-----------------+
 * | ConsecutiveNums |
 * +-----------------+
 * | 1               |
 * +-----------------+
 */
public class Leetcode180 {
    public static void main(String[] args) {
        System.out.println("select distinct l1.Num ConsecutiveNums from Logs l1\n" +
                "left join Logs l2 on l1.Id = l2.Id - 1\n" +
                "left join Logs l3 on l1.Id = l3.Id - 2\n" +
                "where l1.Num = l2.Num and l2.Num = l3.Num;");
    }
}
