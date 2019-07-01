package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 21:14
 * @Description: Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * <p>
 * Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.
 * <p>
 * Note: p consists of only lowercase English letters and the size of p might be over 10000.
 * <p>
 * Example 1:
 * Input: "a"
 * Output: 1
 * <p>
 * Explanation: Only the substring "a" of string "a" is in the string s.
 * Example 2:
 * Input: "cac"
 * Output: 2
 * Explanation: There are two substrings "a", "c" of string "cac" in the string s.
 * Example 3:
 * Input: "zabc"
 * Output: 6
 * Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
 */
public class Leetcode467 {
    public int findSubstringInWraproundString(String p) {
        if (p.isEmpty()) {
            return 0;
        }

        char[] str = p.toCharArray();

        int[] len = new int[26];
        int cur = 1;
        len[str[0] - 'a'] = 1;
        for (int i = 1; i < str.length; ++i) {
            //和前面的字符保持连续
            if ((str[i] == 'a' && str[i - 1] == 'z') || str[i] == str[i - 1] + 1) {
                ++cur;
            } else {//不保持连续
                cur = 1;
            }
            //以当前字符结尾的最长子串长度
            len[str[i] - 'a'] = Math.max(len[str[i] - 'a'], cur);
        }

        int res = 0;
        for (int i = 0; i < 26; ++i) {
            res += len[i];
        }
        return res;
    }
}
