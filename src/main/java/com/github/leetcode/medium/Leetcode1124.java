package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 7/24/19 13:25
 * @Description: We are given hours, a list of the number of hours worked per day for a given employee.
 * <p>
 * A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
 * <p>
 * A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.
 * <p>
 * Return the length of the longest well-performing interval.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: hours = [9,9,6,0,6,6,9]
 * Output: 3
 * Explanation: The longest well-performing interval is [9,9,6].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= hours.length <= 10000
 * 0 <= hours[i] <= 16
 */
public class Leetcode1124 {
    public static void main(String[] args) {
        Leetcode1124 leetcode1124 = new Leetcode1124();
        int[] hours = new int[]{9, 9, 6, 0, 6, 6, 9};
        leetcode1124.longestWPI(hours);
    }

    public int longestWPI(int[] hours) {
        int res = 0, score = 0, n = hours.length;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            //>8 加1, <=8, -1
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0) {
                res = i + 1;
            } else {
                //存储0 分出现的位置
                seen.putIfAbsent(score, i);
                if (seen.containsKey(score - 1))//中间部分满足条件
                    res = Math.max(res, i - seen.get(score - 1));
            }
        }
        return res;
    }
}
