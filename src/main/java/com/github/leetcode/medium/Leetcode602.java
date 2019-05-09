package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 10:26
 * @Description: In social network like Facebook or Twitter, people send friend requests and accept others' requests as well.
 * <p>
 * <p>
 * Table request_accepted holds the data of friend acceptance, while requester_id and accepter_id both are the id of a person.
 * <p>
 * <p>
 * | requester_id | accepter_id | accept_date|
 * |--------------|-------------|------------|
 * | 1            | 2           | 2016_06-03 |
 * | 1            | 3           | 2016-06-08 |
 * | 2            | 3           | 2016-06-08 |
 * | 3            | 4           | 2016-06-09 |
 * Write a query to find the the people who has most friends and the most friends number. For the sample data above, the result is:
 * | id | num |
 * |----|-----|
 * | 3  | 3   |
 * Note:
 * It is guaranteed there is only 1 people having the most friends.
 * The friend request could only been accepted once, which mean there is no multiple records with the same requester_id and accepter_id value.
 * <p>
 * <p>
 * Explanation:
 * The person with id '3' is a friend of people '1', '2' and '4', so he has 3 friends in total, which is the most number than any others.
 * <p>
 * <p>
 * Follow-up:
 * In the real world, multiple people could have the same most number of friends, can you find all these people in this case?
 */
public class Leetcode602 {
    public static void main(String[] args) {
        System.out.println("select ids as id, cnt as num\n" +
                "from\n" +
                "(\n" +
                "    select ids, count(*) as cnt\n" +
                "        from\n" +
                "        (\n" +
                "            select requester_id as ids from request_accepted\n" +
                "            union all\n" +
                "            select accepter_id from request_accepted\n" +
                "        ) as tbl1\n" +
                "        group by ids    \n" +
                ") as tbl2\n" +
                "\n" +
                "order by cnt desc\n" +
                "limit 1;");
    }
}
