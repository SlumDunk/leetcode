package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/15/19 13:45
 * @Description: Given two strings S and T, determine if they are both one edit distance apart.
 * <p>
 * Example
 * Given s = "aDb", t = "adb"
 * return true
 */
public class Lintcode640 {
    /**
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // write your code here
        if (s == null || t == null) {
            return s == t;
        }
        if (s.equals(t)) {
            return false;
        }
        int m = s.length();
        int n = t.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        int len = Math.min(m, n);
        for (int i = 0; i < len; i++) {
            int index = i + 1;
            if (s.charAt(i) != t.charAt(i)) {
                //replace, delete,insert
                return s.substring(index).equals(t.substring(index)) || s.substring(index + 1).equals(t.substring(index)) || s.substring(index).equals(t.substring(index + 1));
            }
        }
        //只有最后一位不等
        return true;
    }
}
