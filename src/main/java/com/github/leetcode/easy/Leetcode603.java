package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 18:49
 * @Description: Several friends at a cinema ticket office would like to reserve consecutive available seats.
 * Can you help to query all the consecutive available seats order by the seat_id using the following cinema table?
 * | seat_id | free |
 * |---------|------|
 * | 1       | 1    |
 * | 2       | 0    |
 * | 3       | 1    |
 * | 4       | 1    |
 * | 5       | 1    |
 * <p>
 * <p>
 * Your query should return the following result for the sample case above.
 * <p>
 * <p>
 * | seat_id |
 * |---------|
 * | 3       |
 * | 4       |
 * | 5       |
 * Note:
 * The seat_id is an auto increment int, and free is bool ('1' means free, and '0' means occupied.).
 * Consecutive available seats are more than 2(inclusive) seats consecutively available.
 */
public class Leetcode603 {
    public static void main(String[] args) {
        System.out.println("select distinct a.seat_id\n" +
                "from cinema a join cinema b\n" +
                "on abs(a.seat_id-b.seat_id)=1\n" +
                "and a.free=true and b.free=true order by a.seat_id;");
    }
}
