package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 09:56
 * @Description: In social network like Facebook or Twitter, people send friend requests and accept others’ requests as well. Now given two tables as below:
 * <p>
 * <p>
 * Table: friend_request
 * | sender_id | send_to_id |request_date|
 * |-----------|------------|------------|
 * | 1         | 2          | 2016_06-01 |
 * | 1         | 3          | 2016_06-01 |
 * | 1         | 4          | 2016_06-01 |
 * | 2         | 3          | 2016_06-02 |
 * | 3         | 4          | 2016-06-09 |
 * <p>
 * <p>
 * Table: request_accepted
 * | requester_id | accepter_id |accept_date |
 * |--------------|-------------|------------|
 * | 1            | 2           | 2016_06-03 |
 * | 1            | 3           | 2016-06-08 |
 * | 2            | 3           | 2016-06-08 |
 * | 3            | 4           | 2016-06-09 |
 * | 3            | 4           | 2016-06-10 |
 * <p>
 * <p>
 * Write a query to find the overall acceptance rate of requests rounded to 2 decimals, which is the number of acceptance divide the number of requests.
 * <p>
 * <p>
 * For the sample data above, your query should return the following result.
 * <p>
 * <p>
 * |accept_rate|
 * |-----------|
 * |       0.80|
 * <p>
 * <p>
 * Note:
 * The accepted requests are not necessarily from the table friend_request. In this case, you just need to simply count the total accepted requests (no matter whether they are in the original requests), and divide it by the number of requests to get the acceptance rate.
 * It is possible that a sender sends multiple requests to the same receiver, and a request could be accepted more than once. In this case, the ‘duplicated’ requests or acceptances are only counted once.
 * If there is no requests at all, you should return 0.00 as the accept_rate.
 * <p>
 * <p>
 * Explanation: There are 4 unique accepted requests, and there are 5 requests in total. So the rate is 0.80.
 * <p>
 * <p>
 * Follow-up:
 * Can you write a query to return the accept rate but for every month?
 * How about the cumulative accept rate for every day?
 */
public class Leetcode597 {
    public static void main(String[] args) {
        System.out.println("select \n" +
                "round(ifnull((select count(*) from (select distinct requester_id,accepter_id from request_accepted) as A)/(select count(*) from (select distinct sender_id,send_to_id from friend_request) as B),0),2) as accept_rate;");
    }
}
