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
        //连续L的个数
        int countL = 0;
        int countP = 0;
        for (char value : s.toCharArray()) {
            if (value == 'A' && countP == 1) {//两个A
                return false;
            } else if (value == 'A') {
                countP++;
                countL = 0;//同样得复位
            } else {
                if (value == 'L' && countL == 2) {//3个L
                    return false;
                } else if (value == 'L') {
                    countL++;
                } else {
                    countL = 0;
                }
            }
        }
        return true;
    }
}
