package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 4/22/21 21:51
 * @Description: You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [directioni, amounti]:
 * <p>
 * directioni can be 0 (for left shift) or 1 (for right shift).
 * amounti is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * Example 2:
 * <p>
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s only contains lower case English letters.
 * 1 <= shift.length <= 100
 * shift[i].length == 2
 * directioni is either 0 or 1.
 * 0 <= amounti <= 100
 */
public class Leetcode1427 {
    public String stringShift(String s, int[][] shift) {
        if (s.length() == 1) {
            return s;
        }

        int offset = 0;
        for (int[] step : shift) {
            offset += step[1] * (step[0] == 1 ? 1 : -1); // 右为正， 左为负
        }
        offset = offset % s.length();

        if (offset == 0) {
            return s;
        } else if (offset < 0) { //最终是向左移, 统一换成向右移动
            offset = s.length() - Math.abs(offset);
        }

        int length = s.length();
        return s.substring(length - offset, length).concat(s.substring(0, length - offset));
    }
}
