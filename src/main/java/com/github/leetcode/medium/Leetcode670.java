package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/27/19 23:01
 * @Description: Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
 * <p>
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * Note:
 * The given number is in the range [0, 108]
 */
public class Leetcode670 {
    public int maximumSwap(int num) {
        if (num < 0) return 0;
        StringBuilder buffer = new StringBuilder(Integer.toString(num));
        int len = buffer.length();
        int[] maxArr = new int[len];
        int maxIndex = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (buffer.charAt(i) > buffer.charAt(maxIndex)) {
                maxIndex = i;
            }
            maxArr[i] = maxIndex;
        }

        for (int i = 0; i < len; i++) {
            if (buffer.charAt(i) < buffer.charAt(maxArr[i])) {
                char c = buffer.charAt(maxArr[i]);
                buffer.setCharAt(maxArr[i], buffer.charAt(i));
                buffer.setCharAt(i, c);
                break;
            }
        }

        return Integer.parseInt(buffer.toString());
    }
}
