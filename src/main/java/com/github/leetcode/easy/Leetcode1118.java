package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 7/21/19 10:26
 * @Description: Given a year Y and a month M, return how many days there are in that month.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: Y = 1992, M = 7
 * Output: 31
 * Example 2:
 * <p>
 * Input: Y = 2000, M = 2
 * Output: 29
 * Example 3:
 * <p>
 * Input: Y = 1900, M = 2
 * Output: 28
 * <p>
 * <p>
 * Note:
 * <p>
 * 1583 <= Y <= 2100
 * 1 <= M <= 12
 * Accepted
 * 1,719
 * Submissions
 * 2,987
 */
public class Leetcode1118 {
    Map<Integer, Integer> map = new HashMap<>();

    //初始化map
    {
        map.put(1, 31);
        map.put(21, 28);
        map.put(22, 29);
        map.put(3, 31);
        map.put(4, 30);
        map.put(5, 31);
        map.put(6, 30);
        map.put(7, 31);
        map.put(8, 31);
        map.put(9, 30);
        map.put(10, 31);
        map.put(11, 30);
        map.put(12, 31);

    }

    public int numberOfDays(int Y, int M) {
        if (M == 2) {
            if (Y % 4 == 0 && Y % 100 != 0 || Y % 400 == 0) {
                return map.get(22);
            } else {
                return map.get(21);
            }
        } else {
            return map.get(M);
        }
    }
}
