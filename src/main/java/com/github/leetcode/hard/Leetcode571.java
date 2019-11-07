package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 19:29
 * @Description: The Numbers table keeps the value of number and its freq.
 * <p>
 * +----------+-------------+
 * |  Number  |  Frequency  |
 * +----------+-------------|
 * |  0       |  7          |
 * |  1       |  1          |
 * |  2       |  3          |
 * |  3       |  1          |
 * +----------+-------------+
 * In this table, the numbers are 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 3, so the median is (0 + 0) / 2 = 0.
 * <p>
 * +--------+
 * | median |
 * +--------|
 * | 0.0000 |
 * +--------+
 * Write a query to find the median of all numbers and name the result as median.
 */
public class Leetcode571 {
    public static void main(String[] args) {
        System.out.println("select\n" +
                "    avg(median) as 'median' \n" +
                "from \n" +
                "(\n" +
                "    select a.Number as median, a.Frequency\n" +
                "    From \n" +
                "    Numbers a, Numbers b\n" +
                "    Group by a.Number\n" +
                "    Having\n" +
                "    a.Frequency >=\n" +
                "    abs(\n" +
                "        Sum(\n" +
                "        case \n" +
                "        when a.Number-b.Number > 0 then 1 * b.Frequency\n" +
                "        when a.Number=b.Number then 0\n" +
                "        else -1 * b.Frequency \n" +
                "        end\n" +
                "        )\n" +
                "       )\n" +
                ") x");
    }
}
