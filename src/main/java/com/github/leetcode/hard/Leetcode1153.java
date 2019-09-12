package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 9/12/19 12:50
 * @Description: Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero or more conversions.
 * <p>
 * In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.
 * <p>
 * Return true if and only if you can transform str1 into str2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: str1 = "aabcc", str2 = "ccdee"
 * Output: true
 * Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.
 * Example 2:
 * <p>
 * Input: str1 = "leetcode", str2 = "codeleet"
 * Output: false
 * Explanation: There is no way to transform str1 to str2.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= str1.length == str2.length <= 10^4
 * Both str1 and str2 contain only lowercase English letters.
 */
public class Leetcode1153 {

    public static void main(String[] args) {
        Leetcode1153 leetcode1153 = new Leetcode1153();

        String s1 = "abcdefghijklmnopqrstuvwxyz";
        String s2 = "bcdefghijklmnopqrstuvwxyza";
        leetcode1153.canConvert(s1, s2);
    }

    /**
     * abcdefghijklmnopqrstuvwxyz->bbcdefghijklmnopqrstuvwxyz->cccdefghijklmnopqrstuvwxyz
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean canConvert(String s1, String s2) {
        if (s1.equals(s2)) return true;
        Map<Character, Character> dp = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            if (dp.getOrDefault(s1.charAt(i), s2.charAt(i)) != s2.charAt(i))
                return false;
            dp.put(s1.charAt(i), s2.charAt(i));
        }
        return new HashSet<Character>(dp.values()).size() < 26;
    }
}
