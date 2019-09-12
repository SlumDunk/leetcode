package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 9/11/19 11:22
 * @Description:
 */
public class Leetcode1154 {
    static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    static {
        map.put(1, 31);
        map.put(2, 28);
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

    public int dayOfYear(String date) {
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7));
        int day = Integer.valueOf(date.substring(8, 10));

        //assert leap year
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            map.put(2, 29);
        } else {
            map.put(2, 28);
        }

        int result = 0;
        for (int i = 1; i < month; i++) {
            result += map.get(i);
        }
        result += day;
        return result;
    }
}
