package com.github.interview.ibm;

/**
 * @Author: zerongliu
 * @Date: 11/3/20 18:39
 * @Description:
 */
public class ShiftingStrings {
    public static void main(String[] args) {
        System.out.println(getShiftedString("abcdefg", 2, 4));

    }

    /**
     * abcdefg
     * 2
     * cdefgab
     * <p>
     * 4
     * fgabcde
     *
     * @param s
     * @param leftShifts
     * @param rightShifts
     * @return
     */
    public static String getShiftedString(String s, int leftShifts, int rightShifts) {
        int n = s.length();
        if (leftShifts > 0) {
            leftShifts = leftShifts % n;
            char[] buffer = new char[n];
            for (int i = 0; i < n; i++) {
                if (i >= leftShifts) {
                    buffer[i - leftShifts] = s.charAt(i);
                } else {
                    buffer[i - leftShifts + n] = s.charAt(i);
                }
            }
            s = new String(buffer);
        }
        if (rightShifts > 0) {
            rightShifts = rightShifts % n;
            char[] buffer = new char[n];
            for (int i = 0; i < n; i++) {
                if (i + rightShifts >= n) {
                    buffer[(i + rightShifts) % n] = s.charAt(i);
                } else {
                    buffer[i + rightShifts] = s.charAt(i);
                }
            }
            s = new String(buffer);
        }
        return s;
    }
}
