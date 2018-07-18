package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 * <p>
 * Each LED represents a zero or one, with the least significant bit on the right.
 * <p>
 * <p>
 * For example, the above binary watch reads "3:25".
 * <p>
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
 * <p>
 * Example:
 * <p>
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 */
public class Leetcode601 {
    public List<String> readBinaryWatch(int num) {
        List<String> resultList = new ArrayList<String>();
        int[] watch = new int[10];
        getTimes(num, 0, watch, resultList);
        return resultList;
    }

    private void getTimes(int num, int i, int[] watch, List<String> resultList) {
        if (num == 0) {
            StringBuffer time = new StringBuffer();
            int hour = getTime(3, 0, watch);
            time.append(hour);
            time.append(":");
            int minute = getTime(9, 4, watch);
            if (minute < 10) {
                time.append(0);
            }
            time.append(minute);
            resultList.add(time.toString());
            return;
        }
        for (; i <= 9; i++) {
            watch[i] = 1;
            if (!((watch[0] == 1 && watch[1] == 1) ||
                    (watch[4] == 1 && watch[5] == 1 && watch[6] == 1 && watch[7] == 1))) {
                getTimes(num - 1, i + 1, watch, resultList);
            }
            watch[i] = 0;
        }
        return;
    }

    private int getTime(int l, int h, int[] watch) {
        int sum = 0;
        int mi = 0;
        for (int i = l; i >= h; i--) {
            sum = (int) (sum + watch[i] * Math.pow(2, mi));
            mi++;
        }
        return sum;
    }
}
