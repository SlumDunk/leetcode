package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 22:20
 * @Description: In a deck of cards, each card has an integer written on it.
 * <p>
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 * <p>
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 * Example 2:
 * <p>
 * Input: [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 * Example 3:
 * <p>
 * Input: [1]
 * Output: false
 * Explanation: No possible partition.
 * Example 4:
 * <p>
 * Input: [1,1]
 * Output: true
 * Explanation: Possible partition [1,1]
 * Example 5:
 * <p>
 * Input: [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2]
 * <p>
 * Note:
 * <p>
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 */
public class Leetcode914 {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) return false;
        int[] map = new int[10000];
        int maxDeck = Integer.MIN_VALUE;
        //计数，并计算最大的元素值
        for (int i = 0; i < deck.length; i++) {
            if (map[deck[i]] == 0) maxDeck = Math.max(maxDeck, deck[i]);
            map[deck[i]]++;
        }

        //计算出现次数最小的元素次数
        int minX = Integer.MAX_VALUE;
        for (int i = 0; i <= maxDeck; i++) {
            if (map[i] > 0) {
                if (map[i] < 2) return false;
                minX = Math.min(minX, map[i]);
            }
        }

        //求出能整除的数
        List<Integer> xList = new ArrayList<>();
        for (int x = 2; x <= minX; x++) {
            if (minX % x == 0) xList.add(x);
        }

        int index = 0;
        for (int k = 0; k <= maxDeck; k++) {
            if (map[k] > 0 && map[k] % xList.get(index) > 0) {
                //重新置位
                k = -1;
                ++index;
                if (index == xList.size()) return false;
            }
        }
        return true;
    }
}
