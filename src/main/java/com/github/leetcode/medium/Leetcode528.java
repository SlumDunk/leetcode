package com.github.leetcode.medium;

import java.util.Random;
import java.util.TreeMap;

/**
 * @Author: zerongliu
 * @Date: 3/17/19 17:23
 * @Description: Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.
 * <p>
 * Note:
 * <p>
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * Example 1:
 * <p>
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * Example 2:
 * <p>
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 * Explanation of Input Syntax:
 * <p>
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class Leetcode528 {
    class Solution {
        int cnt = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Random random = new Random();

        public Solution(int[] w) {
            for (int idx = 0; idx < w.length; idx++) {
                cnt += w[idx];
                map.put(cnt, idx);
            }
        }

        public int pickIndex() {
            int key = map.higherKey(random.nextInt(cnt));
            return map.get(key);
        }

    }
}
