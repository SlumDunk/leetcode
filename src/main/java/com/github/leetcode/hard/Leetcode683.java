package com.github.leetcode.hard;

import java.util.TreeSet;

/**
 * @Author: zerongliu
 * @Date: 5/30/19 10:48
 * @Description: You have N bulbs in a row numbered from 1 to N. Initially, all the bulbs are turned off. We turn on exactly one bulb everyday until all bulbs are on after N days.
 * <p>
 * You are given an array bulbs of length N where bulbs[i] = x means that on the (i+1)th day, we will turn on the bulb at position x where i is 0-indexed and x is 1-indexed.
 * <p>
 * Given an integer K, find out the minimum day number such that there exists two turned on bulbs that have exactly K bulbs between them that are all turned off.
 * <p>
 * If there isn't such day, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * bulbs: [1,3,2]
 * K: 1
 * Output: 2
 * Explanation:
 * On the first day: bulbs[0] = 1, first bulb is turned on: [1,0,0]
 * On the second day: bulbs[1] = 3, third bulb is turned on: [1,0,1]
 * On the third day: bulbs[2] = 2, second bulb is turned on: [1,1,1]
 * We return 2 because on the second day, there were two on bulbs with one off bulb between them.
 * Example 2:
 * <p>
 * Input:
 * bulbs: [1,2,3]
 * K: 1
 * Output: -1
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 20000
 * 1 <= bulbs[i] <= N
 * bulbs is a permutation of numbers from 1 to N.
 * 0 <= K <= 20000
 */
public class Leetcode683 {
    public int kEmptySlots(int[] bulbs, int K) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < bulbs.length; i++) {
            int cur = bulbs[i];
            if (ts.higher(cur) != null && ts.higher(cur) - cur == K + 1) return i + 1;
            if (ts.lower(cur) != null && cur - ts.lower(cur) == K + 1) return i + 1;
            ts.add(cur);
        }
        return -1;
    }
}
