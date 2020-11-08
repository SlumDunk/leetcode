package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 9/14/19 16:49
 * @Description: You have some sticks with positive integer lengths.
 * <p>
 * You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until there is one stick remaining.
 * <p>
 * Return the minimum cost of connecting all the given sticks into one stick in this way.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: sticks = [2,4,3]
 * Output: 14
 * Example 2:
 * <p>
 * Input: sticks = [1,8,3,5]
 * Output: 30
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= sticks.length <= 10^4
 * 1 <= sticks[i] <= 10^4
 */
public class Leetcode1167 {
    public static void main(String[] args) {
        Leetcode1167 leetcode1167 = new Leetcode1167();
        System.out.println(leetcode1167.connectSticks(new int[]{1, 8, 3, 5}));
    }

    /**
     * 2 3 4 (3) 5
     * 5 4 (2) 9
     * 9 (1)
     * <p>
     * 1 3 5 8 (4) 4
     * 4 5 8 (3) 9
     * 9 8 (2) 17
     * 17 (1)
     *
     * @param sticks
     * @return
     */
    public int connectSticks(int[] sticks) {
        //从小加到大
        Queue<Integer> pq = new PriorityQueue<Integer>();
        for (int stick : sticks) {
            pq.offer(stick);
        }
        int result = 0;
        while (pq.size() > 1) {
            Integer val1 = pq.poll();
            Integer val2 = pq.poll();
            result += val1 + val2;
            pq.offer(val1 + val2);
        }
        return result;
    }
}
