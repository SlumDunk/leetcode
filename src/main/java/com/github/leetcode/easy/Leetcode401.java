package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 12/28/18 12:19
 * @Description: A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
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
public class Leetcode401 {

    /**
     * LED灯所在位置和数值的映射关系 包含时 和 分
     */
    private final int[] TIME_BIT_VALUES = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int num) {
        //10个灯，占用了哪些灯，还有哪些可以被占用，从高位到低位
        List<String> result = new ArrayList<>();
        backTrack(result, new int[10], num, 0, 0);
        return result;
    }

    /**
     * @param result       结果集
     * @param bits         1的位置数组
     * @param targetCount  1的目标个数
     * @param currentCount 当前1的个数
     * @param start        开始位置
     */
    private void backTrack(List<String> result, int[] bits, int targetCount, int currentCount, int start) {
        if (currentCount == targetCount) {
            String time = generateTime(bits);
            if (!"".equals(time)) {
                result.add(time);
            }
        }

        for (int i = start; i < bits.length; i++) {
            if (bits[i] == 0 && currentCount + 1 <= targetCount) {
                bits[i] = 1;
                //高位走到低位
                backTrack(result, bits, targetCount, currentCount + 1, i + 1);
                bits[i] = 0;
            }
        }
    }

    /**
     * 计算出时间
     *
     * @param bits
     * @return
     */
    private String generateTime(int[] bits) {
        //计算出小时
        int hour = 0;
        for (int i = 0; i < 4; i++) {
            hour += bits[i] * TIME_BIT_VALUES[i];
        }
        if (hour > 11) {
            return "";
        }
        //计算出分钟
        int min = 0;
        for (int i = 4; i < 10; i++) {
            min += bits[i] * TIME_BIT_VALUES[i];
        }
        if (min > 59) {
            return "";
        }
        return connactTimeString(min, hour);

    }

    /**
     * 拼接小时和分钟字符串
     *
     * @param min
     * @param hour
     * @return
     */
    private String connactTimeString(int min, int hour) {
        StringBuilder timeBuilder = new StringBuilder();
        timeBuilder.append(hour);
        timeBuilder.append(":");
        if (min < 10) {
            timeBuilder.append(0);
        }

        timeBuilder.append(min);
        return timeBuilder.toString();
    }
}
