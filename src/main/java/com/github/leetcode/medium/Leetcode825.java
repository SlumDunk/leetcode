package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 07:48
 * @Description: Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person.
 * <p>
 * Person A will NOT friend request person B (B != A) if any of the following conditions are true:
 * <p>
 * age[B] <= 0.5 * age[A] + 7
 * age[B] > age[A]
 * age[B] > 100 && age[A] < 100
 * Otherwise, A will friend request B.
 * <p>
 * Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.
 * <p>
 * How many total friend requests are made?
 * <p>
 * Example 1:
 * <p>
 * Input: [16,16]
 * Output: 2
 * Explanation: 2 people friend request each other.
 * Example 2:
 * <p>
 * Input: [16,17,18]
 * Output: 2
 * Explanation: Friend requests are made 17 -> 16, 18 -> 17.
 * Example 3:
 * <p>
 * Input: [20,30,100,110,120]
 * Output:
 * Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
 * <p>
 * <p>
 * Notes:
 * <p>
 * 1 <= ages.length <= 20000.
 * 1 <= ages[i] <= 120.
 */
public class Leetcode825 {
    public int numFriendRequests(int[] ages) {
        int[] map = new int[121];

        for (int age : ages) {
            map[age]++;
        }

        for (int i = 1; i < map.length; i++) {
            map[i] += map[i - 1];
        }

        int fr = 0;
        for (int age : ages) {
            fr += Math.max(0, map[age] - map[(age / 2) + 7] - 1);
        }

        return fr;
    }

}
