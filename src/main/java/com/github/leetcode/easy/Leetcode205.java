package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 12/18/18 14:25
 * @Description: Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 */
public class Leetcode205 {
    public boolean isIsomorphic(String s, String t) {
        //存储字符串s各个位置字符和t各个位置字符的对应关系
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {//该字符已经出现过
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {//在字符串s中第一次出现
                if (!map.containsValue(t.charAt(i))) {//t中i位置的字符和s中的字符还没有建立对应关系
                    map.put(s.charAt(i), t.charAt(i));
                } else {
                    return false;
                }
            }
        }
        return true;

    }
}
