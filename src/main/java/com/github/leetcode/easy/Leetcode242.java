package com.github.leetcode.easy;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 12/18/18 16:18
 * @Description: Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class Leetcode242 {
    public boolean isAnagram(String s, String t) {
        //s中的字符集合t中的字符集相同
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {//遍历字符串s，对应位置的字符数量+1
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {//遍历字符串t,对应位置的字符数量-1
            count[t.charAt(i) - 'a']--;
        }
        //判断最终数组是不是各个元素都是0
        return Arrays.equals(count, new int[26]);


    }

    /**
     * O(n)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram__(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];

        for (char item : s.toCharArray()) {
            count[item - 'a']++;
        }

        for (char item : t.toCharArray()) {
            count[item - 'a']--;
            if (count[item - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
