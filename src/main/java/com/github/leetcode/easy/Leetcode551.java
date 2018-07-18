package com.github.leetcode.easy;

/**
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * <p>
 * You need to return whether the student could be rewarded according to his attendance record.
 * <p>
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class Leetcode551 {
    public boolean checkRecord(String s) {
        int countA = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('A' == s.charAt(i)) {
                countA++;
            }
            if ('L' == s.charAt(i)) {
                if (i <= s.length() - 3 && 'L' == s.charAt(i + 1) && 'L' == s.charAt(i + 2)) {
                    return Boolean.FALSE;
                }
            }
        }
        if (countA > 1) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }
}
