package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 5/8/19 12:36
 * @Description: A password is considered strong if below conditions are all met:
 * <p>
 * It has at least 6 characters and at most 20 characters.
 * It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
 * It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
 * Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.
 * <p>
 * Insertion, deletion or replace of any one character are all considered as one change.
 */
public class Leetcode420 {
    public static void main(String[] args) {
        Leetcode420 leetcode420=new Leetcode420();
        leetcode420.strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaaaaaaaa");

    }
    public int strongPasswordChecker(String s) {
        if (s == null || s.length() == 0) {
            return 6;
        }
        char[] str = s.toCharArray();
        boolean isUpper = false, isLower = false, isDigit = false;
        int missType = 3;
        for (char c :
                str) {
            if (!isUpper && Character.isUpperCase(c)) {
                isUpper = true;
                missType -= 1;
            }
            if (!isLower && Character.isLowerCase(c)) {
                isLower = true;
                missType -= 1;
            }

            if (!isDigit && Character.isDigit(c)) {
                isDigit = true;
                missType -= 1;
            }
        }
        int totalChangeCnt = 0, OneChangeCnt = 0, TwoChangeCnt = 0, pos = 2;
        while (pos < s.length()) {
            if (str[pos] == str[pos - 1] && str[pos - 1] == str[pos - 2]) {
                int length = 2;
                while (pos < s.length() && str[pos] == str[pos - 1]) {
                    length += 1;
                    pos += 1;
                }
                totalChangeCnt += length / 3;
                if (length % 3 == 0) OneChangeCnt += 1;
                else if (length % 3 == 1) TwoChangeCnt += 1;
            } else {
                pos = pos + 1;
            }
        }
        if (s.length() < 6) {
            return Math.max(missType, 6 - s.length());
        } else if (s.length() <= 20) {
            return Math.max(missType, totalChangeCnt);
        } else {
            int deleteCount = s.length() - 20;
            totalChangeCnt -= Math.min(deleteCount, OneChangeCnt * 1) / 1;
            totalChangeCnt -= Math.min(Math.max(deleteCount - OneChangeCnt, 0), TwoChangeCnt * 2) / 2;
            totalChangeCnt -= Math.max(deleteCount - OneChangeCnt - 2 * TwoChangeCnt, 0) / 3;

            return deleteCount + Math.max(missType, totalChangeCnt);
        }
    }
}
