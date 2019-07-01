package com.github.leetcode.medium;

import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 17:28
 * @Description: Given an array of integers A with even length, return true if and only if it is possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,3,6]
 * Output: false
 * Example 2:
 * <p>
 * Input: [2,1,2,6]
 * Output: false
 * Example 3:
 * <p>
 * Input: [4,-2,2,-4]
 * Output: true
 * Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 * Example 4:
 * <p>
 * Input: [1,2,4,16,8,4]
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 30000
 * A.length is even
 * -100000 <= A[i] <= 100000
 */
public class Leetcode954 {
    public boolean canReorderDoubled(int[] A) {
        //按绝对值升序排列
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return Math.abs(a) - Math.abs(b);
        });
        for (int num : A) {
            pq.offer(num);
        }
        while (!pq.isEmpty()) {
            Integer num = pq.poll();
            if (!pq.remove(num * 2)) return false;
        }
        return true;
    }

    public boolean canReorderDouble(int[] A) {
        int n = 100000;
        int[] neg = new int[n + 1], pos = new int[n + 1];
        for (int a : A)
            if (a < 0) ++neg[-a];
            else ++pos[a];

        for (int i = 0; i <= n; ++i) {
            //正数倍还是负数倍
            for (int j = 0; j < 2; ++j) {

                int[] ints = j == 0 ? neg : pos;
                if (ints[i] == 0) continue;
                if (ints[2 * i] < ints[i]) return false;
                ints[2 * i] -= ints[i];
            }
        }

        return true;
    }
}
