package com.github.leetcode.easy;

import java.util.HashSet;

/**
 * A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
 * <p>
 * Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "YazaAay"
 * Output: "aAa"
 * Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
 * "aAa" is the longest nice substring.
 * Example 2:
 * <p>
 * Input: s = "Bb"
 * Output: "Bb"
 * Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
 * Example 3:
 * <p>
 * Input: s = "c"
 * Output: ""
 * Explanation: There are no nice substrings.
 * Example 4:
 * <p>
 * Input: s = "dDzeE"
 * Output: "dD"
 * Explanation: Both "dD" and "eE" are the longest nice substrings.
 * As there are multiple longest nice substrings, return "dD" since it occurs earlier.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s consists of uppercase and lowercase English letters.
 */
public class Leetcode1763 {
    public String longestNiceSubstring(String s) {
        if(s.length()<2)
            return "";
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            hs.add(c);
        }
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(hs.contains(Character.toLowerCase(c)) && hs.contains(Character.toUpperCase(c)))
                continue;
            // 递归处理
            String sub1=longestNiceSubstring(s.substring(0,i));
            String sub2=longestNiceSubstring(s.substring(i+1));
            return sub1.length()>=sub2.length()?sub1:sub2;
        }
        return s;
    }
}
