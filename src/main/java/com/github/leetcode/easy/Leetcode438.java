package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class Leetcode438 {
    public static void main(String[] args) {
        Leetcode438 leetcode438 = new Leetcode438();
        leetcode438.findAnagrams("cbaebabacd", "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        //利用Arrays比较数组的是否相等以及类似滑动窗口协议
        List<Integer> list = new ArrayList<Integer>();
        if (p.length() > s.length()) return list;
        int[] pCount = new int[26];
        //字符串p由哪些字符组成
        for (char c : p.toCharArray())
            pCount[c - 'a']++;

        char[] sChars = s.toCharArray();
        int[] sCount = new int[26];

        //字符串前p位字符的组成
        for (int j = 0; j < p.length(); j++)
            sCount[sChars[j] - 'a']++;
        //
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (Arrays.equals(pCount, sCount))
                list.add(i);
            //左指针右移
            sCount[sChars[i] - 'a']--;
            //右指针前进一位
            if (i + p.length() < s.length()) {//防止地址溢出
                sCount[sChars[i + p.length()] - 'a']++;
            }
        }

        return list;
    }
}
