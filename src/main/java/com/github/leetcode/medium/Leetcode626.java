package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 09:41
 * @Description: Mary is a teacher in a middle school and she has a table seat storing students' names and their corresponding seat ids.
 * <p>
 * The column id is continuous increment.
 * <p>
 * <p>
 * Mary wants to change seats for the adjacent students.
 * <p>
 * <p>
 * Can you write a SQL query to output the result for Mary?
 * <p>
 * <p>
 * +---------+---------+
 * |    id   | student |
 * +---------+---------+
 * |    1    | Abbot   |
 * |    2    | Doris   |
 * |    3    | Emerson |
 * |    4    | Green   |
 * |    5    | Jeames  |
 * +---------+---------+
 * For the sample input, the output is:
 * <p>
 * <p>
 * +---------+---------+
 * |    id   | student |
 * +---------+---------+
 * |    1    | Doris   |
 * |    2    | Abbot   |
 * |    3    | Green   |
 * |    4    | Emerson |
 * |    5    | Jeames  |
 * +---------+---------+
 * Note:
 * If the number of students is odd, there is no need to change the last one's seat.
 */
public class Leetcode626 {
    public static void main(String[] args) {
        System.out.println("select\n" +
                "    (\n" +
                "        case\n" +
                "            when mod(id,2)!=0 and counts!=id then id+1\n" +
                "            when mod(id,2)!=0 and counts=id then id\n" +
                "            else id-1\n" +
                "        end\n" +
                "    ) as id,\n" +
                "    student\n" +
                "from\n" +
                "    seat,(select count(*) as counts from seat) as seat_counts order by id asc;");
    }
}
