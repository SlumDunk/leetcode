package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 06:45
 * @Description: Given a positive integer a, find the smallest positive integer b whose multiplication of each digit equals to a.
 * <p>
 * If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.
 * <p>
 * Example 1
 * Input:
 * <p>
 * 48
 * Output:
 * 68
 * Example 2
 * Input:
 * <p>
 * 15
 * Output:
 * 35
 */
public class Leetcode625 {
    private static final long INF = (long) Integer.MAX_VALUE + 1;

    private Map<Integer, Long> dp = new HashMap<>();

    /**
     * dfs+memory
     *
     * @param a
     * @return
     */
    private long smallestFact(int a) {
        if (a >= 0 && a <= 9) {
            return a;
        }

        if (dp.containsKey(a)) {
            return dp.get(a);
        }

        long res = INF;
        for (int i = 2; i <= 9; ++i) {
            if (a % i == 0) {
                res = Math.min(res, smallestFact(a / i) * 10 + i);
            }
        }
        dp.put(a, res);
        return res;
    }

    public int smallestFactorization(int a) {
        long res = smallestFact(a);
        if (res > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) res;
    }
}
