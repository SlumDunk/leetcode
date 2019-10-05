package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/3/19 22:26
 * @Description: Given two strings s and t, determine if they are both one edit distance apart.
 * <p>
 * Note:
 * <p>
 * There are 3 possiblities to satisify one edit distance apart:
 * <p>
 * Insert a character into s to get t
 * Delete a character from s to get t
 * Replace a character of s to get t
 * Example 1:
 * <p>
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 * Example 2:
 * <p>
 * Input: s = "cab", t = "ad"
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 * Example 3:
 * <p>
 * Input: s = "1203", t = "1213"
 * Output: true
 * Explanation: We can replace '0' with '1' to get t.
 */
public class Leetcode161 {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (s.length() > t.length()) {
                    return s.substring(i + 1).equals(t.substring(i));
                } else {
                    return t.substring(i + 1).equals(s.substring(i));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }

    public boolean isOneEditDistance__(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (s.equals(t)) {
            return false;
        }
        if (Math.abs(m - n) > 1) {
            return false;
        } else {
            char[] array1 = s.toCharArray();
            char[] array2 = t.toCharArray();

            int l = Math.min(m, n);
            for (int i = 0; i < l; i++) {
                if (array1[i] == array2[i]) {
                    continue;
                } else {
                    boolean result = false;
                    //增加
                    if (i + 1 < n) {
                        result |= s.substring(i).equals(t.substring(i + 1));
                    }
                    if (i + 1 < m) {// 删除
                        result |= s.substring(i + 1).equals(t.substring(i));
                    }
                    if (i + 1 <= m && i + 1 <= n) {//替换 需要考虑最后一位
                        result |= s.substring(i + 1).equals(t.substring(i + 1));
                    }
                    return result;
                }
            }
            //前面都相同
            return Math.abs(m - n) == 1;
        }
    }

    public static void main(String[] args) {
        Leetcode161 leetcode161 = new Leetcode161();
        System.out.println(leetcode161.isOneEditDistance__("a", "A"));
    }
}
