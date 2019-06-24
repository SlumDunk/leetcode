package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/3/19 16:02
 * @Description: Given two positive integers x and y, an integer is powerful if it is equal to x^i + y^j for some integers i >= 0 and j >= 0.
 * <p>
 * Return a list of all powerful integers that have value less than or equal to bound.
 * <p>
 * You may return the answer in any order.  In your answer, each value should occur at most once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 2, y = 3, bound = 10
 * Output: [2,3,4,5,7,9,10]
 * Explanation:
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 * Example 2:
 * <p>
 * Input: x = 3, y = 5, bound = 15
 * Output: [2,4,6,8,10,14]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= x <= 100
 * 1 <= y <= 100
 * 0 <= bound <= 10^6
 */
public class Leetcode970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> res = new ArrayList<>();
        int sq = (int) Math.sqrt(bound);
        int i = 0, j = 0;
        int xBound = sq;
        int yBound = sq;
        if (x == 1) {
            xBound = 0;
        }
        if (y == 1) {
            yBound = 0;
        }
        while (i <= xBound && Math.pow(x, i) <= bound) {
            int tempBound = (int) Math.pow(x, i) + (int) Math.pow(y, j);
            if (tempBound <= bound && j <= yBound) {
                if (!res.contains(tempBound)) {
                    res.add(tempBound);
                }
                j++;
            } else {
                i++;
                j = 0;
            }
        }
        return res;
    }
}
