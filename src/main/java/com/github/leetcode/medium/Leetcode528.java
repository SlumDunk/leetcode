package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
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
        int total = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Random random = new Random();

        public Solution(int[] w) {
            for (int idx = 0; idx < w.length; idx++) {
                total += w[idx];
                map.put(total, idx);
            }
        }

        public int pickIndex() {
            int key = map.higherKey(random.nextInt(total));
            return map.get(key);
        }

    }

    class Solution_ {
        List<Integer> psum = new ArrayList<>();
        int tot = 0;
        Random rand = new Random();

        public Solution_(int[] w) {
            for (int x : w) {
                tot += x;
                psum.add(tot);
            }
        }

        public int pickIndex() {
            int targ = rand.nextInt(tot);

            int lo = 0;
            int hi = psum.size() - 1;
            while (lo < hi) {//low==hi
                int mid = lo + (hi - lo) / 2;
                if (targ >= psum.get(mid)) lo = mid + 1;
                else hi = mid;
            }

            return lo;
        }
    }

}
