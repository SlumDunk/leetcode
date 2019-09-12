package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 9/11/19 09:01
 * @Description: The Tribonacci sequence Tn is defined as follows:
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * <p>
 * Given n, return the value of Tn.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * Example 2:
 * <p>
 * Input: n = 25
 * Output: 1389537
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
public class Leetcode1137 {
    static Map<Integer, Integer> memoryCache = new HashMap<Integer, Integer>();

    static {
        memoryCache.put(0, 0);
        memoryCache.put(1, 1);
        memoryCache.put(2, 1);
    }

    public int tribonacci(int n) {
        if (memoryCache.containsKey(n)) {
            return memoryCache.get(n);
        }
        int result = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        memoryCache.put(n, result);
        return result;
    }
}
