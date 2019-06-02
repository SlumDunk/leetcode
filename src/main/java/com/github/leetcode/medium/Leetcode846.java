package com.github.leetcode.medium;

import java.util.TreeMap;

/**
 * @Author: zerongliu
 * @Date: 5/26/19 22:17
 * @Description: Alice has a hand of cards, given as an array of integers.
 * <p>
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 * <p>
 * Return true if and only if she can.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 * Example 2:
 * <p>
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 */
public class Leetcode846 {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length < W) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i :
                hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int len = hand.length;
        while (len > 0 && map.size() > 0) {
            int start = map.firstKey();
            int out = W;
            while (out > 0 && map.containsKey(start)) {
                map.put(start, map.get(start) - 1);
                if (map.get(start) == 0) {
                    map.remove(start);
                }
                start++;
                out--;
            }
            if (out != 0) return false;
            len -= W;
        }
        return len == 0;
    }
}
