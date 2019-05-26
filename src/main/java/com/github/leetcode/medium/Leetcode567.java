package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/13/19 13:38
 * @Description: Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * <p>
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * <p>
 * <p>
 * Note:
 * <p>
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class Leetcode567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return false;
        }
        if (s2 == null || s2.length() == 0) {
            return true;
        }

        if (s1.length() > s2.length()) {
            return false;
        }
        char[] sArr = s2.toCharArray();
        int[] count = new int[26];
        int len = s1.length();
        for (Character c :
                s1.toCharArray()) {
            count[c - 'a']++;
        }

        for (int l = 0, r = 0; r < sArr.length; r++) {
            count[sArr[r] - 'a']--;
            if (count[sArr[r] - 'a'] >= 0) {
                len--;
            }
            if (r >= s1.length()) {
                count[sArr[l] - 'a']++;
                if (count[sArr[l] - 'a'] > 0) {
                    len++;
                }
                l++;
            }
            if (len == 0) {
                return true;
            }
        }
        return false;
    }
}
