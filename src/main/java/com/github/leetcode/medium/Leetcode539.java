package com.github.leetcode.medium;

import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 5/7/19 21:22
 * @Description: Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 */
public class Leetcode539 {
    public int findMinDifference(List<String> timePoints) {
        boolean[] minutes = new boolean[24 * 60];
        for (String source : timePoints) {
            int minuteFromDay = Integer.valueOf(source.substring(0, 2)) * 60 + Integer.valueOf(source.substring(3));
            if (minutes[minuteFromDay]) return 0;
            minutes[minuteFromDay] = true;
        }

        int firstFound = 0;
        for (; !minutes[firstFound]; firstFound++) ;
        int lastFound = firstFound;
        int min = Integer.MAX_VALUE;

        for (int i = firstFound + 1; i < 24 * 60; i++) {
            if (minutes[i]) {
                min = Math.min(min, i - lastFound);
                lastFound = i;
            }
        }

        return Math.min(min,24*60-(lastFound-firstFound));

    }
}
