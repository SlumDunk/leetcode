package com.github.leetcode.easy;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 15:37
 * @Description: Given an array of 4 digits, return the largest 24 hour time that can be made.
 * <p>
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 * <p>
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4]
 * Output: "23:41"
 * Example 2:
 * <p>
 * Input: [5,5,5,5]
 * Output: ""
 * <p>
 * <p>
 * Note:
 * <p>
 * A.length == 4
 * 0 <= A[i] <= 9
 */
public class Leetcode949 {

    /**
     * 4个数字全排列总共有24种可能，判断每一种可能是否能组成合法时间值，如果能，再和当前保存的最大值进行比较；
     * 最大值是一个int值，用来表示分钟数；
     *
     * @param array
     * @return
     */
    public String largestTimeFromDigits(int[] array) {
        int largestTime = -1;

        // 暴力枚举出每种可能
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j != i) {
                    for (int k = 0; k < 4; k++) {
                        if (k != i && k != j) {
                            // 0,1,2,3 总和为6，故剩下的index为6-
                            int l = 6 - i - j - k;

                            int result = largestTimeHelper(array[i], array[j], array[k], array[l]);

                            largestTime = Math.max(result, largestTime);
                        }
                    }
                }
            }
        }
        if (largestTime == -1) {
            return "";
        }
        return String.format("%02d:%02d", largestTime / 60, largestTime % 60);
    }

    /**
     * 判断输入的四个数字按照输入顺序组成的时间是否合法，如果合法，返回分钟数；
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public int largestTimeHelper(int a, int b, int c, int d) {
        int hours = a * 10 + b;
        int min = c * 10 + d;

        if (hours < 24 && min < 60) {
            // 返回分钟数
            return hours * 60 + min;
        }
        return -1;
    }

}
