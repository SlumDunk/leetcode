package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 22:59
 * @Description: Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.
 * <p>
 * All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aabbcc", k = 3
 * Output: "abcabc"
 * Explanation: The same letters are at least distance 3 from each other.
 * Example 2:
 * <p>
 * Input: s = "aaabc", k = 3
 * Output: ""
 * Explanation: It is not possible to rearrange the string.
 * Example 3:
 * <p>
 * Input: s = "aaadbbcc", k = 2
 * Output: "abacabcd"
 * Explanation: The same letters are at least distance 2 from each other.
 */
public class Leetcode358 {
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] count = new int[26];
        int[] valid = new int[26];
        for (char c :
                s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int nextLetter = findNext(count, valid, i);
            if (nextLetter == -1) {
                return "";
            }
            res.append((char) ('a' + nextLetter));
            valid[nextLetter] = i + k;
            count[nextLetter]--;
        }
        return res.toString();
    }

    /**
     * 获取要插入的下一个字符
     * 优先找出现次数大的
     *
     * @param count
     * @param valid
     * @param index
     * @return
     */
    private int findNext(int[] count, int[] valid, int index) {
        int max = 0, res = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max && valid[i] <= index) {
                res = i;
                max = count[i];
            }
        }
        return res;
    }
}
