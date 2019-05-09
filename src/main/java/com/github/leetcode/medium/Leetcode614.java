package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 09:45
 * @Description: In facebook, there is a follow table with two columns: followee, follower.
 * <p>
 * Please write a sql query to get the amount of each follower’s follower if he/she has one.
 * <p>
 * For example:
 * <p>
 * +-------------+------------+
 * | followee    | follower   |
 * +-------------+------------+
 * |     A       |     B      |
 * |     B       |     C      |
 * |     B       |     D      |
 * |     D       |     E      |
 * +-------------+------------+
 * should output:
 * +-------------+------------+
 * | follower    | num        |
 * +-------------+------------+
 * |     B       |  2         |
 * |     D       |  1         |
 * +-------------+------------+
 * Explaination:
 * Both B and D exist in the follower list, when as a followee, B's follower is C and D, and D's follower is E. A does not exist in follower list.
 * <p>
 * <p>
 * <p>
 * <p>
 * Note:
 * Followee would not follow himself/herself in all cases.
 * Please display the result in follower's alphabet order.
 */
public class Leetcode614 {
    public static void main(String[] args) {
        System.out.println("select f1.follower, count(distinct f2.follower) as num\n" +
                "from follow f1\n" +
                "join follow f2 on f1.follower=f2.followee\n" +
                "group by f1.follower\n" +
                "order by f1.follower;");
    }
}
